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
	
	public boolean cadastrarConvenio(String nome){
		
		Convenio convenio = new Convenio();
		
		convenio.setNome(nome);
		
		ConvenioDao convenioDao = new ConvenioDao();
		convenioDao.cadastrarConvenio(convenio);
		
		return true;
	}
	
	public boolean editar(String nome, String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
			
			Convenio convenio = new Convenio();
			
			convenio.setNome(nome);
			convenio.setId(idConvertido);
			
			ConvenioDao convenioDao = new ConvenioDao();
			convenioDao.editarConvenio(convenio);
			
			return true;
		} catch(NumberFormatException e){
			return false;
		}
	}
	
	public boolean apagarConvenio(String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
			
			Convenio convenio = new Convenio();
			
			convenio.setId(idConvertido);
			
			ConvenioDao convenioDao = new ConvenioDao();
			convenioDao.apagarConvenio(convenio);
			
			return true;
		} catch(NumberFormatException e){
			return false;
		}
		
	}
	
	public Convenio buscarConvenio(String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
			
			ConvenioDao convenioDao = new ConvenioDao();
			
			return convenioDao.buscarConvenio(idConvertido);
		} catch(NumberFormatException e){
			return null;
		}
	}


}
