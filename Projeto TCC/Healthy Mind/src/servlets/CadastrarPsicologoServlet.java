package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.PsicologoControl;

/**
 * Servlet implementation class CadastrarPsicologoServlet
 */
@WebServlet("/cadastrarPsicologoServlet")
public class CadastrarPsicologoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarPsicologoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("cadastrarPsicologo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nome");
		String telefoneConsultorio = request.getParameter("telefoneConsultorio");
		String idConvenio = request.getParameter("idConvenio");
		String crp = request.getParameter("crp");
		
		PsicologoControl psicologoControl = new PsicologoControl();
		
		boolean ok = psicologoControl.cadastrarPsicologo(nome, telefoneConsultorio, idConvenio, crp);
		
		request.setAttribute("cadastrado", ok);
		
		request.getRequestDispatcher("cadastrarPsicologo.jsp").forward(request, response);
	}

}
