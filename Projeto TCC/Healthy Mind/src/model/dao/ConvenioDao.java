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
	
}
