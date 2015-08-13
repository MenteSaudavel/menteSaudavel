package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.Usuario;
import control.AdministradorControl;
import control.UsuarioException;

/**
 * Servlet implementation class CadastrarAdministradorServlet
 */
@WebServlet("/cadastrarAdministradorServlet")
public class CadastrarAdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarAdministradorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario != null){
			request.setAttribute("usuario", usuario);
		
			*/request.getRequestDispatcher("WEB-INF/administrador/cadastrarAdministrador.jsp").forward(request, response);
		/*} else {
			response.sendRedirect("loginServlet");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario != null){  */
		
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			String funcao = request.getParameter("funcao");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String confirmarSenha = request.getParameter("confirmarSenha");
			
			AdministradorControl administradorControl = new AdministradorControl();
			
			try {
				boolean ok = administradorControl.cadastrarAdministrador(nome, telefone, funcao, email, senha, confirmarSenha);
				
					request.setAttribute("cadastrado", true);
					request.getRequestDispatcher("WEB-INF/administrador/cadastrarAdministrador.jsp").forward(request, response);
		
			} catch (UsuarioException e) {
				// TODO Auto-generated catch block
				request.setAttribute("cadastrado", false);
				request.getRequestDispatcher("WEB-INF/administrador/cadastrarAdministrador.jsp").forward(request, response);
				
			}
		/*} else {
			response.sendRedirect("loginServlet");
		}    */

	}

}
