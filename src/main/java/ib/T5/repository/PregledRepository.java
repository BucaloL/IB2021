package ib.T5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ib.T5.model.Pregled;
@Repository
public interface PregledRepository extends JpaRepository<Pregled, Long> {

}
