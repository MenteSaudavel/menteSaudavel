package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.vo.Consulta;

public class ConsultaDao {
	
	Connection conexao;

	public ConsultaDao() {
		this.conexao = new FabricaConexoes().getConexao();
	}
	
	public void agendarConsulta(Consulta consulta){
		
		String sql = "insert into consulta(idPsicologo, idPaciente, dataConsulta, hora) values (?,?,?,?);";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, consulta.getIdPsicologo());
			stmt.setInt(2, consulta.getIdPaciente());
			stmt.setDate(3, consulta.getDataConsulta());
			stmt.setTime(4, consulta.getHoraConsulta());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
