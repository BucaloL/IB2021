package ib.T5.web.dto;

import java.util.Date;

import ib.T5.model.Korisnik;

public class PregledDTO {
	
	private Long id;
	private String opis;
	private String datum;
	private Korisnik lekar;
	private Korisnik pacijent;
	
	public PregledDTO() {}
	
	public PregledDTO(Long id, String opis, String datum, Korisnik lekar, Korisnik pacijent) {
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
	public Korisnik getLekar() {
		return lekar;
	}
	public void setLekar(Korisnik lekar) {
		this.lekar = lekar;
	}
	public Korisnik getPacijent() {
		return pacijent;
	}
	public void setPacijent(Korisnik pacijent) {
		this.pacijent = pacijent;
	}
	
	
	
	

}
