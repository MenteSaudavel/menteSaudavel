package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.Consulta;
import model.vo.Paciente;
import model.vo.Usuario;
import control.ConsultaControl;
import control.PacienteControl;

/**
 * Servlet implementation class VisualizarConsultaServlet
 */
@WebServlet("/visualizarConsultaServlet")
public class VisualizarConsultaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisualizarConsultaServlet() {
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
			
			if(usuario.getTipoPerfil().equals("paciente")){
				
				String idUsuario = String.valueOf(usuario.getId());
				PacienteControl pacienteControl = new PacienteControl();
				Paciente paciente = pacienteControl.buscarPacienteUsuario(idUsuario);
				
				String idPaciente = String.valueOf(paciente.getId());
				
				ConsultaControl consultaControl = new ConsultaControl();
	
				List<Consulta> lista = consultaControl.visualizarConsulta(idPaciente);
	
				request.setAttribute("listaConsulta", lista);
	
				request.getRequestDispatcher(
						"WEB-INF/paciente/visualizarConsulta.jsp").forward(request,
						response);
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

		HttpSession session = request.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null) {

			request.getRequestDispatcher(
					"WEB-INF/paciente/visualizarConsulta.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("loginServlet");
		}

	}

}
