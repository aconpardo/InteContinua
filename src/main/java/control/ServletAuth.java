package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Usuario;
import dao.PetSmileDAO;

/**
 * Servlet implementation class ServletAuth
 */
public class ServletAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAuth() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
    		PetSmileDAO log = new PetSmileDAO();
    		int rspta = 0;
    		String val = "";
    		if(request.getParameter("btn-login") != null) {
    			String usuario = request.getParameter("txtusuario");
    			String contraseña = request.getParameter("txtclave");
    			try {
    				val = log.validar(usuario, contraseña);
    				
    			} catch (Exception ex) {
    				System.out.println(ex);
    				//Logger.getLogger(ServletAuth.class.getName()).log(Level.SEVERE, null, ex);
    			}
    			if(val == ""  || val == null) {
    				response.sendRedirect("index.jsp?rspta=" + rspta);
    			}else{
    				
    				request.getRequestDispatcher("main.jsp").forward(request, response);
    				
    			}
    		}
    	} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
