package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Convenio;

public class ConvenioDao {
	Connection conexao;

	public ConvenioDao() {
		this.conexao = new FabricaConexoes().getConexao();
	}
	
	public List<Convenio> listarConvenios(){
		List<Convenio> lista = new ArrayList<Convenio>();
		
		String sql = "select * from convenio;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Convenio c = new Convenio();
				
				c.setId(rs.getInt("idConvenio"));
				c.setNome(rs.getString("nome"));
				
				lista.add(c);
			}
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Convenio> listarConvenioPaciente(){
		List<Convenio> lista = new ArrayList<Convenio>();
		
		String sql = ;
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Convenio c = new Convenio();
				
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				
				lista.add(c);
			}
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public void cadastrarConvenio(Convenio convenio){
		String sql = "insert into convenio(nome) values (?);";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, convenio.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void editarConvenio(Convenio convenio){
		
		String sql = "update convenio set nome=? where idConvenio=?;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, convenio.getNome());
			stmt.setInt(2, convenio.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void apagarConvenio(Convenio convenio){
		
		String sql = "delete from convenio where idConvenio=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, convenio.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Convenio buscarConvenio(int id){
		
		Convenio convenio = new Convenio();
		
		String sql = "select * from convenio where idConvenio=?;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			convenio.setNome(rs.getString("nome"));
			convenio.setId(rs.getInt("idConvenio"));
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return convenio;
	}
	
}
