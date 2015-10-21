package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Administrador;
import model.vo.Usuario;

public class AdministradorDao {

	Connection conexao;

	public AdministradorDao() {
		this.conexao = new FabricaConexoes().getConexao();
	}
	
	public void cadastrarAdministrador(Administrador administrador){
		
		String sql = "insert into administrador (nome, telefone, funcao, email) values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, administrador.getNome());
			stmt.setString(2, administrador.getTelefone());
			stmt.setString(3, administrador.getFuncao());
			stmt.setString(4, administrador.getEmail());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editarEmail(Administrador administrador){
		
		String sql = "update administrador set email=? where id=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, administrador.getEmail());
			stmt.setInt(2, administrador.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void editarAdministrador(Administrador administrador){
		
		String sql = "update administrador set nome=?, telefone=?, funcao=? where id=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, administrador.getNome());
			stmt.setString(2, administrador.getTelefone());
			stmt.setString(3, administrador.getFuncao());
			stmt.setInt(4, administrador.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Administrador> listarAdministrador(){
		
		List<Administrador> lista = new ArrayList<Administrador>();
		
		String sql = "select * from administrador";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Administrador adm = new Administrador();
				
				adm.setId(rs.getInt("id"));
				adm.setNome(rs.getString("nome"));
				adm.setTelefone(rs.getString("telefone"));
				adm.setFuncao(rs.getString("funcao"));
				adm.setEmail(rs.getString("email"));
				
				Usuario u = new Usuario();
				u.setId(rs.getInt("idUsuario"));
				adm.setUsuario(u);
				
				lista.add(adm);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void apagarAdministrador(Administrador administrador){
		
		String sql = "delete from administrador where id=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, administrador.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Administrador buscarAdministrador(int id){
		
		Administrador administrador = new Administrador();
		
		String sql = "select * from administrador where id=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			administrador.setId(rs.getInt("id"));
			administrador.setNome(rs.getString("nome"));
			administrador.setTelefone(rs.getString("telefone"));
			administrador.setFuncao(rs.getString("funcao"));
			administrador.setEmail(rs.getString("email"));
			
			Usuario u = new Usuario();
			u.setId(rs.getInt("idUsuario"));
			administrador.setUsuario(u);
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return administrador;
	}
	
	public List<Administrador> pesquisarAdministrador(String email){
		
		List<Administrador> lista = new ArrayList<Administrador>();
		
		String sql = "select * from administrador where email like ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, "%"+email+"%");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Administrador adm = new Administrador();
				
				adm.setId(rs.getInt("id"));
				adm.setNome(rs.getString("nome"));
				adm.setTelefone(rs.getString("telefone"));
				adm.setFuncao(rs.getString("funcao"));
				adm.setEmail(rs.getString("email"));
				
				Usuario u = new Usuario();
				u.setId(rs.getInt("idUsuario"));
				adm.setUsuario(u);
				
				lista.add(adm);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void vincularUsuario(Administrador administrador){
		
		String sql = "update administrador set idUsuario=? where email like ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, administrador.getUsuario().getId());
			stmt.setString(2, administrador.getEmail());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Administrador> listarUsuario(int id){
		List<Administrador> lista = new ArrayList<Administrador>();
		
		String sql = "select a.id, u.id, u.email, u.tipoPerfil, u.statusPerfil from usuario as u join administrador as a on u.id=a.idUsuario where a.id=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Administrador administrador = new Administrador();
				
				administrador.setId(rs.getInt("a.id"));
				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("u.id"));
				usuario.setEmail(rs.getString("u.email"));
				usuario.setTipoPerfil(rs.getString("u.tipoPerfil"));
				usuario.setStatusPerfil(rs.getBoolean("u.statusPerfil"));
				
				administrador.setUsuario(usuario);
				
				lista.add(administrador);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
}
