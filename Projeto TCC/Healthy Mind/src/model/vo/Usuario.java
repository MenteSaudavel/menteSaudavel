package model.vo;

public class Usuario {
	
	private int id;
	private String email;
	private String senha;
	private String tipoPerfil;
	private boolean statusPerfil;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTipoPerfil() {
		return tipoPerfil;
	}
	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}
	public boolean isStatusPerfil() {
		return statusPerfil;
	}
	public void setStatusPerfil(boolean statusPerfil) {
		this.statusPerfil = statusPerfil;
	}
	
	
}
