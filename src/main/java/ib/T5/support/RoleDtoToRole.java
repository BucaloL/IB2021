package ib.T5.support;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ib.T5.model.KlinickiCentar;
import ib.T5.service.KlinickiCentarService;
import ib.T5.service.RoleService;
import ib.T5.web.dto.KlinickiCentarDTO;
import ib.T5.web.dto.RoleDTO;
import ib.T5.model.Role;

@Component
public class RoleDtoToRole implements Converter<RoleDTO, Role> {

    @Autowired
    private RoleService roleService;

    @Override
    public Role convert(RoleDTO roleDTO) {
        Role entity = null;

        if(roleDTO.getId() == null) {
            entity = new Role();
        }else {
            Optional<Role> roleOptional = roleService.findOne(roleDTO.getId());
            if(roleOptional.isPresent()){
                entity = roleOptional.get();
            }
        }

        if(entity != null) {
            entity.setNaziv(roleDTO.getNaziv());
        }

        return entity;
    }

}

