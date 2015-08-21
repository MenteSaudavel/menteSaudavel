package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.UsuarioControl;
import control.UsuarioException;
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
					request.getRequestDispatcher(
							"WEB-INF/administrador/editarUsuario.jsp").forward(
							request, response);
				}
				
				if(usuario.getTipoPerfil().equals("paciente")){
					request.setAttribute("user", user);
					request.getRequestDispatcher(
							"WEB-INF/paciente/editarUsuario.jsp").forward(
							request, response);
				}
				
				if(usuario.getTipoPerfil().equals("psicologo")){
					request.setAttribute("user", user);
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
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String confirmarSenha = request.getParameter("confirmarSenha");
			
			UsuarioControl usuarioControl = new UsuarioControl();
			
			
			try {
				usuarioControl.editarUsuario(email, senha, confirmarSenha);
				
				if(usuario.getTipoPerfil().equals("administrador")){
					
					request.setAttribute("editado", true);
					request.getRequestDispatcher(
							"WEB-INF/administrador/editarUsuario.jsp").forward(
							request, response);
				}
				
				if(usuario.getTipoPerfil().equals("paciente")){
					
					request.setAttribute("editado", true);
					request.getRequestDispatcher(
							"WEB-INF/paciente/editarUsuario.jsp").forward(
							request, response);
				}
				
				if(usuario.getTipoPerfil().equals("psicologo")){
					
					request.setAttribute("editado", true);
					request.getRequestDispatcher(
							"WEB-INF/psicologo/editarUsuario.jsp").forward(
							request, response);
				}

			} catch (UsuarioException e) {
				// TODO Auto-generated catch block
				request.setAttribute("erroEditar", e.getMessage());
			}
			
		}
	}

}
