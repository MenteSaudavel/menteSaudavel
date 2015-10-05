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
import control.UsuarioControl;
import model.vo.Administrador;
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
					request.setAttribute("inativado", true);
					
					AdministradorControl administradorControl = new AdministradorControl();
					
					List<Administrador> lista = administradorControl.listarAdministrador();
					
					request.setAttribute("listaAdministrador", lista);
					
					request.getRequestDispatcher("WEB-INF/administrador/listarUsuario.jsp").forward(request, response);
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
