package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.Paciente;
import control.PacienteControl;

/**
 * Servlet implementation class PesquisarPacienteServlet
 */
@WebServlet("/pesquisarPacienteServlet")
public class PesquisarPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarPacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("pesquisarPaciente.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nomePesquisaPaciente");
		
		PacienteControl pacienteControl = new PacienteControl();
		
		List<Paciente> lista = pacienteControl.pesquisarPaciente(nome);
		
		request.setAttribute("listaPaciente", lista);
		
		request.getRequestDispatcher("listarPaciente.jsp").forward(request, response);

	}

}
