package model.vo;

public class Psicologo {
	
	private int id;
	private String nome;
	private String telefoneConsultorio;
	private Convenio Convenio;
	private String crp;
	private String email;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefoneConsultorio() {
		return telefoneConsultorio;
	}
	
	public void setTelefoneConsultorio(String telefoneConsultorio) {
		this.telefoneConsultorio = telefoneConsultorio;
	}
	
	public String getCrp() {
		return crp;
	}
	
	public void setCrp(String crp) {
		this.crp = crp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Convenio getConvenio() {
		return Convenio;
	}

	public void setConvenio(Convenio convenio) {
		Convenio = convenio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
