package ib.T5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ib.T5.model.Permisije;

@Repository
public interface PermisijeRepository extends JpaRepository <Permisije, Long> {
	
	Optional<Permisije> findFirstByNaziv(String naziv);

}
