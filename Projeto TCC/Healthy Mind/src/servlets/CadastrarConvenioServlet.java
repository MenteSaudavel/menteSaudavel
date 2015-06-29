package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ConvenioControl;

/**
 * Servlet implementation class ConvenioServlet
 */
@WebServlet("/cadastrarConvenioServlet")
public class CadastrarConvenioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarConvenioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("cadastrarConvenio.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nome");
		
		ConvenioControl convenioControl = new ConvenioControl();
		
		boolean ok = convenioControl.cadastrarConvenio(nome);
		
		if(ok){
			request.setAttribute("cadastrado", ok);
		} else{
			request.setAttribute("cadastrado", null);
		}
		
		request.getRequestDispatcher("cadastrarConvenio.jsp").forward(request, response);
	}

}
