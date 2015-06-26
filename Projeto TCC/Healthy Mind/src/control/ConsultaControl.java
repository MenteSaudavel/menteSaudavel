package control;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ConsultaControl {
	
	public boolean agendarConsulta(String idPaciente, String idPsicologo, String dataConsulta, String hora){
		
		int idPacienteConvertido;
		int idPsicologoConvertido;
		Date dataConsultaConvertida;
		Time horaConvertida;
		
		try{
			idPacienteConvertido = Integer.parseInt(idPaciente);
			idPsicologoConvertido = Integer.parseInt(idPsicologo);

			return true;
		} catch(NumberFormatException e){
			return false;
		}

		/*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		
		try{
			dataConsultaConvertida = new Date (sdf.parse(dataConsulta).getTime());
		} catch(ParseException e){
			return false;
		}*/
	}

}
