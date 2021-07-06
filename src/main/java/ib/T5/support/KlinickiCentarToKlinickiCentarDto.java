package ib.T5.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ib.T5.model.KlinickiCentar;
import ib.T5.web.dto.KlinickiCentarDTO;

@Component
public class KlinickiCentarToKlinickiCentarDto {
	
	public KlinickiCentarDTO convert( KlinickiCentar klinickiCentar) {
		KlinickiCentarDTO klinickiCentarDTO = new KlinickiCentarDTO();

        klinickiCentarDTO.setId(klinickiCentar.getId());
        klinickiCentarDTO.setNaziv(klinickiCentar.getNaziv());
        klinickiCentarDTO.setAdresa(klinickiCentar.getAdresa());
        klinickiCentarDTO.setSpisakLekara(klinickiCentar.getSpisakLekara());
        klinickiCentarDTO.setSlobodniTermini(klinickiCentar.getSlobodniTermini());

        return klinickiCentarDTO;
    }

    public List<KlinickiCentarDTO> convert(List<KlinickiCentar> klinickiCentarr){
        List<KlinickiCentarDTO> klinickiCentarDTOS = new ArrayList<>();

        for(KlinickiCentar kc : klinickiCentarr) {
            KlinickiCentarDTO dto = convert(kc);
            klinickiCentarDTOS.add(dto);
        }

        return klinickiCentarDTOS;
    }
}