package ib.T5.web.dto;

import java.util.Date;

import ib.T5.model.Korisnik;

public class PregledDTO {
	
	private Long id;
	private String opis;
	private String datum;
	private Long lekar;
	private Long pacijent;
	
	public PregledDTO() {}
	
	public PregledDTO(Long id, String opis, String datum, Long lekar, Long pacijent) {
		super();
		this.id = id;
		this.opis = opis;
		this.datum = datum;
		this.lekar = lekar;
		this.pacijent = pacijent;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public Long getLekar() {
		return lekar;
	}
	public void setLekar(Long lekar) {
		this.lekar = lekar;
	}
	public Long getPacijent() {
		return pacijent;
	}
	public void setPacijent(Long pacijent) {
		this.pacijent = pacijent;
	}
	
	
	
	

}
