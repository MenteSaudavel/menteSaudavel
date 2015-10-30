package model.vo;

import java.util.Date;

public class Agenda {
	
	private int id;
	private Psicologo Psicologo;
	private Date data;
	private Turno Turno1;
	private Turno Turno2;
	private Turno Turno3;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Psicologo getPsicologo() {
		return Psicologo;
	}
	
	public void setPsicologo(Psicologo psicologo) {
		Psicologo = psicologo;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Turno getTurno1() {
		return Turno1;
	}
	public void setTurno1(Turno turno1) {
		Turno1 = turno1;
	}
	
	public Turno getTurno2() {
		return Turno2;
	}
	
	public void setTurno2(Turno turno2) {
		Turno2 = turno2;
	}
	
	public Turno getTurno3() {
		return Turno3;
	}
	
	public void setTurno3(Turno turno3) {
		Turno3 = turno3;
	}
}
