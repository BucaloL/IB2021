package ib.T5.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ib.T5.web.dto.PermisijeDTO;
import ib.T5.model.Permisije;

@Component
public class PermisijeToPermisijeDto {
	
	public PermisijeDTO convert( Permisije permisije) {
		PermisijeDTO permisijeDTO = new PermisijeDTO();

        permisijeDTO.setId(permisije.getId());
        permisijeDTO.setNaziv(permisije.getNaziv());

        return permisijeDTO;
    }

    public List<PermisijeDTO> convert(List<Permisije> permisijee){
        List<PermisijeDTO> permisijeDTOS = new ArrayList<>();
        for(Permisije permisije : permisijee) {
        	PermisijeDTO dto = convert(permisije);
        	permisijeDTOS.add(dto);
        }

        return permisijeDTOS;
    }

}
