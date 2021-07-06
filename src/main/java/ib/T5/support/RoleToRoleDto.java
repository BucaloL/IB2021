package ib.T5.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ib.T5.web.dto.RoleDTO;
import ib.T5.model.Role;

@Component
public class RoleToRoleDto {
	
	public RoleDTO convert( Role role) {
		RoleDTO roleDTO = new RoleDTO();

		roleDTO.setId(role.getId());
		roleDTO.setNaziv(role.getNaziv());
        
        return roleDTO;
    }

    public List<RoleDTO> convert(List<Role> rolee){
        List<RoleDTO> roleDTOS = new ArrayList<>();

        for(Role role : rolee) {
        	RoleDTO dto = convert(role);
        	roleDTOS.add(dto);
        }

        return roleDTOS;
    }

}
