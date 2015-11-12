package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.ConsultaControl;
import control.PacienteControl;
import control.PsicologoControl;
import model.vo.Horario;
import model.vo.Paciente;
import model.vo.Psicologo;
import model.vo.Usuario;

/**
 * Servlet implementation class AgendarPsicologoServlet
 */
@WebServlet("/agendarPsicologoServlet")
public class AgendarPsicologoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendarPsicologoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario != null){
			request.setAttribute("usuario", usuario);
			
			if(usuario.getTipoPerfil().equals("paciente")){
				
				String id = String.valueOf(usuario.getId());
				PacienteControl pacienteControl = new PacienteControl();
				Paciente paciente = pacienteControl.pesquisarConvenioPaciente(id);
				
				String idConvenio = String.valueOf(paciente.getConvenio().getId());
				
				PsicologoControl psicologoControl = new PsicologoControl();
				List<Psicologo> listaPsicologo = psicologoControl.listarPsicologoSelect(idConvenio);
				request.setAttribute("listaPsicologo", listaPsicologo);
				
				request.getRequestDispatcher("WEB-INF/paciente/agendarPsicologo.jsp").forward(request, response);
				
			} else{
				response.sendRedirect("loginServlet");
			}
			
			
		} else {
			response.sendRedirect("loginServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario != null){
			request.setAttribute("usuario", usuario);
			
			String idUsuario = String.valueOf(usuario.getId());
			PacienteControl pacienteControl = new PacienteControl();
			Paciente paciente = pacienteControl.buscarPacienteUsuario(idUsuario);
			
			String idPaciente = String.valueOf(paciente.getId());
			String idPsicologo = request.getParameter("idPsicologo");
			
			ConsultaControl consultaControl = new ConsultaControl();
			
			boolean ok = consultaControl.agendarPsicologo(idPaciente, idPsicologo);
			
			if(ok){
				request.setAttribute("cadastrado", true);
				
				List<Horario> lista = consultaControl.visualizarDataHoraDisponível(idPsicologo);
				
				request.setAttribute("listaDataHora", lista);
				
				request.getRequestDispatcher("WEB-INF/paciente/agendarDataHorario.jsp").forward(request, response);
			} else {
				request.setAttribute("cadastrado", false);
				
				request.getRequestDispatcher("WEB-INF/paciente/agendarPsicologo.jsp").forward(request, response);
			}
			
		} else {
			response.sendRedirect("loginServlet");
		}
	}

}
