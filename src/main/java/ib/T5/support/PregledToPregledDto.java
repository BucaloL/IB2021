package ib.T5.support;

import java.util.ArrayList;
import java.util.Date;
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
		
		if(pregled.getDatum() == null) {
			pregledDTO.setDatum(new Date().toString());
		}
		else {
			pregledDTO.setDatum(pregled.getDatum().toString());
		}
		
		if(pregled.getLekar() != null) {
			pregledDTO.setLekar(pregled.getLekar().getId());	
		}
		
		if(pregled.getPacijent() != null) {
			pregledDTO.setPacijent(pregled.getPacijent().getId());	
		} 

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
