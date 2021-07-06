package ib.T5.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ib.T5.model.KlinickiCentar;
import ib.T5.repository.KlinickiCentarRepository;
import ib.T5.repository.RoleRepository;
import ib.T5.service.KlinickiCentarService;
import ib.T5.service.RoleService;
import ib.T5.model.Role;

@Service
public class JpaRoleService implements RoleService {

	 @Autowired
	    private RoleRepository roleRepository;

	    @Override
	    public Optional<Role> findOne(Long id) {
	        return roleRepository.findById(id);
	    }

	    @Override
	    public Optional<Role> findbyNaziv(String naziv) {
	        return roleRepository.findFirstByNaziv(naziv );
	    }
}
