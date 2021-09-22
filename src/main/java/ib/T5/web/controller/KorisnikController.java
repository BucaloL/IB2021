package ib.T5.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ib.T5.model.Korisnik;
import ib.T5.security.CustomUserDetailsService;
import ib.T5.security.TokenUtil;
import ib.T5.service.KorisnikService;
import ib.T5.support.KorisnikDtoToKorisnik;
import ib.T5.support.KorisnikToKorisnikDto;
import ib.T5.web.dto.KorisnikDTO;
import ib.T5.web.dto.KorisnikRegistracijaDTO;
import ib.T5.web.dto.LoginDTO;
import ib.T5.web.dto.LoginResponseDTO;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/korisnici", produces = MediaType.APPLICATION_JSON_VALUE)
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private KorisnikDtoToKorisnik toKorisnik;

    @Autowired
    private KorisnikToKorisnikDto toKorisnikDto;


    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping
    public ResponseEntity<KorisnikDTO> create(@RequestBody @Validated KorisnikRegistracijaDTO dto){

        if(dto.getId() != null || !dto.getLozinka().equals(dto.getPonovljenaLozinka())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // KorisnikRegistracijaDTO nasleđuje KorisnikDTO, pa možemo koristiti konverter za njega
        // ostaje da dodatno konvertujemo polje kojeg u njemu nema - password
        Korisnik korisnik = toKorisnik.convert(dto);

        String encodedPassword = passwordEncoder.encode(dto.getLozinka());
        korisnik.setLozinka(encodedPassword);

        return new ResponseEntity<>(toKorisnikDto.convert(korisnikService.save(korisnik)), HttpStatus.CREATED);
    }
    
    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
    
    	TokenUtil tokenUtil = new TokenUtil();
    	
    	Korisnik korisnik = customUserDetailsService.findUserByEmail(loginDTO.getEmail());
    	
    	if(korisnik == null || !passwordEncoder.matches(loginDTO.getLozinka(),korisnik.getLozinka())) {
    		return ResponseEntity.ok(HttpStatus.UNAUTHORIZED);
    	}
    	
    	String token = tokenUtil.generateToken(korisnik.getEmail(), korisnik.getUloga().toString());
    	LoginResponseDTO responseDTO =new LoginResponseDTO();
    	responseDTO.setToken(token);
    	return ResponseEntity.ok(responseDTO);
    	}
    
    @PostMapping(path = "/register")
    public ResponseEntity<?> register (@RequestBody KorisnikDTO korisnikDTO) {
    	Korisnik korisnik = korisnikService.register(korisnikDTO);
    	
    	if(korisnik == null) {
    		
    		return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    	}
    	return new ResponseEntity<> (korisnik, HttpStatus.OK);
    }

    
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PACIJENT', 'LEKAR', 'MEDSESTRA')")
    //@PreAuthorize("hasAnyRole('ROLE_PACIJENT', 'ROLE_ADMIN', 'ROLE_LEKAR','ROLE_MEDSESTRA')")
    @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> update(@PathVariable Long id, @RequestBody KorisnikDTO korisnikDTO){

        if(!id.equals(korisnikDTO.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Korisnik korisnik = toKorisnik.convert(korisnikDTO);

        return new ResponseEntity<>(toKorisnikDto.convert(korisnikService.save(korisnik)),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PACIJENT', 'LEKAR', 'MEDSESTRA')")
    //@PreAuthorize("hasAnyRole('ROLE_MEDSESTRA', 'ROLE_ADMIN', 'ROLE_LEKAR')")
    @GetMapping("/{id}")
    public ResponseEntity<KorisnikDTO> get(@PathVariable Long id){
        Optional<Korisnik> korisnik = korisnikService.findOne(id);

        if(korisnik.isPresent()) {
            return new ResponseEntity<>(toKorisnikDto.convert(korisnik.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'LEKAR', 'MEDSESTRA')")
    //@PreAuthorize("hasAnyRole('ROLE_LEKAR', 'ROLE_MEDSESTRA','ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<KorisnikDTO>> get(){
        List<Korisnik> korisnici = korisnikService.findAll();
        return new ResponseEntity<>(toKorisnikDto.convert(korisnici), HttpStatus.OK);
    }


}
