package ib.T5.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ib.T5.service.RoleService;
import ib.T5.support.RoleDtoToRole;
import ib.T5.support.RoleToRoleDto;
import ib.T5.web.dto.RoleDTO;
import ib.T5.model.Role;

@RestController
@RequestMapping(value = "/api/role", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController {
	
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private RoleDtoToRole toRole;
    
    @Autowired
    private RoleToRoleDto toRoleDto;
	
	  @GetMapping("/{id}")
	    public ResponseEntity<RoleDTO> get(@PathVariable Long id){
	        Optional<Role> role = roleService.findOne(id);
	        if(role.isPresent()) {
				return new ResponseEntity<>(toRoleDto.convert(role.get()), HttpStatus.OK);
				}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
	    }

}
