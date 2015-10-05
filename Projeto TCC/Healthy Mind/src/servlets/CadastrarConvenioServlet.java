package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.UF;
import model.vo.Usuario;
import control.ConvenioControl;
import control.UFControl;

/**
 * Servlet implementation class ConvenioServlet
 */
@WebServlet("/cadastrarConvenioServlet")
public class CadastrarConvenioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarConvenioServlet() {
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
			
				UFControl ufControl = new UFControl();
				
				List<UF> lista = ufControl.listarUF();
				
				request.setAttribute("listaUf", lista);
				
				request.getRequestDispatcher(
						"WEB-INF/administrador/cadastrarConvenio.jsp").forward(
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
			String presidente = request.getParameter("presidente");
			String cnpj = request.getParameter("cnpj");
			String telefone = request.getParameter("telefone");
			String endereco = request.getParameter("endereco");
			String cep = request.getParameter("cep");
			String cidade = request.getParameter("cidade");
			String uf = request.getParameter("idUf");

			ConvenioControl convenioControl = new ConvenioControl();

			boolean ok = convenioControl.cadastrarConvenio(nome, presidente,
					cnpj, telefone, endereco, cep, cidade, uf);

			if (ok) {
				request.setAttribute("cadastrado", true);
				
				UFControl ufControl = new UFControl();
				
				List<UF> lista = ufControl.listarUF();
				
				request.setAttribute("listaUf", lista);
				
				request.getRequestDispatcher(
						"WEB-INF/administrador/cadastrarConvenio.jsp").forward(
						request, response);

			} else {
				request.setAttribute("cadastrado", false);
				request.getRequestDispatcher(
						"WEB-INF/administrador/cadastrarConvenio.jsp").forward(
						request, response);
			}
		} else {
			response.sendRedirect("loginServlet");
		}
	}

}
