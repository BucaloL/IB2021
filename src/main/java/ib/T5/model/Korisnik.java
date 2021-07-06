package ib.T5.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(nullable = false)
    private String lozinka;

    @Enumerated(EnumType.STRING)
    private KorisnickaUloga uloga;

    @Column
    private String adresa;
    @Column
    private Date pregled;
    @Column
    private Integer lbo;
   
    public Korisnik(){

    }

    public Korisnik(String email, String ime, String prezime, String lozinka, KorisnickaUloga uloga,
    		String adresa, Date pregled, Integer lbo) {
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.uloga = uloga;
        this.adresa = adresa;
        this.pregled = pregled;
        this.lbo = lbo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    

    
    public String getemail() {
        return email;
    }

    public void setemail(String email) {
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

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public KorisnickaUloga getUloga() {
        return uloga;
    }

    public void setUloga(KorisnickaUloga uloga) {
        this.uloga = uloga;
    }
    
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    

    public Integer getLbo() {
		return lbo;
	}

	public void setLbo(Integer lbo) {
		this.lbo = lbo;
	}

	public Date getPregled() {
		return pregled;
	}

	public void setPregled(Date pregled) {
		this.pregled = pregled;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Korisnik other = (Korisnik) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Korisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + "]";
    }

}
