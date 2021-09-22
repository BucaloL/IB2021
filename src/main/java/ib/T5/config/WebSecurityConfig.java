package ib.T5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import ib.T5.security.CustomUserDetailsService;
import ib.T5.security.RestAuthenticationEntryPoint;
import ib.T5.security.TokenAuthenticationFilter;
import ib.T5.security.TokenUtil;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Autowired
	private CustomUserDetailsService jwtUserDetailsService;
	
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint ;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean () throws Exception {
		return super.authenticationManager();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	@Autowired
	private TokenUtil tokenUtils;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//		.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
////		.authorizeRequests().antMatchers("/api/korisnici/register").permitAll()
//		.authorizeRequests().anyRequest().authenticated().and()
//		.formLogin().loginPage("/login").permitAll().and()
//		.logout().permitAll().and()
//		.cors().and()
//		.httpBasic().and()
//		.addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService), BasicAuthenticationFilter.class);
//	http.csrf().disable();
	
	 http
	 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	 .authorizeRequests().antMatchers("/api/klinicki-centar").permitAll()
     .anyRequest().authenticated().and()
     .cors().and().
     httpBasic().and().addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService), BasicAuthenticationFilter.class);
	 
	 http.csrf().disable();
	}
	
	@Override
	public void configure (WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.POST, "/api/korisnici/register");
		web.ignoring().antMatchers(HttpMethod.POST, "/api/korisnici/login");
		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
	}
	

}
