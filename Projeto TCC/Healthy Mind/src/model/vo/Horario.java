package model.vo;

import java.sql.Time;

public class Horario {

	private int id;
	private Agenda Agenda;
	private Turno Turno;
	private Time hora1;
	private Time hora2;
	private Time hora3;
	private Time hora4;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Turno getTurno() {
		return Turno;
	}
	
	public void setTurno(Turno turno) {
		Turno = turno;
	}
	
	public Time getHora1() {
		return hora1;
	}
	
	public void setHora1(Time hora1) {
		this.hora1 = hora1;
	}
	
	public Time getHora2() {
		return hora2;
	}
	
	public void setHora2(Time hora2) {
		this.hora2 = hora2;
	}
	
	public Time getHora3() {
		return hora3;
	}
	
	public void setHora3(Time hora3) {
		this.hora3 = hora3;
	}
	
	public Time getHora4() {
		return hora4;
	}
	
	public void setHora4(Time hora4) {
		this.hora4 = hora4;
	}

	public Agenda getAgenda() {
		return Agenda;
	}

	public void setAgenda(Agenda agenda) {
		Agenda = agenda;
	}
}
