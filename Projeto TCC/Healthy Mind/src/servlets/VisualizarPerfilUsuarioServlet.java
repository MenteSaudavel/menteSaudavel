package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.UsuarioControl;
import model.vo.Usuario;

/**
 * Servlet implementation class VisualizarPerfilUsuarioServlet
 */
@WebServlet("/visualizarPerfilUsuarioServlet")
public class VisualizarPerfilUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizarPerfilUsuarioServlet() {
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
			
			if(usuario.getTipoPerfil().equals("administrador")){
			
				String email = request.getParameter("email");
				
				UsuarioControl usuarioControl = new UsuarioControl();
				
				List<Usuario> lista = usuarioControl.pesquisarUsuario(email);
				
				request.setAttribute("listaUsuario", lista);
				
				request.getRequestDispatcher("WEB-INF/administrador/listarUsuario.jsp").forward(request, response);
				
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
