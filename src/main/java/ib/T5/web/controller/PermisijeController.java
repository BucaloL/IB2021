package ib.T5.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ib.T5.service.PermisijeService;
import ib.T5.support.PermisijeDtoToPermisije;
import ib.T5.support.PermisijeToPermisijeDto;
import ib.T5.web.dto.PermisijeDTO;
import ib.T5.model.Permisije;
@RestController
@RequestMapping(value = "/api/permisisje", produces = MediaType.APPLICATION_JSON_VALUE)
public class PermisijeController {

	@Autowired
	private PermisijeService permisijeService;
	
	 @Autowired
	 private PermisijeDtoToPermisije toPermisije;
	 
	 @Autowired
	 private PermisijeToPermisijeDto toPermisijeDto;

//	@GetMapping
//	public ResponseEntity<PermisijeDTO> get(@PathVariable Long id){
//		Optional<Permisije> permisije = permisijeService.findOne(id);
//		if(permisije.isPresent()) {
//			return new ResponseEntity<>(toPermisijeDto.convert(permisije.get()), HttpStatus.OK);
//			}
//		else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//		}
}
