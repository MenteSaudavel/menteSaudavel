package control;

import java.util.List;

import model.dao.PacienteDao;
import model.vo.Paciente;

public class PacienteControl {
	
	public boolean cadastrar(String nome, String telefone, String numeroCarteirinha, String cpf, String idConvenio){
		
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
		paciente.setIdConvenio(idConvenioConvertido);
		
		PacienteDao pacienteDao = new PacienteDao();
		pacienteDao.cadastrarPaciente(paciente);
		
		return true;
		
	}
	
	public boolean editar(String nome, String telefone, String numeroCarteirinha, String cpf, String idConvenio, String id){
		
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
			paciente.setIdConvenio(idConvenioConvertido);
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
			
			PacienteDao pacienteDao = new PacienteDao();
			
			return pacienteDao.buscarPaciente(idConvertido);
		} catch(NumberFormatException e){
			return null;
		}
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
}
