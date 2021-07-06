package ib.T5.support;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ib.T5.model.ZdravstveniKarton;
import ib.T5.service.ZdravstveniKartonService;
import ib.T5.web.dto.ZdravstveniKartonDTO;

@Component
public class ZdravstveniKartonDtoToZdravstveniKarton implements Converter<ZdravstveniKartonDTO, ZdravstveniKarton> {
	

    @Autowired
    private ZdravstveniKartonService zdravstveniKartonService;

    @Override
    public ZdravstveniKarton convert(ZdravstveniKartonDTO zdravstveniKartonDTO) {
        ZdravstveniKarton entity = null;

        if(zdravstveniKartonDTO.getId() == null) {
            entity = new ZdravstveniKarton();
        }else {
            Optional<ZdravstveniKarton> zdravstveniKartonOptional = zdravstveniKartonService.findOne(zdravstveniKartonDTO.getId());
            if(zdravstveniKartonOptional.isPresent()){
                entity = zdravstveniKartonOptional.get();
            }
        }

        if(entity != null) {
            entity.setIme(zdravstveniKartonDTO.getIme());
            
        }

        return entity;
    }


}
