package ib.T5.web.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ib.T5.model.KlinickiCentar;
import ib.T5.model.Korisnik;
import ib.T5.service.KlinickiCentarService;
import ib.T5.service.KorisnikService;
import ib.T5.support.KlinickiCentarDtoToKlinickiCentar;
import ib.T5.support.KlinickiCentarToKlinickiCentarDto;
import ib.T5.support.KorisnikDtoToKorisnik;
import ib.T5.support.KorisnikToKorisnikDto;
import ib.T5.web.dto.KlinickiCentarDTO;
import ib.T5.web.dto.KorisnikDTO;
import ib.T5.web.dto.KorisnikRegistracijaDTO;

@RestController
@RequestMapping(value = "/api/klinicki-centar", produces = MediaType.APPLICATION_JSON_VALUE)
public class KlinickiCentarController {

    @Autowired
    private KlinickiCentarService klinickiCentarService;

    @Autowired
    private KlinickiCentarDtoToKlinickiCentar toKlinickiCentar;

    @Autowired
    private KlinickiCentarToKlinickiCentarDto toKlinickiCentarDto;


    @PreAuthorize("hasAuthority('ADMIN')")
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KlinickiCentarDTO> update(@PathVariable Long id, @RequestBody KlinickiCentarDTO klinickiCentarDTO){

        if(!id.equals(klinickiCentarDTO.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        KlinickiCentar klinickiCentar= toKlinickiCentar.convert(klinickiCentarDTO);

        return new ResponseEntity<>(toKlinickiCentarDto.convert(klinickiCentarService.save(klinickiCentar)),HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<KlinickiCentarDTO> create(@RequestBody KlinickiCentarDTO klinickiCentarDTO){

        KlinickiCentar klinickiCentar= toKlinickiCentar.convert(klinickiCentarDTO);

        return new ResponseEntity<>(toKlinickiCentarDto.convert(klinickiCentarService.save(klinickiCentar)),HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<KlinickiCentarDTO> get(@PathVariable Long id){
        Optional<KlinickiCentar> klinickiCentar= klinickiCentarService.findOne(id);

        if(klinickiCentar.isPresent()) {
            return new ResponseEntity<>(toKlinickiCentarDto.convert(klinickiCentar.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
