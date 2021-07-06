package ib.T5.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ib.T5.model.ZdravstveniKarton;
import ib.T5.repository.ZdravstveniKartonRepository;
import ib.T5.service.ZdravstveniKartonService;

@Service
public class JpaZdravstveniKartonService implements ZdravstveniKartonService {
	
    @Autowired
    private ZdravstveniKartonRepository zdravstveniKartonRepository;

    @Override
    public Optional<ZdravstveniKarton> findOne(Long id) {
        return zdravstveniKartonRepository.findById(id);
    }

    @Override
    public Optional<ZdravstveniKarton> findbyIme(String ime) {
        return zdravstveniKartonRepository.findFirstByIme(ime );
    }

	@Override
	public List<ZdravstveniKarton> findAll() {
		return zdravstveniKartonRepository.findAll();
	}

	@Override
	public ZdravstveniKarton save(ZdravstveniKarton zdravstveniKarton) {
		return zdravstveniKartonRepository.save(zdravstveniKarton);
	}

	@Override
	public void delete(Long id) {
		zdravstveniKartonRepository.deleteById(id);
		
	}

}
