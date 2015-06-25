package model.vo;

public class Paciente {
	
	private int id;
	private String nome;
	private String telefone;
	private String numeroCarteirinha;
	private String cpf;
	private int idConvenio;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNumeroCarteirinha() {
		return numeroCarteirinha;
	}
	
	public void setNumeroCarteirinha(String numeroCarteirinha) {
		this.numeroCarteirinha = numeroCarteirinha;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(int idConvenio) {
		this.idConvenio = idConvenio;
	}
	
	

}
