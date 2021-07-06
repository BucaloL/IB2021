package ib.T5.model;

import java.util.Date;
import javax.persistence.*;

@Entity
public class KlinickiCentar {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String naziv;
	@Column
	private String adresa;
	@Column
	private String spisakLekara;
	@Column
	private Date slobodniTermini;
	
	
	public KlinickiCentar(Long id, String naziv, String adresa, String spisakLekara, Date slobodniTermini) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.spisakLekara = spisakLekara;
		this.slobodniTermini = slobodniTermini;
	}
	
	  public KlinickiCentar(){

	    }


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
	

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        KlinickiCentar other = (KlinickiCentar) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "KlinickiCentar [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + "]";
    }
	
	
	

}
