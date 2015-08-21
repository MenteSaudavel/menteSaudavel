package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.Convenio;
import model.vo.Usuario;
import control.ConvenioControl;

/**
 * Servlet implementation class EditarConvenioServlet
 */
@WebServlet("/editarConvenioServlet")
public class EditarConvenioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarConvenioServlet() {
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

			String id = request.getParameter("id");

			ConvenioControl convenioControl = new ConvenioControl();

			Convenio convenio = convenioControl.buscarConvenio(id);

			if (convenio != null) {
				request.setAttribute("convenio", convenio);
				request.getRequestDispatcher(
						"WEB-INF/administrador/editarConvenio.jsp").forward(
						request, response);
			} else {
				request.setAttribute("erro", "Convênio não encontrado!");
				request.getRequestDispatcher(
						"WEB-INF/administrador/listarConvenio.jsp").forward(
						request, response);
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
			String presidente = request.getParameter("presidente");
			String cnpj = request.getParameter("cnpj");
			String telefoneConvenio = request.getParameter("telefone");
			String enderecoConvenio = request.getParameter("endereco");
			String cep = request.getParameter("cep");
			String cidadeConvenio = request.getParameter("cidade");
			String uf = request.getParameter("uf");
			String id = request.getParameter("id");

			ConvenioControl convenioControl = new ConvenioControl();

			boolean ok = convenioControl.editar(nome, presidente, cnpj,
					telefoneConvenio, enderecoConvenio, cep, cidadeConvenio,
					uf, id);
			
			request.setAttribute("listaConvenio",
					convenioControl.listarConvenios());
			
			if (ok) {
				request.setAttribute("editado", true);
				request.getRequestDispatcher(
						"WEB-INF/administrador/listarConvenio.jsp").forward(
						request, response);
				request.setAttribute("listaConvenio",
						convenioControl.listarConvenios());
			} else {
				request.setAttribute("editado", false);
				request.getRequestDispatcher(
						"WEB-INF/administrador/listarConvenio.jsp").forward(
						request, response);
			}

		} else {
			response.sendRedirect("loginServlet");
		}
	}

}
