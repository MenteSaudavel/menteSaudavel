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
				c.setPresidente(rs.getString("presidente"));
				c.setCnpj(rs.getString("cnpj"));
				c.setTelefoneConvenio(rs.getString("telefoneConvenio"));
				c.setEnderecoConvenio(rs.getString("enderecoConvenio"));
				c.setCep(rs.getString("cep"));
				c.setCidadeConvenio(rs.getString("cidadeconvenio"));
				c.setUf(rs.getString("uf"));
				
				
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
		
		String sql = "insert into convenio (nome, presidente, cnpj, telefoneConvenio, enderecoConvenio, cep, cidadeConvenio, uf) values (?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, convenio.getNome());
			stmt.setString(2, convenio.getPresidente());
			stmt.setString(3, convenio.getCnpj());
			stmt.setString(4, convenio.getTelefoneConvenio());
			stmt.setString(5, convenio.getEnderecoConvenio());
			stmt.setString(6, convenio.getCep());
			stmt.setString(7, convenio.getCidadeConvenio());
			stmt.setString(8, convenio.getUf());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void editarConvenio(Convenio convenio){
		
		String sql = "update convenio set nome=?, presidente=?, cnpj=?, telefoneConvenio=?, enderecoConvenio=?, cep=?, cidadeConvenio=?, uf=? where idConvenio=?;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, convenio.getNome());
			stmt.setString(2, convenio.getPresidente());
			stmt.setString(3, convenio.getCnpj());
			stmt.setString(4, convenio.getTelefoneConvenio());
			stmt.setString(5, convenio.getEnderecoConvenio());
			stmt.setString(6, convenio.getCep());
			stmt.setString(7, convenio.getCidadeConvenio());
			stmt.setString(8, convenio.getUf());
			stmt.setInt(9, convenio.getId());
			
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
			convenio.setPresidente(rs.getString("presidente"));
			convenio.setCnpj(rs.getString("cnpj"));
			convenio.setTelefoneConvenio(rs.getString("telefoneConvenio"));
			convenio.setEnderecoConvenio(rs.getString("enderecoConvenio"));
			convenio.setCep(rs.getString("cep"));
			convenio.setCidadeConvenio(rs.getString("cidadeConvenio"));
			convenio.setUf(rs.getString("uf"));
			convenio.setId(rs.getInt("idConvenio"));
			
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return convenio;
	}
	
}
