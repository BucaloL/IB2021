package ib.T5.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ib.T5.repository.PermisijeRepository;
import ib.T5.service.PermisijeService;
import ib.T5.model.Permisije;


@Service
public class JpaPermisijeService implements PermisijeService {

	 @Autowired
	 private PermisijeRepository permisijeRepository;
	 @Override
	 public Optional<Permisije> findOne(Long id) {
		 return permisijeRepository.findById(id);
		 }

	 @Override
	 public Optional<Permisije> findbyNaziv(String naziv) {
		 return permisijeRepository.findFirstByNaziv(naziv );
		 }
}
