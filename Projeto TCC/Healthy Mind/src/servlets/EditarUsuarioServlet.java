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
import control.PacienteControl;
import control.PsicologoControl;
import control.UsuarioControl;
import control.UsuarioException;
import model.vo.Administrador;
import model.vo.Paciente;
import model.vo.Psicologo;
import model.vo.Usuario;

/**
 * Servlet implementation class Edo
 */
@WebServlet("/editarUsuarioServlet")
public class EditarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarUsuarioServlet() {
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

		if (usuario != null) {
			request.setAttribute("usuario", usuario);
			
			String id = String.valueOf(usuario.getId());
			
			UsuarioControl usuarioControl = new UsuarioControl();
			
			Usuario user = usuarioControl.buscarUsuario(id);
			
			if(user != null){
				
				if(usuario.getTipoPerfil().equals("administrador")){
					request.setAttribute("user", user);
					
					AdministradorControl administradorControl = new AdministradorControl();
					
					String email = usuario.getEmail();
					
					request.setAttribute("listaAdministrador", administradorControl.pesquisarAdministrador(email));
					
					List<Administrador> lista = administradorControl.pesquisarAdministrador(email);
					
					request.setAttribute("listaAdministradorUsuario", lista);
					
					request.getRequestDispatcher(
							"WEB-INF/administrador/editarUsuario.jsp").forward(
							request, response);
					
				}
				
				if(usuario.getTipoPerfil().equals("paciente")){
					request.setAttribute("user", user);
					
					PacienteControl pacienteControl = new PacienteControl();
					
					String email = usuario.getEmail();
					
					request.setAttribute("listaPaciente", pacienteControl.pesquisarPacienteEmail(email));
					
					List<Paciente> lista = pacienteControl.pesquisarPacienteEmail(email);
		
					request.setAttribute("listaPacienteUsuario", lista);
					
					request.getRequestDispatcher(
							"WEB-INF/paciente/editarUsuario.jsp").forward(
							request, response);
				}
				
				if(usuario.getTipoPerfil().equals("psicologo")){
					request.setAttribute("user", user);
					
					PsicologoControl psicologoControl = new PsicologoControl();
					
					String email = usuario.getEmail();
					
					request.setAttribute("listaPsicologo", psicologoControl.pesquisarPsicologoEmail(usuario.getEmail()));
					
					List<Psicologo> lista = psicologoControl.pesquisarPsicologoEmail(email);
		
					request.setAttribute("listaPsicologoUsuario", lista);
					
					request.getRequestDispatcher(
							"WEB-INF/psicologo/editarUsuario.jsp").forward(
							request, response);
				}

			} else{
				request.getRequestDispatcher(
						"WEB-INF/administrador/login.jsp").forward(
						request, response);
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
		
		HttpSession session = request.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null) {
			request.setAttribute("usuario", usuario);
			
			String id = request.getParameter("id");
			String idUsuario = String.valueOf(usuario.getId());
			String email = request.getParameter("email");
			String senhaNova = request.getParameter("senhaNova");
			String confirmarSenha = request.getParameter("confirmarSenha");
			String tipoPerfil = usuario.getTipoPerfil();
			
			UsuarioControl usuarioControl = new UsuarioControl();
			
			
			try {
				
				if(usuario.getTipoPerfil().equals("administrador")){
					
					usuarioControl.editarUsuario(email, senhaNova, confirmarSenha, tipoPerfil, id, idUsuario);
					
					request.setAttribute("editado", true);
					request.getRequestDispatcher(
							"WEB-INF/administrador/editarUsuario.jsp").forward(
							request, response);
				} else{
					request.setAttribute("editado", false);
				}
				
				if(usuario.getTipoPerfil().equals("paciente")){
					
					usuarioControl.editarUsuario(email, senhaNova, confirmarSenha, tipoPerfil, id, idUsuario);
					
					request.setAttribute("editado", true);
					request.getRequestDispatcher(
							"WEB-INF/paciente/editarUsuario.jsp").forward(
							request, response);
				} else{
					request.setAttribute("editado", false);
				}
				
				if(usuario.getTipoPerfil().equals("psicologo")){
					
					usuarioControl.editarUsuario(email, senhaNova, confirmarSenha, tipoPerfil, id, idUsuario);
					
					request.setAttribute("editado", true);
					request.getRequestDispatcher(
							"WEB-INF/psicologo/editarUsuario.jsp").forward(
							request, response);
				} else{
					request.setAttribute("editado", false);
				}

			} catch (UsuarioException e) {
				// TODO Auto-generated catch block
				request.setAttribute("erroEditar", e.getMessage());
			}
			
		}
	}

}
