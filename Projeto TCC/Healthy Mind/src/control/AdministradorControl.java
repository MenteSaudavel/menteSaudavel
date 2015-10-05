package control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import model.dao.AdministradorDao;
import model.dao.UsuarioDao;
import model.vo.Administrador;
import model.vo.Usuario;

public class AdministradorControl {
	
	public boolean cadastrarAdministrador(String nome, String telefone, String funcao, String email, String senha, String confirmarSenha) throws UsuarioException{
		
		if(!senha.equals(confirmarSenha)){
			throw new UsuarioException("Os campos senha e confirmar senha não coicidem, tente novamente.");
		}
		
		String senhaConvertida;
		MessageDigest algorithm;
		
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
	        byte hashSenha[] = algorithm.digest(senha.getBytes());
	        
	        senhaConvertida = new String(hashSenha);
		
		} catch (NoSuchAlgorithmException e) {
		
			throw new UsuarioException("Erro na conversão de senha: algoritmo não encontrado");
			
		} 
		
		Administrador administrador = new Administrador();
		
		administrador.setNome(nome);
		administrador.setTelefone(telefone);
		administrador.setFuncao(funcao);
		administrador.setEmail(email);
		
		AdministradorDao administradorDao = new AdministradorDao();
		administradorDao.cadastrarAdministrador(administrador);
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail(email);
		usuario.setSenha(senhaConvertida);
		usuario.setTipoPerfil("administrador");
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.cadastrarUsuario(usuario);
		
		return true;
		
	}
	
	public boolean editarAdministrador(String nome, String telefone, String funcao, String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
		} catch(NumberFormatException e){
			return false;
		}
		
		Administrador administrador = new Administrador();
		
		administrador.setNome(nome);
		administrador.setTelefone(telefone);
		administrador.setFuncao(funcao);
		administrador.setId(idConvertido);
		
		AdministradorDao administradorDao = new AdministradorDao();
		administradorDao.editarAdministrador(administrador);
		
		return true;
		
	}
	
	public boolean apagarAdministrador(String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
		} catch(NumberFormatException e){
			return false;
		}
		
		Administrador administrador = new Administrador();
		
		administrador.setId(idConvertido);
		
		AdministradorDao administradorDao = new AdministradorDao();
		
		administradorDao.apagarAdministrador(administrador);
		
		return true;
	}
	
	public List<Administrador> listarAdministrador(){
		
		AdministradorDao administradorDao = new AdministradorDao();
		
		List<Administrador> lista = administradorDao.listarAdministrador();
		
		return lista;
	}
	
	public Administrador buscarAdministrador(String id){
		
		int idConvertido;
		

		try{
			idConvertido = Integer.parseInt(id);
			
			AdministradorDao administradorDao = new AdministradorDao();
			
			return administradorDao.buscarAdministrador(idConvertido);
		} catch(NumberFormatException e){
			return null;
		}
	}
	
	public List<Administrador> pesquisarAdministrador(String email){
		
		List<Administrador> lista;
		
		AdministradorDao administradorDao = new AdministradorDao();
		
		lista = administradorDao.pesquisarAdministrador(email);
		
		return lista;
	}
}
