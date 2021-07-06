package ib.T5.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ib.T5.model.KlinickiCentar;
import ib.T5.model.ZdravstveniKarton;
import ib.T5.web.dto.KlinickiCentarDTO;
import ib.T5.web.dto.ZdravstveniKartonDTO;

@Component
public class ZdravstveniKartonToZdravstveniKartonDto {
	
	public ZdravstveniKartonDTO convert( ZdravstveniKarton zdravstveniKarton) {
		ZdravstveniKartonDTO zdravstveniKartonDTO = new ZdravstveniKartonDTO();

        zdravstveniKartonDTO.setId(zdravstveniKarton.getId());
        zdravstveniKartonDTO.setIme(zdravstveniKarton.getIme());
        zdravstveniKartonDTO.setOpis(zdravstveniKarton.getOpis());
        zdravstveniKartonDTO.setLbo(zdravstveniKarton.getLbo());

        return zdravstveniKartonDTO;
    }

    public List<ZdravstveniKartonDTO> convert(List<ZdravstveniKarton> kartonii){
        List<ZdravstveniKartonDTO> zdravstveniKartonDTOS = new ArrayList<>();

        for(ZdravstveniKarton zk : kartonii) {
        	ZdravstveniKartonDTO dto = convert(zk);
        	zdravstveniKartonDTOS.add(dto);
        }

        return zdravstveniKartonDTOS;
    }

}
