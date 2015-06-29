package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.Convenio;
import control.ConvenioControl;

/**
 * Servlet implementation class EditarConvenioServlet
 */
@WebServlet("/editarConvenioServlet")
public class EditarConvenioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarConvenioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		
		ConvenioControl convenioControl = new ConvenioControl();
		
		Convenio convenio = convenioControl.buscarConvenio(id);
		
		if(convenio != null){
			request.setAttribute("convenio", convenio);
			request.getRequestDispatcher("editarConvenio.jsp").forward(request, response);
		} else {
			request.setAttribute("erro", "Convênio não encontrado!");
			request.getRequestDispatcher("listarConvenio.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nome");
		String id = request.getParameter("id");
		
		ConvenioControl convenioControl = new ConvenioControl();
		
		boolean ok = convenioControl.editar(nome, id);
		
		if(ok){
			request.setAttribute("editado", ok);
		} else{
			request.setAttribute("editado", false);
		}
		
		request.setAttribute("listaConvenio", convenioControl.listarConvenios());
		
		request.getRequestDispatcher("listarConvenio.jsp").forward(request, response);
	}

}
