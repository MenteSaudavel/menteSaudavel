package control;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.dao.HorarioDao;
import model.vo.Agenda;
import model.vo.Horario;
import model.vo.Turno;

public class HorarioControl {
	
	public boolean cadastrarHorario(String idAgenda, String idTurno, String hora1, String hora2, String hora3, String hora4){
		
		int idTurnoConvertido;
		int idAgendaConvertido;
		
		try{
			idTurnoConvertido = Integer.parseInt(idTurno);
			idAgendaConvertido = Integer.parseInt(idAgenda);
		} catch(NumberFormatException e) {
			return false;
		}
		
		Time hora1Convertida;
		Time hora2Convertida;
		Time hora3Convertida;
		Time hora4Convertida;
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		Horario horario = new Horario();
		
		Turno turno = new Turno();
		turno.setId(idTurnoConvertido);
		horario.setTurno(turno);
		
		Agenda agenda = new Agenda();
		agenda.setId(idAgendaConvertido);
		horario.setAgenda(agenda);
		
		if(hora1==null){
			horario.setHora1(null);
		} else {
			try{
				hora1Convertida = new Time(sdf.parse(hora1).getTime());
			} catch(ParseException e){
				return false;
			}
			
			horario.setHora1(hora1Convertida);
		}
		
		if(hora2==null){
			horario.setHora2(null);
		} else {
			try{
				hora2Convertida = new Time(sdf.parse(hora2).getTime());
			} catch(ParseException e){
				return false;
			}
			
			horario.setHora2(hora2Convertida);
		}
		
		if(hora3==null){
			horario.setHora3(null);
		} else {
			try{
				hora3Convertida = new Time(sdf.parse(hora3).getTime());
			} catch(ParseException e){
				return false;
			}
			
			horario.setHora3(hora3Convertida);
		}
		
		if(hora4==null){
			horario.setHora4(null);
		} else {
			try{
				hora4Convertida = new Time(sdf.parse(hora4).getTime());
			} catch(ParseException e){
				return false;
			}
			
			horario.setHora4(hora4Convertida);
		}
				
		HorarioDao horarioDao = new HorarioDao();
		
		horarioDao.cadastrarHorario(horario);
		
		return true;
	}
	
	public boolean editarHorario(String hora1, String hora2, String hora3, String hora4, String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
		} catch(NumberFormatException e) {
			return false;
		}
		
		Time hora1Convertida;
		Time hora2Convertida;
		Time hora3Convertida;
		Time hora4Convertida;
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		Horario horario = new Horario();

		horario.setId(idConvertido);
		
		if(hora1==null){
			horario.setHora1(null);
		} else {
			try{
				hora1Convertida = new Time(sdf.parse(hora1).getTime());
			} catch(ParseException e){
				return false;
			}
			
			horario.setHora1(hora1Convertida);
		}
		
		if(hora2==null){
			horario.setHora2(null);
		} else {
			try{
				hora2Convertida = new Time(sdf.parse(hora2).getTime());
			} catch(ParseException e){
				return false;
			}
			
			horario.setHora2(hora2Convertida);
		}
		
		if(hora3==null){
			horario.setHora3(null);
		} else {
			try{
				hora3Convertida = new Time(sdf.parse(hora3).getTime());
			} catch(ParseException e){
				return false;
			}
			
			horario.setHora3(hora3Convertida);
		}
		
		if(hora4==null){
			horario.setHora4(null);
		} else {
			try{
				hora4Convertida = new Time(sdf.parse(hora4).getTime());
			} catch(ParseException e){
				return false;
			}
			
			horario.setHora4(hora4Convertida);
		}
		
		HorarioDao horarioDao = new HorarioDao();
		horarioDao.editarHorario(horario);
		
		return true;
	}
	
	public Horario buscarHorario(String idAgenda){
		
		int idAgendaConvertido;
		
		try{
			idAgendaConvertido = Integer.parseInt(idAgenda);
		} catch(NumberFormatException e){
			return null;
		}
		
		HorarioDao horarioDao = new HorarioDao();
		
		return horarioDao.buscarHorario(idAgendaConvertido);
	}
	
	public List<Horario> listarHorario(String idAgenda){
		
		int idAgendaConvertido;
		
		try{
			idAgendaConvertido = Integer.parseInt(idAgenda);
		} catch(NumberFormatException e){
			return null;
		}
		
		HorarioDao horarioDao = new HorarioDao();
		
		List<Horario> lista = horarioDao.listarHorario(idAgendaConvertido);
		
		return lista;
	}
	
}
