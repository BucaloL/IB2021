package ib.T5.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
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
		String uloga = user.get().getUloga().toString();
		builder.authorities(uloga);
		
		return builder.build();
	}
	
	public Collection<? extends GrantedAuthority> getAuthoritiesFromUserDetails(UserDetails principle) {
		List<Authority> authorities = new ArrayList<>();
		
		Optional<Korisnik> user = userRepository.findOneByEmail(principle.getUsername());
		
		if(!user.isPresent()) {
			return authorities;
		}
		
		Authority authority = new Authority();
		authority.setName(user.get().getUloga().toString());
		
		authorities.add(authority);
		
		return authorities;
		
	
	}
	
	public Korisnik findUserByEmail(String email) {
		return userRepository.findOneByEmail(email).get();
	}
}
