package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.Agenda;
import model.vo.Usuario;
import control.AgendaControl;

/**
 * Servlet implementation class PesquisarDataServlet
 */
@WebServlet("/pesquisarDataServlet")
public class PesquisarDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarDataServlet() {
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
				
				request.getRequestDispatcher("WEB-INF/psicologo/pesquisarData.jsp").forward(request, response);
				
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
			
			String pesquisarData = request.getParameter("pesquisarData");
			
			AgendaControl agendaControl = new AgendaControl();
			
			List<Agenda> lista = agendaControl.pesquisarData(pesquisarData);
			
			if(lista.isEmpty()){
				
				request.setAttribute("pesquisado", true);
				
				request.setAttribute("listaData", lista);
				
				request.getRequestDispatcher("WEB-INF/psicologo/pesquisarData.jsp").forward(request, response);
				
			} else{
				
				request.setAttribute("pesquisado", true);
				
				request.setAttribute("listaData", lista);
				
				request.getRequestDispatcher("WEB-INF/psicologo/pesquisarData.jsp").forward(request, response);
			}
				
		} else {
			response.sendRedirect("loginServlet");
		}
	}

}
