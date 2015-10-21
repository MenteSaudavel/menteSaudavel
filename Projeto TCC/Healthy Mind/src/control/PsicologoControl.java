package control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import model.dao.PsicologoDao;
import model.dao.UsuarioDao;
import model.vo.Convenio;
import model.vo.Psicologo;
import model.vo.UF;
import model.vo.Usuario;

public class PsicologoControl {
	
	public boolean cadastrarPsicologo(String nome, String telefoneConsultorio, String idConvenio, String idConvenio2, String idConvenio3, String idConvenio4, String idConvenio5, String crp, String idUf, String email, String confCrp) throws UsuarioException{
		
		if(!crp.equals(confCrp)){
			throw new UsuarioException("O número do CRP não foi digitado corretamente nos dois campos, tente novamente.");
		}
		
		String senhaConvertida;
		MessageDigest algorithm;
		
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
	        byte hashSenha[] = algorithm.digest(crp.getBytes());
	        
	        senhaConvertida = new String(hashSenha);
		
		} catch (NoSuchAlgorithmException e) {
		
			throw new UsuarioException("Erro na conversão de senha: algoritmo não encontrado");
			
		}
		
		int idConvenioConvertido;
		int idUfConvertido;
		
		try{
			
			idConvenioConvertido = Integer.parseInt(idConvenio);
			idUfConvertido = Integer.parseInt(idUf);
			
		} catch(NumberFormatException e){
			return false;
		}
		
		int idConvenioConvertido2;
		int idConvenioConvertido3;
		int idConvenioConvertido4;
		int idConvenioConvertido5;
		
		Psicologo psicologo = new Psicologo();
		
		psicologo.setNome(nome);
		psicologo.setTelefoneConsultorio(telefoneConsultorio);
		
		Convenio convenio = new Convenio();
		convenio.setId(idConvenioConvertido);
		psicologo.setConvenio(convenio);
		
		Convenio convenio2 = new Convenio();
		
		if(idConvenio2.isEmpty()){
			psicologo.setConvenio2(null);
		} else {
			
			try{
				idConvenioConvertido2 = Integer.parseInt(idConvenio2);
			} catch(NumberFormatException e){
				return false;
			}
			
			convenio2.setId(idConvenioConvertido2);
			psicologo.setConvenio2(convenio2);
		}
		
		Convenio convenio3 = new Convenio();
		
		if(idConvenio3.isEmpty()){
			psicologo.setConvenio3(null);
		} else {
			
			try{
				idConvenioConvertido3 = Integer.parseInt(idConvenio3);
			} catch (NumberFormatException e){
				return false;
			}
			
			convenio3.setId(idConvenioConvertido3);
			psicologo.setConvenio3(convenio3);
		}
		
		Convenio convenio4 = new Convenio();
		
		if(idConvenio4.isEmpty()){
			psicologo.setConvenio4(null);
		} else {
			
			try{
				idConvenioConvertido4 = Integer.parseInt(idConvenio4);
			} catch(NumberFormatException e){
				return false;
			}
			
			convenio4.setId(idConvenioConvertido4);
			psicologo.setConvenio4(convenio4);
		}
		
		Convenio convenio5 = new Convenio();
		
		if(idConvenio5.isEmpty()){
			psicologo.setConvenio5(null);
		} else {
			try{
				idConvenioConvertido5 = Integer.parseInt(idConvenio5);
			} catch(NumberFormatException e){
				return false;
			}
			
			convenio5.setId(idConvenioConvertido5);
			psicologo.setConvenio5(convenio5);
		}
		
		psicologo.setCrp(crp);
		
		UF uf = new UF();
		uf.setId(idUfConvertido);
		psicologo.setUf(uf);
		
		psicologo.setEmail(email);
		
		PsicologoDao psicologoDao = new PsicologoDao();
		psicologoDao.cadastrarPsicologo(psicologo);
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail(email);
		usuario.setSenha(senhaConvertida);
		usuario.setTipoPerfil("psicologo");
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.cadastrarUsuario(usuario);
		
		return true;
	}
	
	public boolean editarPsicologo(String nome, String telefoneConsultorio, String idConvenio, String idConvenio2, String idConvenio3, String idConvenio4, String idConvenio5, String crp, String id){
		
		int idConvertido;
		int idConvenioConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
			
			idConvenioConvertido = Integer.parseInt(idConvenio);
			
			int idConvenioConvertido2;
			int idConvenioConvertido3;
			int idConvenioConvertido4;
			int idConvenioConvertido5;
			
			Psicologo psicologo = new Psicologo();
			
			psicologo.setNome(nome);
			psicologo.setTelefoneConsultorio(telefoneConsultorio);
			
			Convenio convenio = new Convenio();
			convenio.setId(idConvenioConvertido);
			psicologo.setConvenio(convenio);
			
			Convenio convenio2 = new Convenio();
			
			if(idConvenio2.isEmpty()){
				psicologo.setConvenio2(null);
			} else {
				
				try{
					idConvenioConvertido2 = Integer.parseInt(idConvenio2);
				} catch(NumberFormatException e){
					return false;
				}
				
				convenio2.setId(idConvenioConvertido2);
				psicologo.setConvenio2(convenio2);
			}
			
			Convenio convenio3 = new Convenio();
			
			if(idConvenio3.isEmpty()){
				psicologo.setConvenio3(null);
			} else {
				
				try{
					idConvenioConvertido3 = Integer.parseInt(idConvenio3);
				} catch (NumberFormatException e){
					return false;
				}
				
				convenio3.setId(idConvenioConvertido3);
				psicologo.setConvenio3(convenio3);
			}
			
			Convenio convenio4 = new Convenio();
			
			if(idConvenio4.isEmpty()){
				psicologo.setConvenio4(null);
			} else {
				
				try{
					idConvenioConvertido4 = Integer.parseInt(idConvenio4);
				} catch(NumberFormatException e){
					return false;
				}
				
				convenio4.setId(idConvenioConvertido4);
				psicologo.setConvenio4(convenio4);
			}
			
			Convenio convenio5 = new Convenio();
			
			if(idConvenio5.isEmpty()){
				psicologo.setConvenio5(null);
			} else {
				try{
					idConvenioConvertido5 = Integer.parseInt(idConvenio5);
				} catch(NumberFormatException e){
					return false;
				}
				
				convenio5.setId(idConvenioConvertido5);
				psicologo.setConvenio5(convenio5);
			}
			
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
	
	public List<Psicologo> listarPsicologoSelect(String idConvenio){
		
		int idConvenioConvertido;
		
		try{
			idConvenioConvertido = Integer.parseInt(idConvenio);
		} catch(NumberFormatException e){
			return null;
		}
		
		PsicologoDao psicologoDao = new PsicologoDao();
		
		List<Psicologo> lista = psicologoDao.listarPsicologoSelect(idConvenioConvertido);
		
		return lista;
	}
	
	public List<Psicologo> pesquisarPsicologoEmail(String email){
		PsicologoDao psicologoDao = new PsicologoDao();
		
		List<Psicologo> lista = psicologoDao.pesquisarPsicologoEmail(email);
		
		return lista;
	}
	
	public boolean vincularUsuario(String idUsuario, String email){
		
		int idUsuarioConvertido;
		
		try{
			idUsuarioConvertido = Integer.parseInt(idUsuario);
		} catch(NumberFormatException e){
			return false;
		}
		
		Usuario usuario = new Usuario();
		usuario.setId(idUsuarioConvertido);
		
		Psicologo psicologo = new Psicologo();
		psicologo.setUsuario(usuario);
		psicologo.setEmail(email);
		
		PsicologoDao psicologoDao = new PsicologoDao();
		psicologoDao.vincularUsuario(psicologo);
		
		return true;
	}
	
	public List<Psicologo> listarUsuario(String id){
		
		List<Psicologo> lista;
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
		} catch(NumberFormatException e){
			return null;
		}
		
		PsicologoDao psicologoDao = new PsicologoDao();
		
		lista = psicologoDao.listarUsuario(idConvertido);
		
		return lista;
	}
}
