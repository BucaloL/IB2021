package ib.T5.support;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ib.T5.service.PermisijeService;

import ib.T5.web.dto.PermisijeDTO;
import ib.T5.model.Permisije;

@Component
public class PermisijeDtoToPermisije implements Converter<PermisijeDTO, Permisije> {

    @Autowired
    private PermisijeService permisijeService;

    @Override
    public Permisije convert(PermisijeDTO permisijeDTO) {
        Permisije entity = null;

        if(permisijeDTO.getId() == null) {
            entity = new Permisije();
        }else {
            Optional<Permisije> permisijeOptional = permisijeService.findOne(permisijeDTO.getId());
            if(permisijeOptional.isPresent()){
                entity = permisijeOptional.get();
            }
        }

        if(entity != null) {
            entity.setNaziv(permisijeDTO.getNaziv());
        }

        return entity;
    }

}
