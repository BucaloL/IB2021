package ib.T5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ZdravstveniKarton {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String ime;
	@Column
	private Integer lbo;
	@Column
	private String opis;
	@ManyToOne
	private Korisnik pacijent;
	
	public ZdravstveniKarton () {}
	
	public ZdravstveniKarton(Long id, String ime, Integer lbo, String opis) {
		super();
		this.id = id;
		this.ime = ime;
		this.lbo = lbo;
		this.opis = opis;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Integer getLbo() {
		return lbo;
	}

	public void setLbo(Integer lbo) {
		this.lbo = lbo;
	}

	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Korisnik getPacijent() {
		return pacijent;
	}

	public void setPacijent(Korisnik pacijent) {
		this.pacijent = pacijent;
	}

}
