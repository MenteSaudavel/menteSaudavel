package control;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.ConsultaDao;
import model.vo.Consulta;
import model.vo.Horario;
import model.vo.Paciente;
import model.vo.Psicologo;


public class ConsultaControl {
	
	public boolean agendarConsulta(String idPaciente, String idPsicologo, String dataConsulta, String hora){
		
		int idPacienteConvertido;
		int idPsicologoConvertido;
		Date dataConsultaConvertida;
		Time horaConvertida;

		
		try{
			idPacienteConvertido = Integer.parseInt(idPaciente);
			idPsicologoConvertido = Integer.parseInt(idPsicologo);
			
		} catch(NumberFormatException e){
			
			return false;
		}
		
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
 		
 		
		try{
			dataConsultaConvertida = sdf.parse(dataConsulta);
		}
		catch(ParseException e){
			try{
				dataConsultaConvertida = sdf2.parse(dataConsulta);
			}
			catch(ParseException e1){
				return false;
			}
		}
		
		try{
			horaConvertida = new Time( sdfHora.parse(hora).getTime() );
			
		} catch(ParseException e){
			
			return false;
		}
		
		Consulta consulta = new Consulta();
		
		Psicologo psicologo = new Psicologo();
		psicologo.setId(idPsicologoConvertido);
		consulta.setPsicologo(psicologo);
		
		Paciente paciente = new Paciente();
		paciente.setId(idPacienteConvertido);
		consulta.setPaciente(paciente);
		
		consulta.setDataConsulta(dataConsultaConvertida);
		consulta.setHora(horaConvertida);
		
		ConsultaDao consultaDao = new ConsultaDao();
		consultaDao.agendarConsulta(consulta);
		
		return true;
	}
	
	public boolean remarcarConsulta(String idPsicologo, String dataConsulta, String hora, String idConsulta){
		
		int idPsicologoConvertido;
		int idConsultaConvertido;
		Date dataConsultaConvertida;
		Time horaConvertida;

		
		try{
			idConsultaConvertido = Integer.parseInt(idConsulta);
			idPsicologoConvertido = Integer.parseInt(idPsicologo);

			
		} catch(NumberFormatException e){
			return false;
		}
		
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
		
 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 		
		try{
			dataConsultaConvertida = sdf.parse(dataConsulta);
			horaConvertida = new Time( sdfHora.parse(hora).getTime() );
			
		} catch(ParseException e){
			return false;
		}
		
		Consulta consulta = new Consulta();
		
		Psicologo psicologo = new Psicologo();
		psicologo.setId(idPsicologoConvertido);
		
		consulta.setPsicologo(psicologo);
		consulta.setDataConsulta(dataConsultaConvertida);
		consulta.setHora(horaConvertida);
		consulta.setId(idConsultaConvertido);
		
		ConsultaDao consultaDao = new ConsultaDao();
		consultaDao.remarcarConsulta(consulta);
		
		return true;
	}
	
	public boolean desmarcarConsulta(String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
		} catch(NumberFormatException e){
			return false;
		}
		
		Consulta consulta = new Consulta();
		consulta.setId(idConvertido);
		
		ConsultaDao consultaDao = new ConsultaDao();
		consultaDao.desmarcarConsulta(consulta);
		
		return true;
	}
	
	public List<Consulta> visualizarConsulta(String idPaciente){
		
		int idPacienteConvertido;
		
		try{
			idPacienteConvertido = Integer.parseInt(idPaciente);
		} catch (NumberFormatException e){
			return null;
		} 
		
		ConsultaDao consultaDao = new ConsultaDao();
		
		List<Consulta> lista = consultaDao.visualizarConsulta(idPacienteConvertido);
		
		return lista;
	}
	
	public Consulta buscarConsulta(String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
			
			ConsultaDao consultaDao = new ConsultaDao();
			
			return consultaDao.buscarConsulta(idConvertido);
		} catch(NumberFormatException e){
			return null;
		}
	}
	
	public boolean agendarPsicologo(String idPaciente, String idPsicologo){

		int idPsicologoConvertido;
		int idPacienteConvertido;
		
		try{
			idPacienteConvertido = Integer.parseInt(idPaciente);
			idPsicologoConvertido = Integer.parseInt(idPsicologo);
		} catch(NumberFormatException e){
			return false;
		}
		
		Consulta consulta = new Consulta();
		
		Psicologo psicologo = new Psicologo();
		psicologo.setId(idPsicologoConvertido);
		consulta.setPsicologo(psicologo);
		
		Paciente paciente = new Paciente();
		paciente.setId(idPacienteConvertido);
		consulta.setPaciente(paciente);
		
		ConsultaDao consultaDao = new ConsultaDao();
		
		consultaDao.agendarPsicologo(consulta);
		
		return true;
	}
	
	public boolean agendarDataHorario(String dataConsulta, String hora, String tipoConsulta, String idPaciente){
		
		int idPacienteConvertido;
		
		try{
			idPacienteConvertido = Integer.parseInt(idPaciente);
		} catch (NumberFormatException e){
			return false;
		}
		
		Date dataConsultaConvertida;
		Time horaConvertida;
		
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
 		
 		
		try{
			dataConsultaConvertida = sdf.parse(dataConsulta);
		}
		catch(ParseException e){
			try{
				dataConsultaConvertida = sdf2.parse(dataConsulta);
			}
			catch(ParseException e1){
				return false;
			}
		}
		
		try{
			horaConvertida = new Time( sdfHora.parse(hora).getTime() );
			
		} catch(ParseException e){
			
			return false;
		}
		
		Consulta consulta = new Consulta();
		
		consulta.setDataConsulta(dataConsultaConvertida);
		consulta.setHora(horaConvertida);
		consulta.setTipoConsulta(tipoConsulta);
		
		Paciente paciente = new Paciente();
		paciente.setId(idPacienteConvertido);
		consulta.setPaciente(paciente);
		
		ConsultaDao consultaDao = new ConsultaDao();
		
		consultaDao.agendarDataHorario(consulta);
		
		return true;
	}
	
	public List<Horario> visualizarDataHoraDisponível(String idPsicologo){
		
		int idPsicologoConvertido;
		
		try{
			idPsicologoConvertido = Integer.parseInt(idPsicologo);
		} catch(NumberFormatException e){
			return null;
		}
		
		ConsultaDao consultaDao = new ConsultaDao();
		
		List<Horario> lista = consultaDao.visualizarDataHoraDisponível(idPsicologoConvertido);
		
		return lista;
	}

}
