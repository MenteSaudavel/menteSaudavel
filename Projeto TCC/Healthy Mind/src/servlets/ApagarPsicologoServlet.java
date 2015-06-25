package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.Psicologo;
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
		
		String id = request.getParameter("id");
		
		PsicologoControl psicologoControl = new PsicologoControl();
		
		boolean ok = psicologoControl.apagarPsicologo(id);
		
		if(ok){
			request.setAttribute("msg", "Psicologo apagado com sucesso!");
		} else{
			request.setAttribute("msg", "Ocorreu um erro ao apagar, por favor tente novamente.");
		}
		
		List<Psicologo> lista = psicologoControl.listarPsicologo();
		
		request.setAttribute("listaPsicologo", lista);
		
		request.getRequestDispatcher("listarPsicologo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
