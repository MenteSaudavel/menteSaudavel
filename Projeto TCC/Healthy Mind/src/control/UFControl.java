package control;

import java.util.List;

import model.dao.UFDao;
import model.vo.UF;

public class UFControl {
	
	public List<UF> listarUF(){
		
		UFDao ufDao = new UFDao();
		
		List<UF> lista = ufDao.listarUF();
		
		return lista;
	}
	
}
