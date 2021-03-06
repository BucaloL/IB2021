package ib.T5.service;

import ib.T5.model.Korisnik;
import ib.T5.web.dto.KorisnikDTO;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {

    Optional<Korisnik> findOne(Long id);

    List<Korisnik> findAll();

    Page<Korisnik> findAll(int brojStranice);

    Korisnik save(Korisnik korisnik);

    void delete(Long id);

    Optional<Korisnik> findbyIme(String ime);
    
    Optional<Korisnik> findUserByEmail (String email);
    
    Korisnik register(KorisnikDTO korisnikDTO);

}
