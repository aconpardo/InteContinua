package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PetSmileDAO;
import models.Usuario;

/**
 * Servlet implementation class ServletRegistro
 */
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegistro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try (PrintWriter out = response.getWriter()) {

			PetSmileDAO log = new PetSmileDAO();
			int rspta = 0;
			boolean val = false;

			String usuario = request.getParameter("txtUsuario");
			String pass = request.getParameter("txtPass");
			Long id = new Long(0);
			
			/* Clase Usuario */
			Usuario user = new Usuario(id, usuario, pass);
			
			
;			
			
			System.out.println("Usuario: " + usuario + " Pass: " + pass);
			
			if (request.getParameter("btn-registrar") != null) {
				
				try {
					val = log.registrarUsuario(user);
					System.out.println(val);
				} catch (Exception ex) {
					System.out.println(ex);
					// Logger.getLogger(ServletAuth.class.getName()).log(Level.SEVERE, null, ex);
				}
				if (val) {
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					
					//Manejar el error del registro de usuarios
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
