/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Personal;
import web.CRUD;
import web.Conexion;

/**
 *
 * @author alanh
 */
public class PersonalDao implements CRUD.CRUDPersonal{
    public static final String SQL_SELECT = "SELECT * FROM personal";
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM personal WHERE idpersonal=?";
    public static final String SQL_SELECT_BY_PERSONAL = "SELECT * FROM personal WHERE nombre=? AND apepaterno=? AND apematerno=? AND direccion=? AND fechadeingreso=?";
    public static final String SQL_INSERT = "INSERT INTO personal(nombre,apepaterno,apematerno,direccion,fechadeingreso) VALUES(?,?,?,?,?)";
    public static final String SQL_UPDATE = "UPDATE personal SET nombre=?, apepaterno=?, apematerno=?, direccion=?, fechadeingreso=? WHERE idpersonal=?";
    public static final String SQL_DELETE = "DELETE FROM personal WHERE idpersonal=?";

    @Override
    public List listarPersonal() {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        List<Personal> personas = new ArrayList<Personal>();
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT);
            rs = stms.executeQuery();
            
            while (rs.next()) {
                int idPersonal = rs.getInt("idpersonal");
                String nombre = rs.getString("nombre");
                String paterno = rs.getString("apepaterno");
                String materno = rs.getString("apematerno");
                String direccion = rs.getString("direccion");
                String fecha = rs.getString("fechadeingreso");
                
                if (materno == null){
                    materno = "";
                }
                
                System.out.println(nombre+" "+paterno+" "+materno);
                
                personas.add(new Personal(idPersonal, nombre, paterno, materno, direccion, fecha));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.Close(rs);
            Conexion.Close(stms);
            Conexion.Close(conn);
        }
        
        return personas;
    }

    @Override
    public Personal listarPersonalID(int id) {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        Personal persona = new Personal();
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT_BY_ID);
            stms.setInt(1, id);
            rs = stms.executeQuery();

                rs.next();
                int idPersonal = rs.getInt("idpersonal");
                String nombre = rs.getString("nombre");
                String paterno = rs.getString("apepaterno");
                String materno = rs.getString("apematerno");
                String direccion = rs.getString("direccion");
                String fecha = rs.getString("fechadeingreso");
                
                if (materno == null){
                    materno = "";
                }
                
            persona.setIdPersonal(idPersonal);
            persona.setNombre(nombre);
            persona.setApellidoPaterno(paterno);
            persona.setApellidoMaterno(materno);
            persona.setDireccion(direccion);
            persona.setFecha(fecha);
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.Close(rs);
            Conexion.Close(stms);
            Conexion.Close(conn);
        }
        
        return persona;
    }
    
    @Override
    public int retrieveIdPersonal(Personal persona) {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        int idPersonal = -1;
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT_BY_PERSONAL);
            stms.setString(1, persona.getNombre());
            stms.setString(2, persona.getApellidoPaterno());
            stms.setString(3, persona.getApellidoMaterno());
            stms.setString(4, persona.getDireccion());
            stms.setString(5, persona.getFecha());
            rs = stms.executeQuery();

                rs.next();
                idPersonal = rs.getInt("idpersonal");
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.Close(rs);
            Conexion.Close(stms);
            Conexion.Close(conn);
        }
        
        return idPersonal;
    }

    @Override
    public boolean addPersonal(Personal persona) {
        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;
        boolean funciono = false;
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_INSERT);
            stms.setString(1, persona.getNombre());
            stms.setString(2, persona.getApellidoPaterno());
            stms.setString(3, persona.getApellidoMaterno());
            stms.setString(4, persona.getDireccion());
            stms.setString(5, persona.getFecha());
            
            rows = stms.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.Close(stms);
            Conexion.Close(conn);
        }
        
        if (rows == 1) {
            funciono = true;
        }
        
        return funciono;
    }
    
    @Override
    public int addPersonalReturnId(Personal persona) {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        int rows = 0;
        boolean funciono = false;
        int idRetorno = -1;
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_INSERT);
            stms.setString(1, persona.getNombre());
            stms.setString(2, persona.getApellidoPaterno());
            stms.setString(3, persona.getApellidoMaterno());
            stms.setString(4, persona.getDireccion());
            stms.setString(5, persona.getFecha());
            
            //rows = stms.executeUpdate();
            rs = stms.executeQuery();
            rs.next();
            idRetorno = rs.getInt("idpersonal");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.Close(stms);
            Conexion.Close(conn);
            Conexion.Close(rs);
        }
        
        /*if (rows == 1) {
            funciono = true;
        }*/
        
        System.out.println("idRetornado"+" "+idRetorno);
        
        return idRetorno;
    }

    @Override
    public boolean editPersonal(Personal persona) {
        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;
        boolean funciono = false;
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_UPDATE);
            stms.setString(1, persona.getNombre());
            stms.setString(2, persona.getApellidoPaterno());
            stms.setString(3, persona.getApellidoMaterno());
            stms.setString(4, persona.getDireccion());
            stms.setString(5, persona.getFecha());
            stms.setInt(6, persona.getIdPersonal());
            
            rows = stms.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.Close(stms);
            Conexion.Close(conn);
        }
        
        if (rows == 1) {
            funciono = true;
        }
        
        return funciono;
    }

    @Override
    public boolean deletePersonal(int id) {
        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;
        boolean funciono = false;
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_DELETE);
            stms.setInt(1, id);
            
            rows = stms.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.Close(stms);
            Conexion.Close(conn);
        }
        
        if (rows == 1) {
            funciono = true;
        }
        
        return funciono;
    }
    
}
