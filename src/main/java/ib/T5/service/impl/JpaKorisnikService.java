package ib.T5.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ib.T5.model.KorisnickaUloga;
import ib.T5.model.Korisnik;
import ib.T5.repository.KorisnikRepository;
import ib.T5.service.KorisnikService;
import ib.T5.web.dto.KorisnikDTO;
@Service
public class JpaKorisnikService implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    
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

	@Override
	public Optional<Korisnik> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Korisnik register(KorisnikDTO korisnikDTO) {
		
		Optional<Korisnik> korisnikOption = korisnikRepository.findOneByEmail(korisnikDTO.getEmail());
		
		
		if (korisnikOption.isPresent()) {
			return null;
		}
		
		
		Korisnik korisnik = new Korisnik();
		korisnik.setIme(korisnikDTO.getIme());
		korisnik.setPrezime(korisnikDTO.getPrezime());
		korisnik.setEmail(korisnikDTO.getEmail());
		korisnik.setAdresa(korisnikDTO.getAdresa());
		korisnik.setId(korisnikDTO.getId());
		korisnik.setLozinka(passwordEncoder.encode(korisnikDTO.getLozinka()));
		korisnik.setPregled(korisnikDTO.getPregled());
		korisnik.setLbo(Integer.parseInt(korisnikDTO.getLbo()));
		korisnik.setUloga(korisnikDTO.getKorisnickaUloga());
		
		
		return korisnikRepository.save(korisnik);
		
	}

}
