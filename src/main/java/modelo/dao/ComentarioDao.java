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
import modelo.Comentario;
import modelo.Noticion;
import web.CRUD;
import web.Conexion;

/**
 *
 * @author alanh
 */
public class ComentarioDao implements CRUD.CRUDComentarios{
    
    public static final String SQL_SELECT = "SELECT * FROM comentarios";
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM comentarios WHERE idComentario=?";
    public static final String SQL_SELECT_BY_IDNOTICIA = "SELECT * FROM comentarios INNER JOIN usuarios ON comentarios.idusuarios = usuarios.idusuarios WHERE comentarios.idNoticia=?";
    public static final String SQL_INSERT = "INSERT INTO comentarios(comentario,idNoticia,idRespuesta,fecha,idusuarios) VALUES(?,?,?,?,?)";
    public static final String SQL_UPDATE = "UPDATE comentarios SET titulo=?, descripcion=?, fecha=?, autor=? WHERE idComentario=?";
    public static final String SQL_DELETE = "DELETE FROM comentarios WHERE idComentario=?";

    @Override
    public List listarComentario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List listarComentarioIDNoticia(int id) {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        List<Comentario> comentarios = new ArrayList<Comentario>();
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT_BY_IDNOTICIA);
            stms.setInt(1, id);
            rs = stms.executeQuery();
            
            while (rs.next()) {
                int idComentario = rs.getInt("idComentario");
                String coment = rs.getString("comentario");
                int idNoticias = rs.getInt("idNoticia");
                int idRespuesta = rs.getInt("idRespuesta");
                int idUser = rs.getInt("idusuarios");
                String fecha = rs.getString("fecha");
                String autor = rs.getString("usuario");
                int rol = rs.getInt("tipoUsuario");
                if (rol == 1){
                    autor += " (Interno)";
                }else{
                    autor += " (Externo)";
                }
                
                comentarios.add(new Comentario(idComentario, coment, idNoticias, idRespuesta, idUser, fecha, autor));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.Close(rs);
            Conexion.Close(stms);
            Conexion.Close(conn);
        }
        
        return comentarios;
    }

    @Override
    public Comentario listarComentarioID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addComentario(Comentario comentario) {
        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;
        boolean funciono = false;
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_INSERT);
            stms.setString(1, comentario.getComentario());
            stms.setInt(2, comentario.getIdNoticia());
            stms.setInt(3, comentario.getIdRespuesta());
            stms.setString(4, comentario.getFecha());
            stms.setInt(5, comentario.getIdUsuario());
            
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
    public boolean editComentario(Comentario comentario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteComentario(int id) {
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
