package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PetSmileDAO;
import models.*;


/**
 * Servlet implementation class ServletCRUD
 */
public class ServletCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCRUD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try(PrintWriter out = response.getWriter()){
    		//Usuario user = new Usuario();
    		PetSmileDAO log = new PetSmileDAO();
    		int rspta = 0;
    		boolean val = false;
    		
    		
    		/* Clase Dueño */
    		
    		String nombre = request.getParameter("txtNombre");
    		String apellido = request.getParameter("txtApellido");
    		Long telefono = Long.parseLong(request.getParameter("txtTelefono"));
    		String correo = request.getParameter("txtCorreo");
    		String direccion = request.getParameter("txtDireccion");
    		Long rut = Long.parseLong(request.getParameter("txtRut"));
    		String nombreMascota = request.getParameter("txtNombreM");
    		
    		/* Clase Mascota */
    		
    		Long edadM = Long.parseLong(request.getParameter("intEdad"));
    		String tipo = request.getParameter("txtTipo");
    		
    		/* Consulta SQL ud para asignar */
    		Long id = new Long(1);
    		
    		
    		/* Clase Agenda */
    		
    		String fecha = request.getParameter("date");
    		Date fDate = Date.valueOf(fecha);
    		String hora = request.getParameter("hora");
    		
    		
    		
    		Dueño nuevoD = new Dueño(rut,nombre,apellido,direccion,correo,telefono,nombreMascota);
    		Mascota masc = new Mascota(id,rut,tipo,edadM,nombreMascota);
    		Agenda nuevaA = new Agenda(id, id, rut, hora, fDate);
    		
    		if(request.getParameter("btn-registrar") != null) {
    			
    			//System.out.println(masc);
    			//System.out.println(nuevoD);
    			//System.out.println(nuevaA);
    			try {
    				val = log.guardarHora(nuevoD, nuevaA, masc);
    				System.out.println(val);
    			} catch (Exception ex) {
    				System.out.println(ex);
    				//Logger.getLogger(ServletAuth.class.getName()).log(Level.SEVERE, null, ex);
    			}
    			if(val) {
    				request.getRequestDispatcher("success.jsp").forward(request, response);
    			}else{
    				request.getRequestDispatcher("error.jsp").forward(request, response);
    			}
    		}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
