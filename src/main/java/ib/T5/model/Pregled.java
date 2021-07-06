package ib.T5.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pregled {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String opis;
	@Column
	private Date datum;
	
	@ManyToOne
	private Korisnik lekar;
	
	@ManyToOne
	private Korisnik pacijent;
	
	public Pregled() {
		super();
	}


	public Pregled(Long id, String opis, Date datum, Korisnik lekar,Korisnik pacijent) {
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


	public Date getDatum() {
		return datum;
	}


	public void setDatum(Date datum) {
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
