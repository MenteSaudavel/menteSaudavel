package control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import model.dao.AdministradorDao;
import model.dao.PacienteDao;
import model.dao.PsicologoDao;
import model.dao.UsuarioDao;
import model.vo.Administrador;
import model.vo.Paciente;
import model.vo.Psicologo;
import model.vo.Usuario;

public class UsuarioControl {
	
	public Usuario logar(String email, String senha) throws UsuarioException{
		
		String senhaConvertida;
		MessageDigest algorithm;
		
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
	        byte hashSenha[] = algorithm.digest(senha.getBytes());
	        
	        senhaConvertida = new String(hashSenha);
		
		} catch (NoSuchAlgorithmException e) {
		
			throw new UsuarioException("Erro na conversão de senha: algoritimo não encontrado");
			
		} 
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail(email);
		usuario.setSenha(senhaConvertida);
		
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.logar(usuario);
	}
	
	public boolean editarUsuario(String email, String senha, String confirmarSenha) throws UsuarioException{
		
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
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail(email);
		usuario.setSenha(senhaConvertida);
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.editarUsuario(usuario);
		
		if(usuario.getTipoPerfil().equals("administrador")){
			
			Administrador administrador = new Administrador();
			administrador.setEmail(email);
			
			AdministradorDao administradorDao = new AdministradorDao();
			administradorDao.editarAdministrador(administrador);
			
			return true;
		}
		
		if(usuario.getTipoPerfil().equals("paciente")){
			
			Paciente paciente = new Paciente();
			paciente.setEmail(email);
			
			PacienteDao pacienteDao = new PacienteDao();
			pacienteDao.editarPaciente(paciente);
			
			return true;
		}
		
		if(usuario.getTipoPerfil().equals("psicologo")){
			
			Psicologo psicologo = new Psicologo();
			psicologo.setEmail(email);
			
			PsicologoDao psicologoDao = new PsicologoDao();
			psicologoDao.editarPsicologo(psicologo);
			
			return true;
		}
		
		return true;
	}
	
	public Usuario buscarUsuario(String id){
		
		int idConvertido;
		

		try{
			idConvertido = Integer.parseInt(id);
			
			UsuarioDao usuarioDao = new UsuarioDao();
			
			return usuarioDao.buscarUsuario(idConvertido);
		} catch(NumberFormatException e){
			return null;
		}
	}
	
	public boolean inativarUsuario(String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
			
		} catch(NumberFormatException e){
			return false;
		}
		
		Usuario usuario = new Usuario();
		
		usuario.setId(idConvertido);
		
		UsuarioDao usuarioDao = new UsuarioDao();
		
		usuarioDao.inativarUsuario(usuario);
		
		return true;
		
	}
	
	public boolean ativarUsuario(String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
			
		} catch(NumberFormatException e){
			return false;
		}
		
		Usuario usuario = new Usuario();
		
		usuario.setId(idConvertido);
		
		UsuarioDao usuarioDao = new UsuarioDao();
		
		usuarioDao.ativarUsuario(usuario);
		
		return true;
	}
	
	public List<Usuario> pesquisarUsuario(String email){
		
		List<Usuario> lista;
		
		UsuarioDao usuarioDao = new UsuarioDao();
		
		lista = usuarioDao.pesquisarUsuario(email);
		
		return lista;
	}
	
}
