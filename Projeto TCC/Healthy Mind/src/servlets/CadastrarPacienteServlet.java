package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.Convenio;
import control.ConvenioControl;
import control.PacienteControl;

/**
 * Servlet implementation class CadastrarPacienteServlet
 */
@WebServlet("/cadastrarPacienteServlet")
public class CadastrarPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarPacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ConvenioControl convenioControl = new ConvenioControl();
		
		List<Convenio> lista = convenioControl.listarConvenios();
		
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("cadastrarPaciente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String numeroCarteirinha = request.getParameter("numeroCarteirinha");
		String cpf = request.getParameter("cpf");
		String idConvenio = request.getParameter("idConvenio");
		
		PacienteControl pacienteControl = new PacienteControl();
		
		boolean ok = pacienteControl.cadastrar(nome, telefone, numeroCarteirinha, cpf, idConvenio);
		
		request.setAttribute("cadastrado", ok);
		
		ConvenioControl convenioControl = new ConvenioControl();
		
		List<Convenio> lista = convenioControl.listarConvenios();
		
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("cadastrarPaciente.jsp").forward(request, response);
	}

}
