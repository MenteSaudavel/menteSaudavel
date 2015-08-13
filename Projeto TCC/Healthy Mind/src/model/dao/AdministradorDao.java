package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Administrador;

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
	
	public void editarAdministrador(Administrador administrador){
		
		String sql = "update administrador set nome=?, telefone=?, funcao=?, email=? where id=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, administrador.getNome());
			stmt.setString(2, administrador.getTelefone());
			stmt.setString(3, administrador.getFuncao());
			stmt.setString(4, administrador.getEmail());
			stmt.setInt(5, administrador.getId());
			
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
}
