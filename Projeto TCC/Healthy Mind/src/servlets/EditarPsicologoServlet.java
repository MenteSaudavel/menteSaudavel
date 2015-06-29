package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.Convenio;
import model.vo.Psicologo;
import control.ConvenioControl;
import control.PsicologoControl;

/**
 * Servlet implementation class EditarPsicologoServlet
 */
@WebServlet("/editarPsicologoServlet")
public class EditarPsicologoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPsicologoServlet() {
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
		
		Psicologo psicologo = psicologoControl.buscarPsicologo(id);
		
		ConvenioControl convenioControl = new ConvenioControl();
		
		List<Convenio> lista = convenioControl.listarConvenios();
		
		request.setAttribute("lista", lista);
		
		if(psicologo != null){
			request.setAttribute("psicologo", psicologo);
			request.getRequestDispatcher("editarPsicologo.jsp").forward(request, response);
		} else {
			request.setAttribute("erro", "Psicologo não encontrado");
			request.getRequestDispatcher("listarPsicologo.jsp").forward(request, response);
		}
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
		String id = request.getParameter("id");
		
		PsicologoControl psicologoControl = new PsicologoControl();
		
		boolean ok = psicologoControl.editarPsicologo(nome, telefoneConsultorio, idConvenio, crp, id);
		if(ok){
			request.setAttribute("editado", ok);
		} else{
			request.setAttribute("editado", "Erro ao editar, verifique os campos e tente novamente.");
		}
		
		request.setAttribute("listaPsicologo", psicologoControl.listarPsicologo());
		
		request.getRequestDispatcher("listarPsicologo.jsp").forward(request, response);
	}

}
