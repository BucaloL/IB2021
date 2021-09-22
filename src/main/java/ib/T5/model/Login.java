package ib.T5.model;

public class Login {
	
	private String email;
	private String lozinka;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public Login(String email, String lozinka) {
		super();
		this.email = email;
		this.lozinka = lozinka;
	}
	
	public Login() {
		super();
	}
	
	
	
	
	
	

}
