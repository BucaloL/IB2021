package ib.T5.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ib.T5.model.Korisnik;
import ib.T5.repository.KorisnikRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private KorisnikRepository userRepository;
	
	@Autowired
	public CustomUserDetailsService(KorisnikRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Korisnik> user = userRepository.findFirstByEmail(username);
		org.springframework.security.core.userdetails.User.UserBuilder builder = null;
		
		if (!user.isPresent()) {
			throw new UsernameNotFoundException("NOT FOUND");
			
		}
		
		builder = org.springframework.security.core.userdetails.User.withUsername(username);
		String password = user.get().getLozinka();
		
		builder.password(password);
		builder.authorities(user.get().getUloga().toString());
		
		return builder.build();
	}

}
