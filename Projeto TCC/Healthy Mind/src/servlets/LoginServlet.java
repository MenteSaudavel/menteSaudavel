package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.Usuario;
import control.UsuarioControl;
import control.UsuarioException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		UsuarioControl usuarioControl = new UsuarioControl();
		
		Usuario usuario;
		
		try {
			usuario = usuarioControl.logar(email, senha);
			
			if(usuario != null){
				
				
				if(usuario.getTipoPerfil().equals("administrador")){
					
					request.getSession().invalidate();
					
					HttpSession session = request.getSession();
					
					session.setAttribute("usuario", usuario);
					
					response.sendRedirect("menuAdministradorServlet");
				} 
				
				if(usuario.getTipoPerfil().equals("paciente")){
					
					request.getSession().invalidate();
					
					HttpSession session = request.getSession();
					
					session.setAttribute("usuario", usuario);
					
					response.sendRedirect("menuPacienteServlet");
				}
				
				if(usuario.getTipoPerfil().equals("psicologo")){
					
					request.getSession().invalidate();
					
					HttpSession session = request.getSession();
					
					session.setAttribute("usuario", usuario);
					
					response.sendRedirect("menuPsicologoServlet");
				}
				
				
			}else {
				request.setAttribute("logado", false);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (UsuarioException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
