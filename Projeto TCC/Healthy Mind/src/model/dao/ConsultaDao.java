package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Agenda;
import model.vo.Consulta;
import model.vo.Horario;
import model.vo.Psicologo;
import model.vo.Turno;

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
			stmt.setInt(2, consulta.getPaciente().getId());
			stmt.setDate(3, new Date(consulta.getDataConsulta().getTime()));
			stmt.setTime(4, consulta.getHora());
			
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
			stmt.setTime(3, consulta.getHora());
			stmt.setInt(4, consulta.getId());
			
			System.out.println(stmt.toString());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void desmarcarConsulta(Consulta consulta){
		
		String sql = "update consulta set statusConsulta=false where idConsulta=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, consulta.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Consulta> visualizarConsulta(int idPaciente){
		List<Consulta> lista = new ArrayList<Consulta>();
		
		String sql = "select c.idConsulta, p.nome, c.dataConsulta, c.hora, c.tipoConsulta, c.statusConsulta from consulta as c join psicologo as p on c.idPsicologo=p.idPsicologo where c.idPaciente=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, idPaciente);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Consulta consulta = new Consulta();
				
				consulta.setId(rs.getInt("c.idConsulta"));
				
				Psicologo psicologo = new Psicologo();
				psicologo.setNome(rs.getString("p.nome"));
				consulta.setPsicologo(psicologo);
				
				consulta.setDataConsulta(rs.getDate("c.dataConsulta"));
				consulta.setHora(rs.getTime("c.hora"));
				consulta.setTipoConsulta(rs.getString("c.tipoConsulta"));
				consulta.setStatusConsulta(rs.getBoolean("c.statusConsulta"));
				
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
			consulta.setId(rs.getInt("idConsulta"));
			consulta.setDataConsulta(rs.getDate("dataConsulta"));
			consulta.setHora(rs.getTime("hora"));
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consulta;
	}
	
	public void agendarPsicologo(Consulta consulta){
		
		String sql = "insert into consulta (idPsicologo, idPaciente) values (?,?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, consulta.getPsicologo().getId());
			stmt.setInt(2, consulta.getPaciente().getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void agendarDataHorario(Consulta consulta){
		
		String sql = "update consulta set dataConsulta=?, hora=?, tipoConsulta=? where idPaciente=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setDate(1, new Date(consulta.getDataConsulta().getTime()));
			stmt.setTime(2, consulta.getHora());
			stmt.setString(3, consulta.getTipoConsulta());
			stmt.setInt(4, consulta.getPaciente().getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Horario> visualizarDataHoraDisponível(int idPsicologo){
		List<Horario> lista = new ArrayList<Horario>();
		
		String sql = "select * from agenda as a join horario as h on a.id=h.idAgenda where a.idPsicologo=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, idPsicologo);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Horario horario = new Horario();
				
				horario.setId(rs.getInt("h.id"));
				
				Agenda agenda = new Agenda();
				agenda.setId(rs.getInt("a.id"));
				Psicologo psicologo = new Psicologo();
				psicologo.setId(rs.getInt("a.idPsicologo"));
				agenda.setPsicologo(psicologo);
				agenda.setData(rs.getDate("a.dataAtendimento"));
				Turno turno1 = new Turno();
				turno1.setId(rs.getInt("a.idTurno1"));
				agenda.setTurno1(turno1);
				Turno turno2 = new Turno();
				turno2.setId(rs.getInt("a.idTurno2"));
				agenda.setTurno2(turno2);
				Turno turno3 = new Turno();
				turno3.setId(rs.getInt("a.idTurno3"));
				agenda.setTurno3(turno3);
				horario.setAgenda(agenda);
				
				Turno turno = new Turno();
				turno.setId(rs.getInt("h.idTurno"));
				horario.setTurno(turno);
				
				horario.setHora1(rs.getTime("h.hora1"));
				horario.setHora2(rs.getTime("h.hora2"));
				horario.setHora3(rs.getTime("h.hora3"));
				horario.setHora4(rs.getTime("h.hora4"));
				
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
