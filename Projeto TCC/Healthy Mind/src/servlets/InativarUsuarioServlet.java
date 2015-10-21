package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.AdministradorControl;
import control.ConvenioControl;
import control.PacienteControl;
import control.PsicologoControl;
import control.UsuarioControl;
import model.vo.Administrador;
import model.vo.Convenio;
import model.vo.Paciente;
import model.vo.Psicologo;
import model.vo.Usuario;

/**
 * Servlet implementation class InativarServlet
 */
@WebServlet("/inativarUsuarioServlet")
public class InativarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InativarUsuarioServlet() {
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
			
			if(usuario.getTipoPerfil().equals("administrador")){
			
				String id = request.getParameter("id");
				
				UsuarioControl usuarioControl = new UsuarioControl();
				
				boolean ok = usuarioControl.inativarUsuario(id);
				
				if(ok){
					
					Usuario u = usuarioControl.buscarUsuario(id);

					if (u.getTipoPerfil().equals("administrador")) {

						request.setAttribute("inativado", true);

						AdministradorControl administradorControl = new AdministradorControl();

						List<Administrador> lista = administradorControl
								.listarAdministrador();

						request.setAttribute("listaAdministrador", lista);

						request.getRequestDispatcher(
								"WEB-INF/administrador/listarAdministrador.jsp")
								.forward(request, response);
					} else if (u.getTipoPerfil().equals("paciente")) {

						request.setAttribute("inativado", true);

						PacienteControl pacienteControl = new PacienteControl();

						List<Paciente> lista = pacienteControl.listarPaciente();

						request.setAttribute("listaPaciente", lista);

						ConvenioControl convenioControl = new ConvenioControl();

						List<Convenio> listac = convenioControl
								.listarConvenios();

						request.setAttribute("listac", listac);

						request.getRequestDispatcher(
								"WEB-INF/administrador/listarPaciente.jsp")
								.forward(request, response);
					} else if (u.getTipoPerfil().equals("psicologo")) {

						request.setAttribute("inativado", true);

						PsicologoControl psicologoControl = new PsicologoControl();

						List<Psicologo> lista = psicologoControl
								.listarPsicologo();

						request.setAttribute("listaPsicologo", lista);

						request.getRequestDispatcher(
								"WEB-INF/administrador/listarPsicologo.jsp")
								.forward(request, response);
					}
					
				} else{
					request.setAttribute("inativado", false);
				}
			
			} else {
				response.sendRedirect("loginServlet");
			}
				
		} else {
			response.sendRedirect("loginServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
