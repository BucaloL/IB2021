package ib.T5.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ib.T5.model.Korisnik;
import ib.T5.model.Pregled;
import ib.T5.model.ZdravstveniKarton;
import ib.T5.service.PregledService;
import ib.T5.service.ZdravstveniKartonService;
import ib.T5.support.ZdravstveniKartonDtoToZdravstveniKarton;
import ib.T5.support.ZdravstveniKartonToZdravstveniKartonDto;
import ib.T5.web.dto.KorisnikDTO;
import ib.T5.web.dto.PregledDTO;
import ib.T5.web.dto.ZdravstveniKartonDTO;

@RestController
@RequestMapping(value = "/api/zdravstveni-karton", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZdravstveniKartonController {

	@Autowired
	private ZdravstveniKartonService zdravstveniKartonService;

	@Autowired
	private ZdravstveniKartonDtoToZdravstveniKarton toZdravstveniKarton;

	@Autowired
	private ZdravstveniKartonToZdravstveniKartonDto toZdravstveniKartonDto;

	@Autowired
	private PregledService pregledService;

	
	@PreAuthorize("hasAuthority('ADMIN', 'LEKAR', 'MEDSESTRA')")
	//@PreAuthorize("hasAnyRole('ROLE_LEKAR', 'ROLE_MEDSESTRA','ROLE_ADMIN' )")
	@GetMapping
	public ResponseEntity<List<ZdravstveniKartonDTO>> get() {

		List<ZdravstveniKarton> kartoni = zdravstveniKartonService.findAll();
		return new ResponseEntity<>(toZdravstveniKartonDto.convert(kartoni), HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('LEKAR')")
	//@PreAuthorize("hasRole('LEKAR')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ZdravstveniKartonDTO> update(@PathVariable Long id,
			@RequestBody ZdravstveniKartonDTO zdravstveniKartonDTO) {

		if (!id.equals(zdravstveniKartonDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Optional<ZdravstveniKarton> zk = zdravstveniKartonService.findOne(id);

		if (!pregledService.isDoctorOfPatient(zk.get().getPacijent(), null)) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}

		ZdravstveniKarton zdravstveniKarton = toZdravstveniKarton.convert(zdravstveniKartonDTO);

		return new ResponseEntity<>(toZdravstveniKartonDto.convert(zdravstveniKartonService.save(zdravstveniKarton)),
				HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ADMIN', 'LEKAR', 'MEDSESTRA', 'PACIJENT')")
	//@PreAuthorize("hasAnyRole('ROLE_LEKAR', 'ROLE_MEDSESTRA','ROLE_ADMIN','ROLE_PACIJENT' )")
	@GetMapping("/{id}")
	public ResponseEntity<ZdravstveniKartonDTO> get(@PathVariable Long id) {
		Optional<ZdravstveniKarton> zdravstveniKarton = zdravstveniKartonService.findOne(id);

		if (zdravstveniKarton.isPresent()) {

			if (!pregledService.isDoctorOfPatient(zdravstveniKarton.get().getPacijent(), null)) {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}

			return new ResponseEntity<>(toZdravstveniKartonDto.convert(zdravstveniKarton.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
