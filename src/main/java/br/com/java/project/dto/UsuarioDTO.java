package br.com.java.project.dto;

public class UsuarioDTO {
	
	private String usuario;
	private String login;
	private String email;
	private String senha;
	
	public UsuarioDTO(String usuario, String login, String email, String senha) {
		super();
		this.usuario = usuario;
		this.login = login;
		this.email = email;
		this.senha = senha;
	}
	
	public UsuarioDTO(){
		
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
