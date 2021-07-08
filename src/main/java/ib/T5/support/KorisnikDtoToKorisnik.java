package ib.T5.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import ib.T5.model.Korisnik;
import ib.T5.service.KorisnikService;
import ib.T5.web.dto.KorisnikDTO;
import ib.T5.web.dto.KorisnikRegistracijaDTO;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Component
public class KorisnikDtoToKorisnik implements Converter<KorisnikDTO, Korisnik> {

    @Autowired
    private KorisnikService korisnikService;

    @Override
    public Korisnik convert(KorisnikDTO korisnikDTO) {
        Korisnik entity = null;

        if(korisnikDTO.getId() == null) {
            entity = new Korisnik();
        }else {
            Optional<Korisnik> korisnikOptional = korisnikService.findOne(korisnikDTO.getId());
            if(korisnikOptional.isPresent()){
                entity = korisnikOptional.get();
            }
        }

        if(entity != null) {
            //entity.setsetKorisnickoIme(korisnikDTO.getKorisnickoIme());
            entity.setEmail(korisnikDTO.getEmail());
            entity.setIme(korisnikDTO.getIme());
            entity.setPrezime(korisnikDTO.getPrezime());
            entity.setAdresa(korisnikDTO.getAdresa());
            entity.setLbo(Integer.parseInt(korisnikDTO.getLbo()));
            
        }

        return entity;
    }

}
