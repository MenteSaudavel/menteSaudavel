package model.vo;

public class Convenio {
	
	private int id;
	private String nome;
	private String presidente;
	private String cnpj;
	private String telefoneConvenio;
	private String enderecoConvenio;
	private String cep;
	private String cidadeConvenio;
	private String uf;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPresidente() {
		return presidente;
	}
	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefoneConvenio() {
		return telefoneConvenio;
	}
	public void setTelefoneConvenio(String telefoneConvenio) {
		this.telefoneConvenio = telefoneConvenio;
	}
	public String getEnderecoConvenio() {
		return enderecoConvenio;
	}
	public void setEnderecoConvenio(String enderecoConvenio) {
		this.enderecoConvenio = enderecoConvenio;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCidadeConvenio() {
		return cidadeConvenio;
	}
	public void setCidadeConvenio(String cidadeConvenio) {
		this.cidadeConvenio = cidadeConvenio;
	}
	
}
