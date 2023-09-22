package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.*;
import models.*;

public class PetSmileDAO {
	
	String sql = "";
	String val = "";
	ResultSet rs = null;
	boolean result = false;
	
	public String validar(String usr, String pass) throws Exception {
		Conexion cn = new Conexion();
		sql = "SELECT id FROM usuario WHERE nombreUsuario='"+usr+"' AND password='"+pass+"'";
		rs = cn.ejecutarConsulta(sql);
		while(rs.next()) {
			val=rs.getString("id");
		}
		cn.desconectar();
		return val;
	}
	
	
	public boolean registrarUsuario(Usuario user) throws Exception {
		Conexion cn = new Conexion();
		sql = "INSERT INTO `usuario` VALUES ('"+user.getId()+"','"+user.getNombreUsuario()+"','"+user.getPassword()+"')";
		result = cn.ejecutarGuardar(sql);
		
		
		return result;
	}
	
	public boolean guardarHora(Dueño duenio, Agenda agenda, Mascota masc) throws Exception {
		
		int idMascota = 0;
		Conexion cn = new Conexion();
		try {
			
			/* Insertar Dueño */
			sql = "INSERT INTO `dueño` VALUES ('"+
					duenio.getRut()+
					"','"+duenio.getNombre()+
					"','"+duenio.getApellido()+
					"','"+duenio.getDireccion()+
					"','"+duenio.getCorreo()+
					"',"+duenio.getTelefono()+
					",'"+duenio.getNombreMascota()+
					"')";
			result = cn.ejecutarGuardar(sql);
			
			
			/* Insertar Mascota */
			sql = "INSERT INTO `mascota` VALUES ('0','"+duenio.getRut()+"','"+masc.getTipoMascota()+"','"+masc.getEdad()+"','"+masc.getNombreMascota()+"')";
			result = cn.ejecutarGuardar(sql);
			
			
			
			/* Insertar Agenda */
			
			sql = "SELECT idMascota FROM `mascota` WHERE rutDueño='"+duenio.getRut()+"'";
			rs = cn.ejecutarConsulta(sql);
			while(rs.next()) {
				idMascota = rs.getInt("idMascota");
			}
			
			/* Primero traer id de mascota para guardar hora */
			sql = "INSERT INTO `agenda` VALUES ('0','"+idMascota+"','"+duenio.getRut()+"','"+duenio.getNombreMascota()+"','"+agenda.getHora()+"','"+agenda.getFecha()+"')";
			result = cn.ejecutarGuardar(sql);
			
			
			
			cn.desconectar();					
					
			return result;
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		return result;
		
	}

}
