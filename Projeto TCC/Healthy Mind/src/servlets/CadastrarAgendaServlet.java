package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.AgendaControl;
import control.PsicologoControl;
import model.vo.Psicologo;
import model.vo.Usuario;

/**
 * Servlet implementation class CadastrarAgendaServlet
 */
@WebServlet("/cadastrarAgendaServlet")
public class CadastrarAgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarAgendaServlet() {
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
			
			String id = String.valueOf(usuario.getId());
			PsicologoControl psicologoControl = new PsicologoControl();
			Psicologo psicologo = psicologoControl.buscarPsicologoUsuario(id);
			
			String idPsicologo = String.valueOf(psicologo.getId());
			String dataAtendimento = request.getParameter("dataAtendimento");
			String idTurno1 = request.getParameter("idTurno1");
			String idTurno2 = request.getParameter("idTurno2");
			String idTurno3 = request.getParameter("idTurno3");
			
			AgendaControl agendaControl = new AgendaControl();
				
			boolean ok = agendaControl.cadastrarAgenda(idPsicologo, dataAtendimento, idTurno1, idTurno2, idTurno3);
				
			if(ok){
				request.setAttribute("cadastrado", true);
					
				request.getRequestDispatcher("WEB-INF/psicologo/cadastrarAgenda.jsp").forward(request, response);
				
			}else{
				request.setAttribute("cadastrado", false);
					
				request.getRequestDispatcher("WEB-INF/psicologo/cadastrarAgenda.jsp").forward(request, response);
			}
				
		} else {
			response.sendRedirect("loginServlet");
		}
	}
}
