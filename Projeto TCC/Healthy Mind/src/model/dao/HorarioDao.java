package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Agenda;
import model.vo.Horario;
import model.vo.Turno;

public class HorarioDao {
	
	Connection conexao;

	public HorarioDao() {
		this.conexao = new FabricaConexoes().getConexao();
	}
	
	public void cadastrarHorario(Horario horario){
		
		String sql = "insert into horario (idAgenda, idTurno) values (?,?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, horario.getAgenda().getId());
			stmt.setInt(2, horario.getTurno().getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editarHorario(Horario horario){
		
		String sql = "update horario set hora1=?, hora2=?, hora3=?, hora4=? where id=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			if(horario.getHora1()==null){
				stmt.setNull(1, 0);
			} else {
				stmt.setTime(1, horario.getHora1());
			}
			
			if(horario.getHora2()==null){
				stmt.setNull(2, 0);
			} else {
				stmt.setTime(2, horario.getHora2());
			}
			
			if(horario.getHora3()==null){
				stmt.setNull(3, 0);
			} else {
				stmt.setTime(3, horario.getHora3());
			}
			
			if(horario.getHora4()==null){
				stmt.setNull(4, 0);
			} else {
				stmt.setTime(4, horario.getHora4());
			}
			
			stmt.setInt(5, horario.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Horario buscarHorario(int idAgenda, int idTurno){
		
		Horario horario = new Horario();
		
		Agenda agenda = new Agenda();
		
		Turno turno = new Turno();
		
		String sql = "select * from horario where idAgenda=? and idTurno=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, idAgenda);
			stmt.setInt(2, idTurno);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			horario.setId(rs.getInt("id"));
			
			agenda.setId(rs.getInt("idAgenda"));
			horario.setAgenda(agenda);
			
			turno.setId(rs.getInt("idTurno"));
			horario.setTurno(turno);
			
			horario.setHora1(rs.getTime("hora1"));
			horario.setHora2(rs.getTime("hora2"));
			horario.setHora3(rs.getTime("hora3"));
			horario.setHora4(rs.getTime("hora4"));
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return horario;
	}
	
public Horario buscarHorario(int idAgenda){
		
		Horario horario = new Horario();
		
		Agenda agenda = new Agenda();
		
		Turno turno = new Turno();
		
		String sql = "select * from horario where idAgenda=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, idAgenda);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			try{
				horario.setId(rs.getInt("id"));
				
				agenda.setId(rs.getInt("idAgenda"));
				horario.setAgenda(agenda);
				
				turno.setId(rs.getInt("idTurno"));
				horario.setTurno(turno);
				
				horario.setHora1(rs.getTime("hora1"));
				horario.setHora2(rs.getTime("hora2"));
				horario.setHora3(rs.getTime("hora3"));
				horario.setHora4(rs.getTime("hora4"));
				
			}catch(SQLException e){
				horario=null;
			}

			stmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return horario;
	}
	
	public List<Horario> listarHorario(int idAgenda){
		List<Horario> lista = new ArrayList<Horario>();
		
		String sql = "select h.idAgenda, h.idTurno, t.nome from turno as t join horario as h on t.id=h.idTurno where h.idAgenda=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, idAgenda);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Horario horario = new Horario();
				
				Agenda agenda = new Agenda();
				agenda.setId(rs.getInt("h.idAgenda"));
				horario.setAgenda(agenda);
				
				Turno turno = new Turno();
				turno.setId(rs.getInt("h.idTurno"));
				horario.setTurno(turno);
				
				lista.add(horario);
				
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return lista;
	}
}
