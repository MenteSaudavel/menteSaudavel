package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.vo.Agenda;
import model.vo.Psicologo;
import model.vo.Turno;

public class AgendaDao {

	Connection conexao;

	public AgendaDao() {
		this.conexao = new FabricaConexoes().getConexao();
	}
	
	public void cadastrarAgenda(Agenda agenda){
		
		String sql = "insert into agenda (idPsicologo, dataAtendimento, idTurno1, idTurno2, idTurno3) values (?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, agenda.getPsicologo().getId());
			stmt.setDate(2, new Date(agenda.getData().getTime()));
			
			if(agenda.getTurno1()==null){
				stmt.setNull(3, 0);
			} else {
				stmt.setInt(3, agenda.getTurno1().getId());
			}
			
			if(agenda.getTurno2()==null){
				stmt.setNull(4, 0);
			} else {
				stmt.setInt(4, agenda.getTurno2().getId());
			}
			
			if(agenda.getTurno3()==null){
				stmt.setNull(5, 0);
			} else {
				stmt.setInt(5, agenda.getTurno3().getId());
			}
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Turno> listarTurno(int idPsicologo, java.util.Date dataAtendimento){
		List<Turno> lista = new ArrayList<Turno>();
		
		String sql = "select t.id, t.nome from turno as t join agenda as a on t.id=a.idTurno1 or t.id=a.idTurno2 or t.id=a.idTurno3 where a.idPsicologo=? and a.dataAtendimento like?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, idPsicologo);
			stmt.setDate(2, new Date(dataAtendimento.getTime()));
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Turno turno = new Turno();
				turno.setId(rs.getInt("t.id"));
				turno.setNome(rs.getString("t.nome"));
				
				lista.add(turno);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Agenda> listarDatas(int idPsicologo){
		List<Agenda> lista = new ArrayList<Agenda>();
		
		String sql = "select a.id, a.dataAtendimento from agenda as a where a.idPsicologo=? order by a.dataAtendimento asc";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, idPsicologo);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Agenda agenda = new Agenda();
				
				agenda.setId(rs.getInt("a.id"));
				agenda.setData(rs.getDate("a.dataAtendimento"));
				
				lista.add(agenda);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Agenda buscarIdAgenda(java.util.Date dataAtendimento){
		
		Agenda agenda = new Agenda();
		
		String sql = "select a.id, a.dataAtendimento from agenda as a where a.dataAtendimento like ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setDate(1, new Date(dataAtendimento.getTime()));
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();

			agenda.setId(rs.getInt("a.id"));
			agenda.setData(rs.getDate("a.dataAtendimento"));

			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return agenda;
	}
	
	public List<Agenda> pesquisarData(java.util.Date dataAtendimento){
		
		List<Agenda> lista = new ArrayList<Agenda>();
		
		String sql = "select * from agenda where dataAtendimento like ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setDate(1, new Date(dataAtendimento.getTime()));
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Agenda agenda = new Agenda();
				
				agenda.setId(rs.getInt("id"));
				
				Psicologo psicologo = new Psicologo();
				psicologo.setId(rs.getInt("idPsicologo"));
				agenda.setPsicologo(psicologo);
				
				agenda.setData(rs.getDate("dataAtendimento"));
				
				Turno turno1 = new Turno();
				turno1.setId(rs.getInt("idTurno1"));
				agenda.setTurno1(turno1);
				
				Turno turno2 = new Turno();
				turno2.setId(rs.getInt("idTurno2"));
				agenda.setTurno2(turno2);
				
				Turno turno3 = new Turno();
				turno3.setId(rs.getInt("idTurno3"));
				agenda.setTurno3(turno3);
				
				lista.add(agenda);
				
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
}
