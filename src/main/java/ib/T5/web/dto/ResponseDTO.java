package ib.T5.web.dto;

public class ResponseDTO {
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ResponseDTO(String token) {
		super();
		this.token = token;
	}

	public ResponseDTO() {
		super();
	}
	
	

}
