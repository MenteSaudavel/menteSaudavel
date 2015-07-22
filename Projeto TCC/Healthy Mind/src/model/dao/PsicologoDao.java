package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Psicologo;

public class PsicologoDao {
	Connection conexao;

	public PsicologoDao() {
		this.conexao = new FabricaConexoes().getConexao();
	}
	/**
	 * Método para cadastrar Psicólogo
	 * @param psicologo
	 */
	public void cadastrarPsicologo(Psicologo psicologo){
		
		String sql = "insert into psicologo (nome, telefoneConsultorio, idConvenio, crp) values (?,?,?,?);";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, psicologo.getNome());
			stmt.setString(2, psicologo.getTelefoneConsultorio());
			
			stmt.setInt(3, psicologo.getIdConvenio());
			
			stmt.setString(4, psicologo.getCrp());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editarPsicologo(Psicologo psicologo){
		
		String sql = "update psicologo set nome=?, telefoneConsultorio=?, idConvenio=?, crp=? where idPsicologo=?;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, psicologo.getNome());
			stmt.setString(2, psicologo.getTelefoneConsultorio());
			stmt.setInt(3, psicologo.getIdConvenio());
			stmt.setString(4, psicologo.getCrp());
			stmt.setInt(5, psicologo.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Psicologo> pesquisarPsicologo(String nome){
		
		List<Psicologo> lista = new ArrayList<Psicologo>();
		
		String sql = "select * from psicologo where nome like ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, "%"+nome+"%");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Psicologo p = new Psicologo();
				
				p.setId(rs.getInt("idPsicologo"));
				p.setNome(rs.getString("nome"));
				p.setTelefoneConsultorio(rs.getString("telefoneConsultorio"));
				p.setIdConvenio(rs.getInt("idConvenio"));
				p.setCrp(rs.getString("crp"));
				
				lista.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public List<Psicologo> listarPsicologo(){
		
		List<Psicologo> lista = new ArrayList<Psicologo>();
		
		String sql = "select * from psicologo;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Psicologo p = new Psicologo();
				
				p.setId(rs.getInt("idPsicologo"));
				p.setNome(rs.getString("nome"));
				p.setTelefoneConsultorio(rs.getString("telefoneConsultorio"));
				p.setIdConvenio(rs.getInt("idConvenio"));
				p.setCrp(rs.getString("crp"));
				
				lista.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public Psicologo buscarPsicologo(int id){
		
		Psicologo psicologo = new Psicologo();
		
		String sql = "select * from psicologo where idPsicologo=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			psicologo.setNome(rs.getString("nome"));
			psicologo.setTelefoneConsultorio(rs.getString("telefoneConsultorio"));
			psicologo.setIdConvenio(rs.getInt("idConvenio"));
			psicologo.setCrp(rs.getString("crp"));
			psicologo.setId(rs.getInt("idPsicologo"));
			
			stmt.close();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return psicologo;
	}
	
	public void apagarPsicologo(Psicologo psicologo){
		
		String sql = "delete from psicologo where idPsicologo=?";
		
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, psicologo.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
