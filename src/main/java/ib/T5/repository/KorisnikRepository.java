package ib.T5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ib.T5.model.Korisnik;

import java.util.Optional;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Optional<Korisnik> findFirstByEmail(String email);
    Optional<Korisnik> findOneByEmail(String email);

    Optional<Korisnik> findFirstByImeAndLozinka(String ime,String lozinka);
}
