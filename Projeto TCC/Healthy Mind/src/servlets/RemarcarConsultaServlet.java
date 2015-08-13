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
import model.vo.Psicologo;
import model.vo.Usuario;
import control.ConsultaControl;
import control.PsicologoControl;

/**
 * Servlet implementation class RemarcarConsultaServlet
 */
@WebServlet("/remarcarConsultaServlet")
public class RemarcarConsultaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemarcarConsultaServlet() {
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

			String id = request.getParameter("idConsulta");

			ConsultaControl consultaControl = new ConsultaControl();

			Consulta consulta = consultaControl.buscarConsulta(id);

			PsicologoControl psicologoControl = new PsicologoControl();

			List<Psicologo> listaPsciologo = psicologoControl.listarPsicologo();

			request.setAttribute("listaPsicologo", listaPsciologo);

			if (consulta != null) {
				request.setAttribute("consulta", consulta);
				request.getRequestDispatcher(
						"WEB-INF/paciente/remarcarConsulta.jsp").forward(
						request, response);
			} else {
				request.setAttribute("erro", "Consulta não encontrada");
				request.getRequestDispatcher(
						"WEB-INF/paciente/visualizarConsulta.jsp").forward(
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

			String idPsicologo = request.getParameter("idPsicologo");
			String dataConsulta = request.getParameter("dataConsulta");
			String hora = request.getParameter("horaConsulta");
			String idConsulta = request.getParameter("idConsulta");

			ConsultaControl consultaControl = new ConsultaControl();

			boolean ok = consultaControl.remarcarConsulta(idPsicologo,
					dataConsulta, hora, idConsulta);

			if (ok) {
				request.setAttribute("remarcado", true);
				request.getRequestDispatcher(
						"WEB-INF/paciente/visualizarConsulta.jsp").forward(
						request, response);

			} else {
				request.setAttribute("remarcado", false);
				request.getRequestDispatcher(
						"WEB-INF/paciente/visualizarConsulta.jsp").forward(
						request, response);

			}

			request.setAttribute("listaConsulta",
					consultaControl.visualizarConsulta());

		} else {
			response.sendRedirect("loginServlet");
		}
	}

}
