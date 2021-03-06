package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.HorarioControl;
import model.vo.Horario;
import model.vo.Usuario;

/**
 * Servlet implementation class EditarHorarioServlet
 */
@WebServlet("/editarHorarioServlet")
public class EditarHorarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarHorarioServlet() {
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

		if (usuario != null) {
			request.setAttribute("usuario", usuario);
			
			if(usuario.getTipoPerfil().equals("psicologo")){
				
				String idAgenda = request.getParameter("idAgenda");
				
				HorarioControl horarioControl = new HorarioControl();
				
				List<Horario> lista = horarioControl.listarHorario(idAgenda);
				
				request.setAttribute("listaHorario", lista);
				
				request.getRequestDispatcher("WEB-INF/psicologo/listarTurnoEditarHorario.jsp").forward(request, response);
				
			} else {
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

		if (usuario != null) {
			request.setAttribute("usuario", usuario);
			
			String id = request.getParameter("id");
			String hora1 = request.getParameter("hora1");
			String hora2 = request.getParameter("hora2");
			String hora3 = request.getParameter("hora3");
			String hora4 = request.getParameter("hora4");
			
			HorarioControl horarioControl = new HorarioControl();
			
			boolean ok = horarioControl.editarHorario(hora1, hora2, hora3, hora4, id);
			
			if(ok){
				request.setAttribute("horaEditada", true);
				request.getRequestDispatcher("WEB-INF/psicologo/pesquisarData.jsp").forward(request, response);
			} else {
				request.setAttribute("horaEditada", false);
				request.getRequestDispatcher("WEB-INF/psicologo/pesquisarData.jsp").forward(request, response);
			}
			
		} else {
			response.sendRedirect("loginServlet");
		}
	}

}
