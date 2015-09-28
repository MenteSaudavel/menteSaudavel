package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Convenio;
import model.vo.UF;

public class ConvenioDao {
	Connection conexao;

	public ConvenioDao() {
		this.conexao = new FabricaConexoes().getConexao();
	}
	
	public List<Convenio> listarConvenios(){
		
		List<Convenio> lista = new ArrayList<Convenio>();
		
		String sql = "select * from convenio inner join uf on convenio.idUf = uf.idUf;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			UF uf = new UF();
			
			while(rs.next()){
				
				Convenio c = new Convenio();
				
				uf.setId(rs.getInt("uf.idUf"));
				uf.setCodigoIbge(rs.getInt("uf.codigo_ibge"));
				uf.setSigla(rs.getString("uf.sigla"));
				uf.setNome(rs.getString("uf.nome"));
				
				c.setId(rs.getInt("convenio.idConvenio"));
				c.setNome(rs.getString("convenio.nome"));
				c.setPresidente(rs.getString("convenio.presidente"));
				c.setCnpj(rs.getString("convenio.cnpj"));
				c.setTelefoneConvenio(rs.getString("convenio.telefoneConvenio"));
				c.setEnderecoConvenio(rs.getString("convenio.enderecoConvenio"));
				c.setCep(rs.getString("convenio.cep"));
				c.setCidadeConvenio(rs.getString("convenio.cidadeconvenio"));
				c.setUf(uf);

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
		
		String sql = "insert into convenio (nome, presidente, cnpj, telefoneConvenio, enderecoConvenio, cep, cidadeConvenio, idUf) values (?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, convenio.getNome());
			stmt.setString(2, convenio.getPresidente());
			stmt.setString(3, convenio.getCnpj());
			stmt.setString(4, convenio.getTelefoneConvenio());
			stmt.setString(5, convenio.getEnderecoConvenio());
			stmt.setString(6, convenio.getCep());
			stmt.setString(7, convenio.getCidadeConvenio());
			stmt.setInt(8, convenio.getUf().getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void editarConvenio(Convenio convenio){
		
		String sql = "update convenio set nome=?, presidente=?, cnpj=?, telefoneConvenio=?, enderecoConvenio=?, cep=?, cidadeConvenio=?, idUf=? where idConvenio=?;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, convenio.getNome());
			stmt.setString(2, convenio.getPresidente());
			stmt.setString(3, convenio.getCnpj());
			stmt.setString(4, convenio.getTelefoneConvenio());
			stmt.setString(5, convenio.getEnderecoConvenio());
			stmt.setString(6, convenio.getCep());
			stmt.setString(7, convenio.getCidadeConvenio());
			stmt.setInt(8, convenio.getUf().getId());
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
		
		String sql = "select * from convenio inner join uf on convenio.idUf=uf.idUf where idConvenio=?;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			UF uf = new UF();
			uf.setId(rs.getInt("uf.idUf"));
			
			convenio.setNome(rs.getString("convenio.nome"));
			convenio.setPresidente(rs.getString("convenio.presidente"));
			convenio.setCnpj(rs.getString("convenio.cnpj"));
			convenio.setTelefoneConvenio(rs.getString("convenio.telefoneConvenio"));
			convenio.setEnderecoConvenio(rs.getString("convenio.enderecoConvenio"));
			convenio.setCep(rs.getString("convenio.cep"));
			convenio.setCidadeConvenio(rs.getString("convenio.cidadeConvenio"));
			convenio.setUf(uf);
			convenio.setId(rs.getInt("convenio.idConvenio"));
			
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return convenio;
	}
}
