package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.Convenio;
import model.vo.Paciente;
import model.vo.Usuario;
import control.ConvenioControl;
import control.PacienteControl;

/**
 * Servlet implementation class ListarPacienteServlet
 */
@WebServlet("/listarPacienteServlet")
public class ListarPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarPacienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null) {
			request.setAttribute("usuario", usuario);
			
			if(usuario.getTipoPerfil().equals("administrador")){
			
				PacienteControl pacienteControl = new PacienteControl();
	
				List<Paciente> lista = pacienteControl.listarPaciente();
	
				request.setAttribute("listaPaciente", lista);
	
				ConvenioControl convenioControl = new ConvenioControl();
	
				List<Convenio> listac = convenioControl.listarConvenios();
	
				request.setAttribute("listac", listac);
	
				request.getRequestDispatcher(
						"WEB-INF/administrador/listarPaciente.jsp").forward(
						request, response);
			} else {
				response.sendRedirect("loginServlet");
			}

		} else {
			response.sendRedirect("loginServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
