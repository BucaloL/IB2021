package ib.T5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ib.T5.model.ZdravstveniKarton;

@Repository
public interface ZdravstveniKartonRepository extends JpaRepository<ZdravstveniKarton, Long>{
	
	Optional<ZdravstveniKarton> findFirstByIme(String ime);

}
