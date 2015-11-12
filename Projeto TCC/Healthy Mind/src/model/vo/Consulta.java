package model.vo;

import java.sql.Time;
import java.util.Date;

public class Consulta {
	
	private int id;
	private Paciente Paciente;
	private Psicologo Psicologo;
	private Date dataConsulta;
	private Time hora;
	private String tipoConsulta;
	private boolean statusConsulta;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Paciente getPaciente() {
		return Paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		Paciente = paciente;
	}
	
	public Psicologo getPsicologo() {
		return Psicologo;
	}
	
	public void setPsicologo(Psicologo psicologo) {
		Psicologo = psicologo;
	}
	
	public Date getDataConsulta() {
		return dataConsulta;
	}
	
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
	public Time getHora() {
		return hora;
	}
	
	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public boolean isStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(boolean statusConsulta) {
		this.statusConsulta = statusConsulta;
	}
	
}
