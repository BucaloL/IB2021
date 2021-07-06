package ib.T5.service;

import java.util.Optional;

import ib.T5.model.KlinickiCentar;
import ib.T5.model.Role;

public interface RoleService {

	Optional<Role> findOne(Long id);
	
	Optional<Role> findbyNaziv(String naziv);
}
