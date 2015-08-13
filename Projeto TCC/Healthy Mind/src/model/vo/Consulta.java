package model.vo;

import java.sql.Time;
import java.util.Date;

public class Consulta {
	
	private int idConsulta;
	private Psicologo psicologo;
	private int idPaciente;
	private Date dataConsulta;
	private Time horaConsulta;
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public Psicologo getPsicologo() {
		return psicologo;
	}
	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public Time getHoraConsulta() {
		return horaConsulta;
	}
	public void setHoraConsulta(Time horaConsulta) {
		this.horaConsulta = horaConsulta;
	}
	
	
}
