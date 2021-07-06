package ib.T5.support;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ib.T5.model.Pregled;
import ib.T5.service.PregledService;
import ib.T5.web.dto.PregledDTO;

@Component
public class PregledDtoToPregled implements Converter<PregledDTO, Pregled>{
	
	@Autowired
    private PregledService pregledService;
    
	@Override
    public Pregled convert(PregledDTO pregledDTO) {
        Pregled entity = null;

        if(pregledDTO.getId() == null) {
            entity = new Pregled();
        }else {
            Optional<Pregled> pregledOptional = pregledService.findOne(pregledDTO.getId());
            if(pregledOptional.isPresent()){
                entity = pregledOptional.get();
            }
        }

        if(entity != null) {
            entity.setOpis(pregledDTO.getOpis());
        }

        return entity;
    }


}
