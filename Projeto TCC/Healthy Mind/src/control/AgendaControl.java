package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.AgendaDao;
import model.vo.Agenda;
import model.vo.Psicologo;
import model.vo.Turno;

public class AgendaControl {

	public boolean cadastrarAgenda(String idPsicologo, String dataAtendimento, String idTurno, String idTurno2, String idTurno3){
		
		int idPsicologoConvertido;
		Date dataAtendimentoConvertida;
		
		try{
			idPsicologoConvertido = Integer.parseInt(idPsicologo);
		}catch(NumberFormatException e){
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		try{
			dataAtendimentoConvertida = sdf.parse(dataAtendimento);
		}catch(ParseException e){
			try{
				dataAtendimentoConvertida = sdf2.parse(dataAtendimento);
			}catch(ParseException e1){
				return false;
			}
		}
		
		int idTurnoConvertido;
		int idTurno2Convertido;
		int idTurno3Convertido;
		
		Agenda agenda = new Agenda();
		
		Psicologo psicologo = new Psicologo();
		psicologo.setId(idPsicologoConvertido);
		agenda.setPsicologo(psicologo);
		
		Turno turno = new Turno();
		
		if(idTurno==null){
			agenda.setTurno1(null);
		}else{
			try{
				idTurnoConvertido = Integer.parseInt(idTurno);
			}catch(NumberFormatException e){
				return false;
			}
			
			turno.setId(idTurnoConvertido);
			agenda.setTurno1(turno);
		}
		
		Turno turno2 = new Turno();
		
		if(idTurno2==null){
			agenda.setTurno2(null);
		}else{
			try{
				idTurno2Convertido = Integer.parseInt(idTurno2);
			}catch(NumberFormatException e){
				return false;
			}
			
			turno2.setId(idTurno2Convertido);
			agenda.setTurno2(turno2);
		}
		
		Turno turno3 = new Turno();
		
		if(idTurno3==null){
			agenda.setTurno3(null);
		}else{
			try{
				idTurno3Convertido = Integer.parseInt(idTurno3);
			}catch(NumberFormatException e){
				return false;
			}
			
			turno3.setId(idTurno3Convertido);
			agenda.setTurno3(turno3);
		}
		
		agenda.setData(dataAtendimentoConvertida);
		
		AgendaDao agendaDao = new AgendaDao();
		agendaDao.cadastrarAgenda(agenda);
		
		return true;
	}
	
	public List<Turno> listarTurno(String idPsicologo, String dataAtendimento){
		
		int idPsicologoConvertido;
		Date dataAtendimentoConvertida;
		
		try{
			idPsicologoConvertido = Integer.parseInt(idPsicologo);
		}catch(NumberFormatException e){
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		try{
			dataAtendimentoConvertida = sdf.parse(dataAtendimento);
		}catch(ParseException e){
			try{
				dataAtendimentoConvertida = sdf2.parse(dataAtendimento);
			}catch(ParseException e1){
				return null;
			}
		}
		
		AgendaDao agendaDao = new AgendaDao();
		
		List<Turno> lista = agendaDao.listarTurno(idPsicologoConvertido, dataAtendimentoConvertida);
		
		return lista;
	}
	
	public List<Agenda> listarDatas(String idPsicologo){
		
		int idPsicologoConvertido;
		
		try{
			idPsicologoConvertido = Integer.parseInt(idPsicologo);
		} catch(NumberFormatException e){
			return null;
		}
		
		AgendaDao agendaDao = new AgendaDao();
		
		List<Agenda> lista = agendaDao.listarDatas(idPsicologoConvertido);
		
		return lista;
	}
	
	public Agenda buscarIdAgenda(String dataAtendimento){
		
		Date dataAtendimentoConvertida;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		try{
			dataAtendimentoConvertida = sdf.parse(dataAtendimento);
		}catch(ParseException e){
			try{
				dataAtendimentoConvertida = sdf2.parse(dataAtendimento);
			}catch(ParseException e1){
				return null;
			}
		}
		
		AgendaDao agendaDao = new AgendaDao();
		
		return agendaDao.buscarIdAgenda(dataAtendimentoConvertida);
	}
	
	public List<Agenda> pesquisarData(String dataAtendimento){
		
		Date dataAtendimentoConvertida;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		try{
			dataAtendimentoConvertida = sdf.parse(dataAtendimento);
		}catch(ParseException e){
			try{
				dataAtendimentoConvertida = sdf2.parse(dataAtendimento);
			}catch(ParseException e1){
				return null;
			}
		}
		
		AgendaDao agendaDao = new AgendaDao();
		
		List<Agenda> lista = agendaDao.pesquisarData(dataAtendimentoConvertida);
		
		return lista;
	}
	
}
