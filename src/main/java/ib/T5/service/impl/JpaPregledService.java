package ib.T5.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ib.T5.model.Korisnik;
import ib.T5.model.Pregled;
import ib.T5.repository.PregledRepository;
import ib.T5.service.PregledService;

@Service
public class JpaPregledService implements PregledService  {

	 @Autowired
	    private PregledRepository pregledRepository;

	    @Override
	    public Optional<Pregled> findOne(Long id) {
	        return pregledRepository.findById(id);
	    }

		@Override
		public List<Pregled> findAll() {
			return pregledRepository.findAll();
		}

		@Override
		public Pregled save(Pregled pregled) {
			return pregledRepository.save(pregled);
		}

		@Override
		public void delete(Long id) {
			pregledRepository.deleteById(id);
			
		}
		
		public boolean isDoctorOfPatient(Korisnik pacijent, Korisnik lekar) {
			
			
			for(Pregled p: findAll()) {
				if(p.getLekar().getId().equals(lekar.getId()) && p.getPacijent().getId().equals(pacijent.getId())) {
					return true;
				}
			}
			
			
			return false;
			
		}

}
