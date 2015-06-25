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
 * Servlet implementation class BuscarServlet
 */
@WebServlet("/pesquisarPsicologoServlet")
public class PesquisarPsicologoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarPsicologoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("pesquisarPsicologo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nomePesquisaPsicologo");
		
		PsicologoControl psicologoControl = new PsicologoControl();
		
		List<Psicologo> lista = psicologoControl.pesquisarPsicologo(nome);
		
		request.setAttribute("listaPsicologo", lista);
		
		request.getRequestDispatcher("listarPsicologo.jsp").forward(request, response);
	}

}
