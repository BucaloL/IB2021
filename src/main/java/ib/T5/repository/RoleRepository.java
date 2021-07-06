package ib.T5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ib.T5.model.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
	
	Optional<Role> findFirstByNaziv(String naziv);

}
