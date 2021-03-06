package model.vo;

public class Paciente {
	
	private int id;
	private String nome;
	private String telefone;
	private String numeroCarteirinha;
	private String cpf;
	private Convenio Convenio;
	private String email;
	private Usuario Usuario;
	
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

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
	
	

	
	

}
