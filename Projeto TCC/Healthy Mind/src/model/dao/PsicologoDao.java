package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Convenio;
import model.vo.Psicologo;
import model.vo.UF;
import model.vo.Usuario;

public class PsicologoDao {
	Connection conexao;

	public PsicologoDao() {
		this.conexao = new FabricaConexoes().getConexao();
	}
	
	/**
	 * Método para cadastrar psicólogo
	 * @param psicologo
	 */
	
	public void cadastrarPsicologo(Psicologo psicologo){
		
		String sql = "insert into psicologo (nome, telefoneConsultorio, idConvenio, idConvenio2, idConvenio3, idConvenio4, idConvenio5, crp, idUf, email) values (?,?,?,?,?,?,?,?,?,?);";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, psicologo.getNome());
			stmt.setString(2, psicologo.getTelefoneConsultorio());
			
			stmt.setInt(3, psicologo.getConvenio().getId());
			
			if(psicologo.getConvenio2()==null){
				stmt.setNull(4, 0);
			} else {
				stmt.setInt(4, psicologo.getConvenio2().getId());
			}
			
			if(psicologo.getConvenio3()==null){
				stmt.setNull(5, 0);
			} else {
				stmt.setInt(5, psicologo.getConvenio3().getId());
			}
			
			if(psicologo.getConvenio4()==null){
				stmt.setNull(6, 0);
			} else {
				stmt.setInt(6, psicologo.getConvenio4().getId());
			}
			
			if(psicologo.getConvenio5()==null){
				stmt.setNull(7, 0);
			} else {
				stmt.setInt(7, psicologo.getConvenio5().getId());
			}
			
			stmt.setString(8, psicologo.getCrp());
			stmt.setInt(9, psicologo.getUf().getId());
			stmt.setString(10, psicologo.getEmail());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editarEmail(Psicologo psicologo){
		
		String sql = "update psicologo set email=? where idPsicologo=?;";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, psicologo.getEmail());
			stmt.setInt(2, psicologo.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void editarPsicologo(Psicologo psicologo){
		
		String sql = "update psicologo set nome=?, telefoneConsultorio=?, idConvenio=?, idConvenio2=?, idConvenio3=?, idConvenio4=?, idConvenio5=?, crp=? where idPsicologo=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, psicologo.getNome());
			stmt.setString(2, psicologo.getTelefoneConsultorio());
			stmt.setInt(3, psicologo.getConvenio().getId());
			
			if(psicologo.getConvenio2()==null){
				stmt.setNull(4, 0);
			} else {
				stmt.setInt(4, psicologo.getConvenio2().getId());
			}
			
			if(psicologo.getConvenio3()==null){
				stmt.setNull(5, 0);
			} else {
				stmt.setInt(5, psicologo.getConvenio3().getId());
			}
			
			if(psicologo.getConvenio4()==null){
				stmt.setNull(6, 0);
			} else {
				stmt.setInt(6, psicologo.getConvenio4().getId());
			}
			
			if(psicologo.getConvenio5()==null){
				stmt.setNull(7, 0);
			} else {
				stmt.setInt(7, psicologo.getConvenio5().getId());
			}
			
			stmt.setString(8, psicologo.getCrp());
			stmt.setInt(9, psicologo.getId());

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
			ConvenioDao convenioDao = new ConvenioDao();
			
			while(rs.next()){
				
				Psicologo p = new Psicologo();
				Convenio c = convenioDao.buscarConvenio(rs.getInt("idConvenio"));
				
				p.setId(rs.getInt("idPsicologo"));
				p.setNome(rs.getString("nome"));
				p.setTelefoneConsultorio(rs.getString("telefoneConsultorio"));
				p.setConvenio(c);
				p.setCrp(rs.getString("crp"));
				p.setEmail(rs.getString("email"));
				
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
		
		String sql = "select p.idPsicologo, p.nome, p.telefoneConsultorio, p.idConvenio, p.idConvenio2, p.idConvenio3, p.idConvenio4, p.idConvenio5, p.crp, p.email, p.idUsuario, p.idUf, uf.sigla, group_concat(distinct c.nome order by p.nome asc separator ', ') as Convenios from psicologo as p join convenio as c on p.idConvenio = c.idConvenio or p.idConvenio2 = c.idConvenio or p.idConvenio3 = c.idConvenio or p.idConvenio4 = c.idConvenio or p.idConvenio5 = c.idConvenio join uf on p.idUf = uf.idUf group by p.idPsicologo";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Psicologo p = new Psicologo();
				
				p.setId(rs.getInt("p.idPsicologo"));
				p.setNome(rs.getString("p.nome"));
				p.setTelefoneConsultorio(rs.getString("p.telefoneConsultorio"));
				
				Convenio c = new Convenio();
				c.setNome(rs.getString("Convenios"));
				p.setConvenio(c);
				
				p.setCrp(rs.getString("p.crp"));
				
				UF uf = new UF();
				uf.setId(rs.getInt("p.idUf"));
				uf.setSigla(rs.getString("uf.sigla"));
				p.setUf(uf);
				
				p.setEmail(rs.getString("p.email"));
				
				Usuario u = new Usuario();
				u.setId(rs.getInt("p.idUsuario"));
				p.setUsuario(u);
				
				lista.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public Psicologo buscarPsicologo(int id){
		
		Psicologo p = new Psicologo();
		
		String sql = "select * from psicologo where idPsicologo=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			ConvenioDao convenioDao = new ConvenioDao();
			
			rs.next();
			Convenio c = convenioDao.buscarConvenio(rs.getInt("idConvenio"));
			Convenio c2 = convenioDao.buscarConvenio(rs.getInt("idConvenio2"));
			Convenio c3 = convenioDao.buscarConvenio(rs.getInt("idConvenio3"));
			Convenio c4 = convenioDao.buscarConvenio(rs.getInt("idConvenio4"));
			Convenio c5 = convenioDao.buscarConvenio(rs.getInt("idConvenio5"));
			
			p.setNome(rs.getString("nome"));
			p.setTelefoneConsultorio(rs.getString("telefoneConsultorio"));
			p.setConvenio(c);
			p.setConvenio2(c2);
			p.setConvenio3(c3);
			p.setConvenio4(c4);
			p.setConvenio5(c5);
			p.setCrp(rs.getString("crp"));
			p.setEmail(rs.getString("email"));
			p.setId(rs.getInt("idPsicologo"));
			stmt.close();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
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
	
	public List<Psicologo> listarPsicologoSelect(int idConvenio){
		
		List<Psicologo> lista = new ArrayList<Psicologo>();
		
		String sql = "select * from psicologo where idConvenio=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, idConvenio);
			
			ResultSet rs = stmt.executeQuery();
			ConvenioDao convenioDao = new ConvenioDao();
			
			while(rs.next()){
				
				Psicologo p = new Psicologo();
				Convenio c = convenioDao.buscarConvenio(rs.getInt("idConvenio"));
				
				p.setId(rs.getInt("idPsicologo"));
				p.setNome(rs.getString("nome"));
				p.setTelefoneConsultorio(rs.getString("telefoneConsultorio"));
				p.setConvenio(c);
				p.setCrp(rs.getString("crp"));
				p.setEmail(rs.getString("email"));
						
				lista.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public List<Psicologo> pesquisarPsicologoEmail(String email){
		
		List<Psicologo> lista = new ArrayList<Psicologo>();
		
		String sql = "select * from psicologo where email like ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Psicologo psicologo = new Psicologo();
				
				psicologo.setId(rs.getInt("idPsicologo"));
				psicologo.setNome(rs.getString("nome"));
				psicologo.setTelefoneConsultorio(rs.getString("telefoneConsultorio"));
				psicologo.setCrp(rs.getString("crp"));
				psicologo.setEmail(rs.getString("email"));
				
				Usuario u = new Usuario();
				u.setId(rs.getInt("idUsuario"));
				psicologo.setUsuario(u);
				
				lista.add(psicologo);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void vincularUsuario(Psicologo psicologo){
		
		String sql = "update psicologo set idUsuario=? where email like ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, psicologo.getUsuario().getId());
			stmt.setString(2, psicologo.getEmail());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Psicologo> listarUsuario(int id){
		List<Psicologo> lista = new ArrayList<Psicologo>();
		
		String sql = "select p.idPsicologo, u.id, u.email, u.tipoPerfil, u.statusPerfil from usuario as u join psicologo as p on u.id=p.idUsuario where p.idPsicologo=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Psicologo psicologo = new Psicologo();
				
				psicologo.setId(rs.getInt("p.idPsicologo"));
				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("u.id"));
				usuario.setEmail(rs.getString("u.email"));
				usuario.setTipoPerfil(rs.getString("u.tipoPerfil"));
				usuario.setStatusPerfil(rs.getBoolean("u.statusPerfil"));
				
				psicologo.setUsuario(usuario);
				
				lista.add(psicologo);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
}
