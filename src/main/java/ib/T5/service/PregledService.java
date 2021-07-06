package ib.T5.service;

import java.util.List;
import java.util.Optional;

import ib.T5.model.Korisnik;
import ib.T5.model.Pregled;


public interface PregledService {
	
	 Optional<Pregled> findOne(Long id);

	    List<Pregled> findAll();

	    Pregled save(Pregled pregled);

	    void delete(Long id);
	    
	    boolean isDoctorOfPatient(Korisnik pacijent, Korisnik lekar);

}
