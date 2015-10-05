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
 * Servlet implementation class EditarPacienteServlet
 */
@WebServlet("/editarPacienteServlet")
public class EditarPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarPacienteServlet() {
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
			
				String id = request.getParameter("id");
	
				PacienteControl pacienteControl = new PacienteControl();
	
				Paciente paciente = pacienteControl.buscarPaciente(id);
	
				ConvenioControl convenioControl = new ConvenioControl();
	
				List<Convenio> lista = convenioControl.listarConvenios();
	
				request.setAttribute("lista", lista);
	
				if (paciente != null) {
					request.setAttribute("paciente", paciente);
					request.getRequestDispatcher(
							"WEB-INF/administrador/editarPaciente.jsp").forward(
							request, response);
				} else {
					request.setAttribute("erro", "Paciente não encontrado");
					request.getRequestDispatcher(
							"WEB-INF/administrador/listarPaciente.jsp").forward(
							request, response);
				}
				
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

			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			String numeroCarteirinha = request
					.getParameter("numeroCarteirinha");
			String cpf = request.getParameter("cpf");
			String idConvenio = request.getParameter("idConvenio");
			String id = request.getParameter("id");

			PacienteControl pacienteControl = new PacienteControl();

			boolean ok = pacienteControl.editarPaciente(nome, telefone,
					numeroCarteirinha, cpf, idConvenio, id);
			
			request.setAttribute("listaPaciente",
					pacienteControl.listarPaciente());

			if (ok) {
				request.setAttribute("editado", true);
				request.getRequestDispatcher(
						"WEB-INF/administrador/listarPaciente.jsp").forward(
						request, response);

			} else {
				request.setAttribute("editado", false);
				request.getRequestDispatcher(
						"WEB-INF/administrador/listarPaciente.jsp").forward(
						request, response);

			}

		} else {
			response.sendRedirect("loginServlet");
		}
	}

}
