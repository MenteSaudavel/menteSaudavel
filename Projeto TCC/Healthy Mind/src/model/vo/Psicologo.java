package model.vo;

public class Psicologo {
	
	private int id;
	private String nome;
	private String telefoneConsultorio;
	private Integer idConvenio;
	private String crp;
	
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

	public Integer getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(Integer idConvenio) {
		this.idConvenio = idConvenio;
	}

}
