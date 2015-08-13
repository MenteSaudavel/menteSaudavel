package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.Usuario;

public class UsuarioDao {
	
	Connection conexao;

	public UsuarioDao() {
		this.conexao = new FabricaConexoes().getConexao();
	}
	
	public void cadastrarUsuario(Usuario usuario){
		
		String sql = "insert into usuario (email, senha, tipoPerfil) values (?,?,?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getTipoPerfil());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Usuario logar(Usuario usuario){
		
		String sql = "select * from usuario where email=? and senha=?";
		
		Usuario u = null;
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setTipoPerfil(rs.getString("tipoPerfil"));
				
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}

}
