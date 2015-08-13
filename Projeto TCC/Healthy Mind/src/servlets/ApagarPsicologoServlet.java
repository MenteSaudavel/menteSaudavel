package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.Psicologo;
import model.vo.Usuario;
import control.PsicologoControl;

/**
 * Servlet implementation class ApagarPsicologoServlet
 */
@WebServlet("/apagarPsicologoServlet")
public class ApagarPsicologoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApagarPsicologoServlet() {
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
		
		if(usuario != null){
			request.setAttribute("usuario", usuario);
		
			String id = request.getParameter("id");
			
			PsicologoControl psicologoControl = new PsicologoControl();
			
			boolean ok = psicologoControl.apagarPsicologo(id);
			
			if(ok){
				request.setAttribute("apagado", ok);
			} else{
				request.setAttribute("msg", "Ocorreu um erro ao apagar, por favor tente novamente.");
			}
			
			List<Psicologo> lista = psicologoControl.listarPsicologo();
			
			request.setAttribute("listaPsicologo", lista);
			
			request.getRequestDispatcher("WEB-INF/administrador/listarPsicologo.jsp").forward(request, response);
		} else {
			response.sendRedirect("loginServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
