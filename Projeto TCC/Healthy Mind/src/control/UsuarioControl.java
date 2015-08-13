package control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.dao.UsuarioDao;
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
	
}
