package control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import model.dao.PacienteDao;
import model.dao.UsuarioDao;
import model.vo.Convenio;
import model.vo.Paciente;
import model.vo.Usuario;

public class PacienteControl {
	
	public boolean cadastrar(String nome, String telefone, String numeroCarteirinha, String cpf, String idConvenio, String email, String confNumCarteirinha) throws UsuarioException{
		
		if(!numeroCarteirinha.equals(confNumCarteirinha)){
			throw new UsuarioException("O número da carteirinha não foi digitado corretamente nos dois campos, tente novamente.");
		}
		
		String senhaConvertida;
		MessageDigest algorithm;
		
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
	        byte hashSenha[] = algorithm.digest(numeroCarteirinha.getBytes());
	        
	        senhaConvertida = new String(hashSenha);
		
		} catch (NoSuchAlgorithmException e) {
		
			throw new UsuarioException("Erro na conversão de senha: algoritmo não encontrado");
			
		}
		
		int idConvenioConvertido;
		
		try{
			
			idConvenioConvertido = Integer.parseInt(idConvenio);
			
		} catch(NumberFormatException e){
			return false;
		}
		
		Paciente paciente = new Paciente();
		
		paciente.setNome(nome);
		paciente.setTelefone(telefone);
		paciente.setNumeroCarteirinha(numeroCarteirinha);
		paciente.setCpf(cpf);
		
		Convenio convenio = new Convenio();
		convenio.setId(idConvenioConvertido);
		paciente.setConvenio(convenio);
		
		paciente.setEmail(email);
		
		PacienteDao pacienteDao = new PacienteDao();
		pacienteDao.cadastrarPaciente(paciente);
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail(email);
		usuario.setSenha(senhaConvertida);
		usuario.setTipoPerfil("paciente");
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.cadastrarUsuario(usuario);
		
		return true;
		
	}
	
	public boolean editarPaciente(String nome, String telefone, String numeroCarteirinha, String cpf, String idConvenio, String id){
		
		int idConvertido;
		int idConvenioConvertido;
		
		try{
			
			idConvertido = Integer.parseInt(id);
			idConvenioConvertido = Integer.parseInt(idConvenio);
			
			Paciente paciente = new Paciente();
			
			paciente.setNome(nome);
			paciente.setTelefone(telefone);
			paciente.setNumeroCarteirinha(numeroCarteirinha);
			paciente.setCpf(cpf);
			
			Convenio convenio = new Convenio();
			convenio.setId(idConvenioConvertido);
			paciente.setConvenio(convenio);
			
			paciente.setId(idConvertido);
			
			PacienteDao pacienteDao = new PacienteDao();
			pacienteDao.editarPaciente(paciente);
			
			return true;
		} catch(NumberFormatException e){
			return false;
		}
	}
	
	public List<Paciente> pesquisarPaciente(String nome){
		
		List<Paciente> lista;
		
		if(nome.isEmpty()){
			lista = null;
		}
		
		PacienteDao pacienteDao = new PacienteDao();
		
		lista = pacienteDao.pesquisarPaciente(nome);
		
		return lista;
	}
	
	public List<Paciente> listarPaciente(){
		
		PacienteDao pacienteDao = new PacienteDao();
		
		List<Paciente> lista = pacienteDao.listarPaciente();
		
		return lista;
	}
	
	public Paciente buscarPaciente(String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
			
		} catch(NumberFormatException e){
			return null;
		}
		
		PacienteDao pacienteDao = new PacienteDao();
		
		return pacienteDao.buscarPaciente(idConvertido);
	}

	public boolean apagarPaciente(String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
		} catch(NumberFormatException e){
			return false;
		}
		
		Paciente paciente = new Paciente();
		paciente.setId(idConvertido);
		
		PacienteDao pacienteDao = new PacienteDao();
		pacienteDao.apagarPaciente(paciente);
		
		return true;
	}
	
	public Paciente pesquisarConvenioPaciente(String id){
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
		} catch(NumberFormatException e){
			return null;
		}
		
		PacienteDao pacienteDao = new PacienteDao();
		
		return pacienteDao.pesquisarConvenioPaciente(idConvertido);
	}
	
	public List<Paciente> pesquisarPacienteEmail(String email){
		PacienteDao pacienteDao = new PacienteDao();
		
		List<Paciente> lista = pacienteDao.pesquisarPacienteEmail(email);
		
		return lista;
	}
	
	public boolean vincularUsuario(String idUsuario, String email){
		
		int idUsuarioConvertido;
		
		try{
			idUsuarioConvertido = Integer.parseInt(idUsuario);
		} catch(NumberFormatException e){
			return false;
		}
		
		Usuario usuario = new Usuario();
		usuario.setId(idUsuarioConvertido);
		
		Paciente paciente = new Paciente();
		paciente.setUsuario(usuario);
		paciente.setEmail(email);
		
		PacienteDao pacienteDao = new PacienteDao();
		pacienteDao.vincularUsuario(paciente);
		
		return true;
		
	}
	
	public List<Paciente> listarUsuario(String id){
		
		List<Paciente> lista;
		
		int idConvertido;
		
		try{
			idConvertido = Integer.parseInt(id);
		} catch(NumberFormatException e){
			return null;
		}
		
		PacienteDao pacienteDao = new PacienteDao();
		
		lista = pacienteDao.listarUsuario(idConvertido);
		
		return lista;
	}
}
