package ib.T5.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ib.T5.model.KlinickiCentar;
import ib.T5.model.Korisnik;
import ib.T5.model.Pregled;
import ib.T5.repository.KorisnikRepository;
import ib.T5.service.PregledService;
import ib.T5.support.PregledDtoToPregled;
import ib.T5.support.PregledToPregledDto;
import ib.T5.web.dto.KlinickiCentarDTO;
import ib.T5.web.dto.KorisnikDTO;
import ib.T5.web.dto.PregledDTO;

@RestController
@RequestMapping(value = "/api/pregled", produces = MediaType.APPLICATION_JSON_VALUE)
public class PregledController {
	
	 @Autowired
	    private PregledService pregledService;

	    @Autowired
	    private PregledDtoToPregled toPregled;

	    @Autowired
	    private PregledToPregledDto toPregledDto;

	    @Autowired
	    private KorisnikRepository korisnikRepository;

	    
	    @PreAuthorize("hasAuthority('LEKAR')")
	    @PostMapping
	    public ResponseEntity<PregledDTO> create(@RequestBody PregledDTO pregledDTO){

	    	Pregled pregled = toPregled.convert(pregledDTO);

	    	pregled.setLekar(korisnikRepository.getOne(pregledDTO.getLekar()));
	    	pregled.setPacijent(korisnikRepository.getOne(pregledDTO.getPacijent()));
	        
	    	return new ResponseEntity<>(toPregledDto.convert(pregledService.save(pregled)),HttpStatus.OK);
	    }
	    
	    @PreAuthorize("hasAuthority('LEKAR')")
	    //@PreAuthorize("hasRole('LEKAR')")
	    @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<PregledDTO> update(@PathVariable Long id, @RequestBody PregledDTO pregledDTO){

	        if(!id.equals(pregledDTO.getId())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Pregled pregled= toPregled.convert(pregledDTO);

	        return new ResponseEntity<>(toPregledDto.convert(pregledService.save(pregled)),HttpStatus.OK);
	    }

	    @PreAuthorize("hasAuthority('LEKAR')")
	    //@PreAuthorize("hasRole('LEKAR')")
	    @GetMapping("/{id}")
	    public ResponseEntity<PregledDTO> get(@PathVariable Long id){
	        Optional<Pregled> pregled= pregledService.findOne(id);

	        if(pregled.isPresent()) {
	            return new ResponseEntity<>(toPregledDto.convert(pregled.get()), HttpStatus.OK);
	        }
	        else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @PreAuthorize("hasAuthority('LEKAR')")
	    //@PreAuthorize("hasRole('LEKAR')")
	    @GetMapping
	    public ResponseEntity<List<PregledDTO>> get(){
	        List<Pregled> pregledi = pregledService.findAll();
	        return new ResponseEntity<>(toPregledDto.convert(pregledi), HttpStatus.OK);
	    }


}
