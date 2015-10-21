package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.AdministradorControl;
import control.PacienteControl;
import control.PsicologoControl;
import model.vo.Usuario;

/**
 * Servlet implementation class VincularUsuarioServlet
 */
@WebServlet("/vincularUsuarioServlet")
public class VincularUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VincularUsuarioServlet() {
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
			
				request.getRequestDispatcher("WEB-INF/administrador/editarUsuario.jsp").forward(request, response);
				
			} else {
				response.sendRedirect("loginServlet");
			}
			
			if(usuario.getTipoPerfil().equals("paciente")){
				
				request.getRequestDispatcher("WEB-INF/paciente/editarUsuario.jsp").forward(request, response);
				
			} else {
				response.sendRedirect("loginServlet");
			}
			
			if(usuario.getTipoPerfil().equals("psicologo")){
				
				request.getRequestDispatcher("WEB-INF/psicologo/editarUsuario.jsp").forward(request, response);
				
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
		
		if(usuario != null){
			request.setAttribute("usuario", usuario);
			
			String idUsuario = String.valueOf(usuario.getId());
			String email = usuario.getEmail();

			if(usuario.getTipoPerfil().equals("administrador")){
				
				AdministradorControl administradorControl = new AdministradorControl();
				
				boolean ok = administradorControl.vincularUsuario(idUsuario, email);
				
				if(ok){
					request.setAttribute("vinculado", true);
					
					request.getRequestDispatcher("WEB-INF/administrador/editarUsuario.jsp").forward(request, response);

				}else{
					request.setAttribute("vinculado", false);
					
					request.getRequestDispatcher("WEB-INF/administrador/editarUsuario.jsp").forward(request, response);
				}
								
			} else if(usuario.getTipoPerfil().equals("paciente")){
				
				PacienteControl pacienteControl = new PacienteControl();
				
				boolean ok = pacienteControl.vincularUsuario(idUsuario, email);
				
				if(ok){
					request.setAttribute("vinculado", true);
					
					request.getRequestDispatcher("WEB-INF/paciente/editarUsuario.jsp").forward(request, response);

				}else{
					request.setAttribute("vinculado", false);
					
					request.getRequestDispatcher("WEB-INF/paciente/editarUsuario.jsp").forward(request, response);
				}
				
				
			} else if(usuario.getTipoPerfil().equals("psicologo")){
				
				PsicologoControl psicologoControl = new PsicologoControl();
				
				boolean ok = psicologoControl.vincularUsuario(idUsuario, email);
				
				if(ok){
					
					request.setAttribute("vinculado", true);
					
					request.getRequestDispatcher("WEB-INF/psicologo/editarUsuario.jsp").forward(request, response);

				}else{
					request.setAttribute("vinculado", false);
					
					request.getRequestDispatcher("WEB-INF/psicologo/editarUsuario.jsp").forward(request, response);
				}
								
			} else {
				response.sendRedirect("loginServlet");
			}
			
		} else {
			response.sendRedirect("loginServlet");
		}
	}

}
