package ib.T5.web.dto;

public class ZdravstveniKartonDTO {

	private Long id;
	private String ime;
	private String opis;
	private Integer lbo;
	
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
	
	
}
