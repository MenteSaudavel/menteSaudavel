package control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import model.dao.PsicologoDao;
import model.dao.UsuarioDao;
import model.vo.Convenio;
import model.vo.Psicologo;
import model.vo.Usuario;

public class PsicologoControl {
	
	public boolean cadastrarPsicologo(String nome, String telefoneConsultorio, String idConvenio, String crp, String email, String confCrp) throws UsuarioException{
		
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
		
		try{
			
			idConvenioConvertido = Integer.parseInt(idConvenio);
			
		} catch(NumberFormatException e){
			return false;
		}
		
		Psicologo psicologo = new Psicologo();
		
		psicologo.setNome(nome);
		psicologo.setTelefoneConsultorio(telefoneConsultorio);
		
		Convenio convenio = new Convenio();
		convenio.setId(idConvenioConvertido);
		psicologo.setConvenio(convenio);
		
		psicologo.setCrp(crp);
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
	
	public boolean editarPsicologo(String nome, String telefoneConsultorio, String idConvenio, String crp, String id){
		
		int idConvertido;
		int idConvenioConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
			
			idConvenioConvertido = Integer.parseInt(idConvenio);
			
			Psicologo psicologo = new Psicologo();
			
			psicologo.setNome(nome);
			psicologo.setTelefoneConsultorio(telefoneConsultorio);
			
			Convenio convenio = new Convenio();
			convenio.setId(idConvenioConvertido);
			psicologo.setConvenio(convenio);
			
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
