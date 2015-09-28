package control;

import java.util.List;

import model.dao.ConvenioDao;
import model.vo.Convenio;
import model.vo.UF;

public class ConvenioControl {
	
	public List<Convenio> listarConvenios(){
		
		ConvenioDao convenioDao = new ConvenioDao();
		List<Convenio> lista = convenioDao.listarConvenios();
		
		return lista;
	}
	
	public boolean cadastrarConvenio(String nome, String presidente, String cnpj, String telefoneConvenio, String enderecoConvenio, String cep, String cidadeConvenio, String uf){
		
		Convenio convenio = new Convenio();
		
		int ufConvertido;
		
		try{
			ufConvertido = Integer.parseInt(uf);
		} catch(NumberFormatException e){
			return false;
		}
		
		UF u = new UF();
		u.setId(ufConvertido);
		
		
		convenio.setNome(nome);
		convenio.setPresidente(presidente);
		convenio.setCnpj(cnpj);
		convenio.setTelefoneConvenio(telefoneConvenio);
		convenio.setEnderecoConvenio(enderecoConvenio);
		convenio.setCep(cep);
		convenio.setCidadeConvenio(cidadeConvenio);
		convenio.setUf(u);
		
		ConvenioDao convenioDao = new ConvenioDao();
		convenioDao.cadastrarConvenio(convenio);
		
		return true;
	}
	
	public boolean editar(String nome, String presidente, String cnpj, String telefoneConvenio, String enderecoConvenio, String cep, String cidadeConvenio, String uf, String id){
		
		int idConvertido;
		int ufConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
			ufConvertido = Integer.parseInt(uf);
			
			Convenio convenio = new Convenio();
			
			UF u = new UF();
			u.setId(ufConvertido);
			
			convenio.setNome(nome);
			convenio.setPresidente(presidente);
			convenio.setCnpj(cnpj);
			convenio.setTelefoneConvenio(telefoneConvenio);
			convenio.setEnderecoConvenio(enderecoConvenio);
			convenio.setCep(cep);
			convenio.setCidadeConvenio(cidadeConvenio);
			convenio.setUf(u);
			
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
