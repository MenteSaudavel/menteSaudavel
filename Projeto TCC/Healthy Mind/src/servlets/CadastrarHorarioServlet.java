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
import control.HorarioControl;
import control.PsicologoControl;
import model.vo.Agenda;
import model.vo.Psicologo;
import model.vo.Usuario;

/**
 * Servlet implementation class CadastrarHorarioServlet
 */
@WebServlet("/cadastrarHorarioServlet")
public class CadastrarHorarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarHorarioServlet() {
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
				
				request.getRequestDispatcher("WEB-INF/psicologo/cadastrarAgenda.jsp").forward(request, response);
				
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
			
			String idAgenda = request.getParameter("idAgenda");
			String idTurno = request.getParameter("idTurno");
			
			HorarioControl horarioControl = new HorarioControl();
			
			boolean ok = horarioControl.cadastrarHorario(idAgenda, idTurno);
			
			if(ok){
				request.setAttribute("horarioCadastrado", true);
				
				String id = String.valueOf(usuario.getId());
				PsicologoControl psicologoControl = new PsicologoControl();
				Psicologo psicologo = psicologoControl.buscarPsicologoUsuario(id);
				
				String idPsicologo = String.valueOf(psicologo.getId());
				
				AgendaControl agendaControl = new AgendaControl();
				List<Agenda> lista = agendaControl.listarDatas(idPsicologo);
				
				request.setAttribute("listaData", lista);
				
				request.getRequestDispatcher("WEB-INF/psicologo/listarDatas.jsp").forward(request, response);
				
			} else {
				request.setAttribute("horarioCadastrado", false);
				
				String id = String.valueOf(usuario.getId());
				PsicologoControl psicologoControl = new PsicologoControl();
				Psicologo psicologo = psicologoControl.buscarPsicologoUsuario(id);
				
				String idPsicologo = String.valueOf(psicologo.getId());
				
				AgendaControl agendaControl = new AgendaControl();
				List<Agenda> lista = agendaControl.listarDatas(idPsicologo);
				
				request.setAttribute("listaData", lista);
				
				request.getRequestDispatcher("WEB-INF/psicologo/listarDatas.jsp").forward(request, response);
			}
				
		} else {
			response.sendRedirect("loginServlet");
		}
	}

}
