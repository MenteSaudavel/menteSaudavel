package control;

import java.util.List;

import model.dao.ConvenioDao;
import model.vo.Convenio;

public class ConvenioControl {
	
	public List<Convenio> listarConvenios(){
		
		ConvenioDao convenioDao = new ConvenioDao();
		List<Convenio> lista = convenioDao.listarConvenios();
		
		return lista;
	}


}
