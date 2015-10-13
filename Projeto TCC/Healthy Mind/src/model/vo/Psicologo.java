package model.vo;

public class Psicologo {
	
	private int id;
	private String nome;
	private String telefoneConsultorio;
	private Convenio Convenio;
	private Convenio Convenio2;
	private Convenio Convenio3;
	private Convenio Convenio4;
	private Convenio Convenio5;
	private String crp;
	private UF Uf;
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
	
	public UF getUf() {
		return Uf;
	}

	public void setUf(UF uf) {
		Uf = uf;
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
	
	
	public Convenio getConvenio2() {
		return Convenio2;
	}

	public void setConvenio2(Convenio convenio2) {
		Convenio2 = convenio2;
	}

	public Convenio getConvenio3() {
		return Convenio3;
	}

	public void setConvenio3(Convenio convenio3) {
		Convenio3 = convenio3;
	}

	public Convenio getConvenio4() {
		return Convenio4;
	}

	public void setConvenio4(Convenio convenio4) {
		Convenio4 = convenio4;
	}

	public Convenio getConvenio5() {
		return Convenio5;
	}

	public void setConvenio5(Convenio convenio5) {
		Convenio5 = convenio5;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
