package ib.T5.web.dto;

import java.util.Date;

public class KorisnikDTO {

    private Long id;
    private String email;
    private String ime;
    private String prezime;
    private String adresa;
    private Date pregled;
    private String lbo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Date getPregled() {
		return pregled;
	}

	public void setPregled(Date pregled) {
		this.pregled = pregled;
	}

	public String getLbo() {
		return lbo;
	}

	public void setLbo(String lbo) {
		this.lbo = lbo;
	}
	
	
    
}
