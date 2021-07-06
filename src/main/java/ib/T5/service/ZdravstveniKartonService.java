package ib.T5.service;

import java.util.List;
import java.util.Optional;

import ib.T5.model.KlinickiCentar;
import ib.T5.model.ZdravstveniKarton;

public interface ZdravstveniKartonService {
	
	Optional<ZdravstveniKarton> findOne(Long id);

    List<ZdravstveniKarton> findAll();

    ZdravstveniKarton save(ZdravstveniKarton zdravstveniKarton);

    void delete(Long id);

    Optional<ZdravstveniKarton> findbyIme(String ime);

}
