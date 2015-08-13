package control;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.ConsultaDao;
import model.vo.Consulta;
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
		consulta.setIdPaciente(idPacienteConvertido);
		consulta.setDataConsulta(dataConsultaConvertida);
		consulta.setHoraConsulta(horaConvertida);
		
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
		consulta.setHoraConsulta(horaConvertida);
		consulta.setIdConsulta(idConsultaConvertido);
		
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
		consulta.setIdConsulta(idConvertido);
		
		ConsultaDao consultaDao = new ConsultaDao();
		consultaDao.desmarcarConsulta(consulta);
		
		return true;
	}
	
	public List<Consulta> visualizarConsulta(){
		
		ConsultaDao consultaDao = new ConsultaDao();
		
		List<Consulta> lista = consultaDao.visualizarConsulta();
		
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

}
