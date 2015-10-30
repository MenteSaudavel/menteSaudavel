package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.AgendaControl;
import control.PsicologoControl;
import model.vo.Agenda;
import model.vo.Psicologo;
import model.vo.Turno;
import model.vo.Usuario;

/**
 * Servlet implementation class ListarTurnosServlet
 */
@WebServlet("/listarTurnosServlet")
public class ListarTurnosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTurnosServlet() {
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
		
				String id = String.valueOf(usuario.getId());
				PsicologoControl psicologoControl = new PsicologoControl();
				Psicologo psicologo = psicologoControl.buscarPsicologoUsuario(id);
				
				String idPsicologo = String.valueOf(psicologo.getId());
				String dataAtendimento = request.getParameter("dataAtendimento");

				AgendaControl agendaControl = new AgendaControl();
				
				List<Turno> listaTurno = agendaControl.listarTurno(idPsicologo, dataAtendimento);
				request.setAttribute("listaTurno", listaTurno);
				
				Agenda agenda = agendaControl.buscarIdAgenda(dataAtendimento);
				request.setAttribute("idAgenda", String.valueOf(agenda.getId()));
				
				request.getRequestDispatcher("WEB-INF/psicologo/cadastrarHorario.jsp").forward(request, response);
				
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
			
				
		} else {
			response.sendRedirect("loginServlet");
		}
	}

}
