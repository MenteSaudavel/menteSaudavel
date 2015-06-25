package control;

import java.util.List;

import model.dao.PacienteDao;
import model.dao.PsicologoDao;
import model.vo.Convenio;
import model.vo.Paciente;
import model.vo.Psicologo;

public class PsicologoControl {
	
	public boolean cadastrarPsicologo(String nome, String telefoneConsultorio, String idConvenio, String crp){
		
		int idConvenioConvertido;
		
		try{
			
			idConvenioConvertido = Integer.parseInt(idConvenio);
			
		} catch(NumberFormatException e){
			return false;
		}
		
		Psicologo psicologo = new Psicologo();
		
		psicologo.setNome(nome);
		psicologo.setTelefoneConsultorio(telefoneConsultorio);
		
		psicologo.setIdConvenio(idConvenioConvertido);
		
		psicologo.setCrp(crp);
		
		PsicologoDao psicologoDao = new PsicologoDao();
		psicologoDao.cadastrarPsicologo(psicologo);
		
		return true;
	}
	
	public boolean editarPsicologo(String nome, String telefoneConsultorio, String idConvenio, String crp, String id){
		
		int idConvertido;
		int idConvenioConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
			
			idConvenioConvertido = Integer.parseInt(idConvenio);
			
			Psicologo psicologo = new Psicologo();
			
			psicologo.setNome(nome);
			psicologo.setTelefoneConsultorio(telefoneConsultorio);
			psicologo.setIdConvenio(idConvenioConvertido);
			psicologo.setCrp(crp);
			psicologo.setId(idConvertido);
			
			PsicologoDao psicologoDao = new PsicologoDao();
			psicologoDao.editarPsicologo(psicologo);
			
			return true;
			
		} catch(NumberFormatException e){
			return false;
		}
	}
	
	public List<Psicologo> pesquisarPsicologo(String nome){
		
		List<Psicologo> lista;
		
		if(nome.isEmpty()){
			lista = null;
		}
		
		PsicologoDao psicologoDao = new PsicologoDao();
		
		lista = psicologoDao.pesquisarPsicologo(nome);
		
		return lista;
	}
	
	public List<Psicologo> listarPsicologo(){
		
		PsicologoDao psicologoDao = new PsicologoDao();
		List<Psicologo> lista = psicologoDao.listarPsicologo();
		
		return lista;
	}
	
	public Psicologo buscarPsicologo(String id){
		
		int idConvertido;
		
		try{
			
			idConvertido = Integer.parseInt(id);
			
			PsicologoDao psicologoDao = new PsicologoDao();
			
			return psicologoDao.buscarPsicologo(idConvertido);
			
		}catch(NumberFormatException e){
			return null;
		}
	}
	
	public boolean apagarPsicologo(String id){
		
		int idConverido;
		
		try{
			idConverido = Integer.parseInt(id);

		}catch(NumberFormatException e){
			return false;
		}
		
		Psicologo psicologo = new Psicologo();
		psicologo.setId(idConverido);
		
		PsicologoDao psicologoDao= new PsicologoDao();
		psicologoDao.apagarPsicologo(psicologo);
		
		return true;
		
	}
}
