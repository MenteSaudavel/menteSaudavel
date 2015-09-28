package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.Paciente;
import model.vo.Psicologo;
import model.vo.Usuario;
import control.ConsultaControl;
import control.PacienteControl;
import control.PsicologoControl;
import control.UsuarioControl;

/**
 * Servlet implementation class AgendarConsultaServlet
 */
@WebServlet("/agendarConsultaServlet")
public class AgendarConsultaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendarConsultaServlet() {
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
			
			String email = usuario.getEmail();
			
			PacienteControl pacienteControl = new PacienteControl();
			
			List<Paciente> listaIdConvenio = pacienteControl.pesquisarConvenioPaciente(email);
			
			request.setAttribute("listaIdConvenio", listaIdConvenio);
			
			String idConvenio = request.getParameter("idConvenio");
			
			PsicologoControl psicologoControl = new PsicologoControl();
			
			List<Psicologo> listaPsicologo = psicologoControl.listarPsicologoSelect(idConvenio);
			
			request.setAttribute("listaPsicologo", listaPsicologo);
			
			/*PsicologoControl psicologoControl = new PsicologoControl();
			
			List<Psicologo> listaPsicologo = psicologoControl.listarPsicologo();
			
			request.setAttribute("listaPsicologo", listaPsicologo);*/
			
			request.getRequestDispatcher("WEB-INF/paciente/agendarConsulta.jsp").forward(request, response);
		} else {
			response.sendRedirect("loginServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario != null){
		
			String data = request.getParameter("dataConsulta");
			String hora = request.getParameter("horaConsulta");
			String idPsicologo = request.getParameter("idPsicologo");
			
			//arrrumar futuramente
			String idPaciente = "1";
			
			ConsultaControl consultaControl = new ConsultaControl();
			
			boolean ok = consultaControl.agendarConsulta(idPaciente, idPsicologo, data, hora);
			
			request.setAttribute("agendado", true);
			
			PsicologoControl psicologoControl = new PsicologoControl();
			
			List<Psicologo> listaPsciologo = psicologoControl.listarPsicologo();
			
			request.setAttribute("listaPsicologo", listaPsciologo);
			
			request.getRequestDispatcher("WEB-INF/paciente/agendarConsulta.jsp").forward(request, response);
		} else {
			response.sendRedirect("loginServlet");
		}

	}

}
