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
import control.PsicologoControl;
import control.UsuarioException;

/**
 * Servlet implementation class CadastrarPsicologoServlet
 */
@WebServlet("/cadastrarPsicologoServlet")
public class CadastrarPsicologoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarPsicologoServlet() {
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

			ConvenioControl convenioControl = new ConvenioControl();

			List<Convenio> lista = convenioControl.listarConvenios();

			request.setAttribute("lista", lista);

			request.getRequestDispatcher(
					"WEB-INF/administrador/cadastrarPsicologo.jsp").forward(
					request, response);
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
			String telefoneConsultorio = request
					.getParameter("telefoneConsultorio");
			String idConvenio = request.getParameter("idConvenio");
			String crp = request.getParameter("crp");
			String email = request.getParameter("email");
			String confCrp = request.getParameter("confCrp");

			PsicologoControl psicologoControl = new PsicologoControl();

			try {
				psicologoControl.cadastrarPsicologo(nome, telefoneConsultorio,
						idConvenio, crp, email, confCrp);

				request.setAttribute("cadastrado", true);

				ConvenioControl convenioControl = new ConvenioControl();

				List<Convenio> lista = convenioControl.listarConvenios();

				request.setAttribute("lista", lista);

				request.getRequestDispatcher(
						"WEB-INF/administrador/cadastrarPsicologo.jsp")
						.forward(request, response);

			} catch (UsuarioException e) {
				// TODO Auto-generated catch block
				request.setAttribute("cadastrado", false);
			}

		} else {
			response.sendRedirect("loginServlet");
		}
	}

}
