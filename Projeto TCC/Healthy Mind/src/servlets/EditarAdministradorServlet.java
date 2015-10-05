package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.AdministradorControl;
import model.vo.Administrador;
import model.vo.Usuario;

/**
 * Servlet implementation class EditarAdministradorServlet
 */
@WebServlet("/editarAdministradorServlet")
public class EditarAdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarAdministradorServlet() {
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
			
				String id = request.getParameter("id");
				
				AdministradorControl administradorControl = new AdministradorControl();
				
				Administrador administrador = administradorControl.buscarAdministrador(id);
				
				if(administrador != null){
					request.setAttribute("administrador", administrador);
					request.getRequestDispatcher(
							"WEB-INF/administrador/editarAdministrador.jsp").forward(
							request, response);
				} else{
					request.getRequestDispatcher(
							"WEB-INF/administrador/listarAdministrador.jsp").forward(
							request, response);
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
		
		HttpSession session = request.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null) {
			
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			String funcao = request.getParameter("funcao");
			String id = request.getParameter("id");
			
			AdministradorControl administradorControl = new AdministradorControl();
			
			boolean ok = administradorControl.editarAdministrador(nome, telefone, funcao, id);
			
			request.setAttribute("listaAdministrador", administradorControl.listarAdministrador());
			
			if(ok){
				request.setAttribute("editado", true);
				request.getRequestDispatcher(
						"WEB-INF/administrador/listarAdministrador.jsp").forward(
						request, response);
			} else{
				request.setAttribute("editado", true);
				request.getRequestDispatcher(
						"WEB-INF/administrador/listarAdministrador.jsp").forward(
						request, response);
			}
		} else {
			response.sendRedirect("loginServlet");
		}
	}

}
