package ib.T5.web.dto;

import java.util.Date;

public class KlinickiCentarDTO {

	private Long id;
	private String naziv;
	private String adresa;
	private String spisakLekara;
	private Date slobodniTermini;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getSpisakLekara() {
		return spisakLekara;
	}
	public void setSpisakLekara(String spisakLekara) {
		this.spisakLekara = spisakLekara;
	}
	public Date getSlobodniTermini() {
		return slobodniTermini;
	}
	public void setSlobodniTermini(Date slobodniTermini) {
		this.slobodniTermini = slobodniTermini;
	}
	
	
}
