package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.Convenio;
import model.vo.Usuario;
import control.ConvenioControl;

/**
 * Servlet implementation class ApagarConvenioServlet
 */
@WebServlet("/apagarConvenioServlet")
public class ApagarConvenioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApagarConvenioServlet() {
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
				
				ConvenioControl convenioControl = new ConvenioControl();
				
				boolean ok = convenioControl.apagarConvenio(id);
				
				if(ok){
					request.setAttribute("apagado", ok);
				} else {
					request.setAttribute("apagado", false);
				}
				
				List<Convenio> lista = convenioControl.listarConvenios();
				
				request.setAttribute("listaConvenio", lista);
				
				request.getRequestDispatcher("WEB-INF/administrador/listarConvenio.jsp").forward(request, response);
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
