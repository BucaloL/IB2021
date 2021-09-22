package ib.T5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import ib.T5.model.KlinickiCentar;


public interface KlinickiCentarService {

	 Optional<KlinickiCentar> findOne(Long id);

	    List<KlinickiCentar> findAll();

	    KlinickiCentar save(KlinickiCentar klinickiCentar);

	    void delete(Long id);

	    Optional<KlinickiCentar> findbyNaziv(String naziv);
	    
	    
}
