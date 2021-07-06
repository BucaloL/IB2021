package ib.T5.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ib.T5.model.KlinickiCentar;
import ib.T5.repository.KlinickiCentarRepository;
import ib.T5.service.KlinickiCentarService;


@Service
public class JpaKlinickiCentarService implements KlinickiCentarService {

    @Autowired
    private KlinickiCentarRepository klinickiCentarRepository;

    @Override
    public Optional<KlinickiCentar> findOne(Long id) {
        return klinickiCentarRepository.findById(id);
    }

    @Override
    public Optional<KlinickiCentar> findbyNaziv(String naziv) {
        return klinickiCentarRepository.findFirstByNaziv(naziv );
    }

	@Override
	public List<KlinickiCentar> findAll() {
		return klinickiCentarRepository.findAll();
	}

	@Override
	public KlinickiCentar save(KlinickiCentar klinickiCentar) {
		return klinickiCentarRepository.save(klinickiCentar);
	}

	@Override
	public void delete(Long id) {
		klinickiCentarRepository.deleteById(id);
		
	}

}

