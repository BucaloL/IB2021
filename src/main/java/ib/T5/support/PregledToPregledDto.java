package ib.T5.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ib.T5.model.Pregled;
import ib.T5.web.dto.PregledDTO;


@Component
public class PregledToPregledDto {
	
	public PregledDTO convert( Pregled pregled) {
		PregledDTO pregledDTO = new PregledDTO();

		pregledDTO.setId(pregled.getId());
		pregledDTO.setOpis(pregled.getOpis());
		pregledDTO.setDatum(pregled.getDatum().toString());
        pregledDTO.setLekar(pregled.getLekar());

        return pregledDTO;
    }

    public List<PregledDTO> convert(List<Pregled> pregledi){
        List<PregledDTO> pregledDTOS = new ArrayList<>();

        for(Pregled p : pregledi) {
            PregledDTO dto = convert(p);
            pregledDTOS.add(dto);
        }

        return pregledDTOS;
    }

}
