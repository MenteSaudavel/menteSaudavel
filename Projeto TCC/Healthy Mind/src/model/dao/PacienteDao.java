package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Paciente;

public class PacienteDao {

	Connection conexao;

	public PacienteDao() {
		this.conexao = new FabricaConexoes().getConexao();
	}

	public void cadastrarPaciente(Paciente paciente) {

		String sql = "insert into paciente (nome, telefone, numeroCarteirinha, cpf, idConvenio) values (?,?,?,?,?,?,?,?,?,?);";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, paciente.getNome());
			stmt.setString(7, paciente.getTelefone());
			stmt.setString(8, paciente.getNumeroCarteirinha());
			stmt.setString(9, paciente.getCpf());
			stmt.setInt(10, paciente.getIdConvenio());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void editarPaciente(Paciente paciente){
	
		String sql = "update paciente set nome=?, telefone=?, numeroCarteirinha=?, cpf=?, idConvenio=? where idPaciente=?;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, paciente.getNome());
			stmt.setString(7, paciente.getTelefone());
			stmt.setString(8, paciente.getNumeroCarteirinha());
			stmt.setString(9, paciente.getCpf());
			stmt.setInt(10, paciente.getIdConvenio());
			stmt.setInt(11, paciente.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Paciente> pesquisarPaciente(String nome){
		
		List<Paciente> lista = new ArrayList<Paciente>();
		
		String sql = "select * from paciente where nome like ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, "%"+nome+"%");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Paciente p = new Paciente();
				
				p.setId(rs.getInt("idPaciente"));
				p.setNome(rs.getString("nome"));
				p.setTelefone(rs.getString("telefone"));
				p.setNumeroCarteirinha(rs.getString("numeroCarteirinha"));
				p.setCpf(rs.getString("cpf"));
				p.setIdConvenio(rs.getInt("idConvenio"));
				
				lista.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Paciente> listarPaciente(){
		
		List<Paciente> lista = new ArrayList<Paciente>();
		
		String sql = "select * from paciente;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Paciente p = new Paciente();
				
				p.setId(rs.getInt("idPaciente"));
				p.setNome(rs.getString("nome"));
				p.setTelefone(rs.getString("telefone"));
				p.setNumeroCarteirinha(rs.getString("numeroCarteirinha"));
				p.setCpf(rs.getString("cpf"));
				p.setIdConvenio(rs.getInt("idConvenio"));
				
				lista.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Paciente buscarPaciente(int id){
		
		Paciente paciente = new Paciente();
		
		String sql = "select * from paciente where idPaciente=?;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			paciente.setNome(rs.getString("nome"));
			paciente.setTelefone(rs.getString("telefone"));
			paciente.setNumeroCarteirinha(rs.getString("numeroCarteirinha"));
			paciente.setCpf(rs.getString("cpf"));
			paciente.setIdConvenio(rs.getInt("idConvenio"));
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return paciente;
	}
	
	public void apagarPaciente(Paciente paciente){
		
		String sql = "delete from paciente where idPaciente=?;";
		
		PreparedStatement stmt;
		
		try{
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, paciente.getId());
			
			stmt.execute();
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
