package ib.T5.service;

import java.util.Optional;

import ib.T5.model.KlinickiCentar;
import ib.T5.model.Permisije;

public interface PermisijeService {
	
	Optional<Permisije> findOne(Long id);
	
	Optional<Permisije> findbyNaziv(String naziv);

}
