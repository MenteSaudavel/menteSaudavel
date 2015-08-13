package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Consulta;
import model.vo.Psicologo;

public class ConsultaDao {
	
	Connection conexao;

	public ConsultaDao() {
		this.conexao = new FabricaConexoes().getConexao();
	}
	
	public void agendarConsulta(Consulta consulta){
		
		String sql = "insert into consulta(idPsicologo, idPaciente, dataConsulta, hora) values (?,?,?,?);";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, consulta.getPsicologo().getId());
			stmt.setInt(2, consulta.getIdPaciente());
			stmt.setDate(3, new Date(consulta.getDataConsulta().getTime()));
			stmt.setTime(4, consulta.getHoraConsulta());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remarcarConsulta(Consulta consulta){
		
		String sql = "update consulta set idPsicologo=?, dataConsulta=?, hora=? where idConsulta=?;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, consulta.getPsicologo().getId());
			stmt.setDate(2, new Date(consulta.getDataConsulta().getTime()));
			stmt.setTime(3, consulta.getHoraConsulta());
			stmt.setInt(4, consulta.getIdConsulta());
			
			System.out.println(stmt.toString());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void desmarcarConsulta(Consulta consulta){
		
		String sql = "delete from consulta where idConsulta=?;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, consulta.getIdConsulta());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Consulta> visualizarConsulta(){
		List<Consulta> lista = new ArrayList<Consulta>();
		
		String sql = "select * from consulta inner join psicologo on psicologo.idPsicologo=consulta.idPsicologo";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Consulta consulta = new Consulta();
				
				Psicologo psicologo = new Psicologo();
				psicologo.setId(rs.getInt("idPsicologo"));
				psicologo.setNome(rs.getString("nome"));
				//fazer o resto psicologo d3spois;
				
				consulta.setPsicologo(psicologo);
				consulta.setIdConsulta(rs.getInt("idConsulta"));
				consulta.setDataConsulta(rs.getDate("dataConsulta"));
				consulta.setHoraConsulta(rs.getTime("hora"));
				
				lista.add(consulta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Consulta buscarConsulta(int id){
		
		Consulta consulta = new Consulta();
		
		String sql = "select * from consulta inner join psicologo on psicologo.idPsicologo=consulta.idPsicologo where idConsulta=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			Psicologo psicologo = new Psicologo();
			psicologo.setId(rs.getInt("idPsicologo"));
			psicologo.setNome(rs.getString("nome"));
			//fazer o resto psicologo d3spois;
			
			consulta.setPsicologo(psicologo);
			consulta.setIdConsulta(rs.getInt("idConsulta"));
			consulta.setDataConsulta(rs.getDate("dataConsulta"));
			consulta.setHoraConsulta(rs.getTime("hora"));
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consulta;
	}
	
}
