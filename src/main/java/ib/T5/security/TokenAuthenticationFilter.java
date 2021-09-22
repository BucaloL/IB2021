package ib.T5.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

public class TokenAuthenticationFilter extends OncePerRequestFilter{
	
	private TokenUtil tokenUtils;
	private CustomUserDetailsService userDetailsService;
	
	public TokenAuthenticationFilter(TokenUtil tokenHelpter, UserDetailsService userDetailsService) {
		this.tokenUtils = tokenHelpter;
		this.userDetailsService = (CustomUserDetailsService) userDetailsService;
	}
	
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
		throws IOException , ServletException {
		
		String email;
		String authToken = tokenUtils.getToken(request);
		
		if (authToken != null) {
			email = tokenUtils.getEmailsFromToken(authToken);
			
			if(email != null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(email);
				
				if (tokenUtils.validateToken (authToken,userDetails)) {
					Collection<? extends GrantedAuthority> authorities = userDetailsService.getAuthoritiesFromUserDetails(userDetails);
							TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails,authorities);
							authentication.setToken(authToken);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				
					}
				}
			}
		
		chain.doFilter(request, response);
		}

}
