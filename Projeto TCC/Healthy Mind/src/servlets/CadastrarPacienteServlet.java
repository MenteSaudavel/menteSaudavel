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
import model.vo.Usuario;
import control.ConvenioControl;
import control.PacienteControl;
import control.UsuarioException;

/**
 * Servlet implementation class CadastrarPacienteServlet
 */
@WebServlet("/cadastrarPacienteServlet")
public class CadastrarPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarPacienteServlet() {
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
			
				ConvenioControl convenioControl = new ConvenioControl();
	
				List<Convenio> lista = convenioControl.listarConvenios();
	
				request.setAttribute("lista", lista);
	
				request.getRequestDispatcher(
						"WEB-INF/administrador/cadastrarPaciente.jsp").forward(
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

		HttpSession session = request.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null) {

			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			String numeroCarteirinha = request
					.getParameter("numeroCarteirinha");
			String cpf = request.getParameter("cpf");
			String idConvenio = request.getParameter("idConvenio");
			String email = request.getParameter("email");
			String confNumCarteirinha = request
					.getParameter("confNumCarteirinha");

			PacienteControl pacienteControl = new PacienteControl();

			try {
				pacienteControl.cadastrar(nome, telefone, numeroCarteirinha,
						cpf, idConvenio, email, confNumCarteirinha);

				request.setAttribute("cadastrado", true);

				ConvenioControl convenioControl = new ConvenioControl();

				List<Convenio> lista = convenioControl.listarConvenios();

				request.setAttribute("lista", lista);

				request.getRequestDispatcher(
						"WEB-INF/administrador/cadastrarPaciente.jsp").forward(
						request, response);
			} catch (UsuarioException e) {
				// TODO Auto-generated catch block
				request.setAttribute("cadastrado", false);
			}
		} else {
			response.sendRedirect("loginServlet");
		}

	}

}
