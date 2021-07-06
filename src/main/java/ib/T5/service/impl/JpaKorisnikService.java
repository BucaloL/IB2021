package ib.T5.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ib.T5.model.KorisnickaUloga;
import ib.T5.model.Korisnik;
import ib.T5.repository.KorisnikRepository;
import ib.T5.service.KorisnikService;
@Service
public class JpaKorisnikService implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    
    public Optional<Korisnik> findOne(Long id) {
        return korisnikRepository.findById(id);
    }
    
    @Override
    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }
    
    @Override
    public Korisnik save(Korisnik korisnik) {
        korisnik.setUloga(KorisnickaUloga.PACIJENT);
        return korisnikRepository.save(korisnik);
    }

    @Override
    public void delete(Long id) {
        korisnikRepository.deleteById(id);
    }

	@Override
	public Page<Korisnik> findAll(int brojStranice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Korisnik> findbyIme(String ime) {
		// TODO Auto-generated method stub
		return null;
	}

}
