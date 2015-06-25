package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.Paciente;
import control.PacienteControl;

/**
 * Servlet implementation class EditarPacienteServlet
 */
@WebServlet("/editarPacienteServlet")
public class EditarPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		
		PacienteControl pacienteControl = new PacienteControl();
		
		Paciente paciente = pacienteControl.buscarPaciente(id);
		
		if(paciente != null){
			request.setAttribute("paciente", paciente);
			request.getRequestDispatcher("editarPaciente.jsp").forward(request, response);
		} else {
			request.setAttribute("erro", "Paciente n�o encontrado");
			request.getRequestDispatcher("listarPaciente.jsp").forward(request, response);
		}
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
		String id = request.getParameter("id");
		
		 PacienteControl pacienteControl = new PacienteControl();
		 
		 pacienteControl.editar(nome, telefone, numeroCarteirinha, cpf, idConvenio, id);
		 request.setAttribute("msg", "Editado com sucesso!");
		 
		 request.setAttribute("listaPaciente", pacienteControl.listarPaciente());
		 
		 request.getRequestDispatcher("listarPaciente.jsp").forward(request, response);
	}

}
