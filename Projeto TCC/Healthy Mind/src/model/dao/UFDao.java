package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.UF;

public class UFDao {

	Connection conexao;
	
	public UFDao(){
		this.conexao = new FabricaConexoes().getConexao();
	}
	
	public List<UF> listarUF(){
		
		List<UF> lista = new ArrayList<UF>();
		
		String sql = "select * from uf";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				UF uf = new UF();
				
				uf.setId(rs.getInt("idUf"));
				uf.setCodigoIbge(rs.getInt("codigo_ibge"));
				uf.setSigla(rs.getString("sigla"));
				uf.setNome(rs.getString("nome"));
				
				lista.add(uf);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
