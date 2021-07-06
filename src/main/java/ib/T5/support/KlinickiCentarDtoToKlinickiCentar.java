package ib.T5.support;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ib.T5.model.KlinickiCentar;
import ib.T5.service.KlinickiCentarService;
import ib.T5.web.dto.KlinickiCentarDTO;


@Component
public class KlinickiCentarDtoToKlinickiCentar implements Converter<KlinickiCentarDTO, KlinickiCentar> {

    @Autowired
    private KlinickiCentarService klinickiCentarService;

    @Override
    public KlinickiCentar convert(KlinickiCentarDTO klinickiCentarDTO) {
        KlinickiCentar entity = null;

        if(klinickiCentarDTO.getId() == null) {
            entity = new KlinickiCentar();
        }else {
            Optional<KlinickiCentar> klinickiCentarOptional = klinickiCentarService.findOne(klinickiCentarDTO.getId());
            if(klinickiCentarOptional.isPresent()){
                entity = klinickiCentarOptional.get();
            }
        }

        if(entity != null) {
            entity.setNaziv(klinickiCentarDTO.getNaziv());
            entity.setAdresa(klinickiCentarDTO.getAdresa());
        }

        return entity;
    }

}

