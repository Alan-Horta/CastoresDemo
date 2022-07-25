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
import modelo.Noticion;
import web.CRUD;
import web.Conexion;

/**
 *
 * @author alanh
 */
public class NoticionDao implements CRUD.CRUDNoticias{
    public static final String SQL_SELECT = "SELECT * FROM noticias";
    public static final String SQL_SELECT_DESC = "SELECT * FROM noticias ORDER BY idNoticias DESC";
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM noticias WHERE idNoticias=?";
    public static final String SQL_INSERT = "INSERT INTO noticias(titulo,descripcion,fecha,autor) VALUES(?,?,?,?)";
    public static final String SQL_UPDATE = "UPDATE noticias SET titulo=?, descripcion=?, fecha=?, autor=? WHERE idNoticias=?";
    public static final String SQL_DELETE = "DELETE FROM noticias WHERE idNoticias=?";

    @Override
    public List listarNoticia() {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        List<Noticion> noticias = new ArrayList<Noticion>();
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT);
            rs = stms.executeQuery();
            
            while (rs.next()) {
                int idNoticias = rs.getInt("idNoticias");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String fecha = rs.getString("fecha");
                String autor = rs.getString("autor");
                
                noticias.add(new Noticion(idNoticias, titulo, descripcion, fecha, autor));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.Close(rs);
            Conexion.Close(stms);
            Conexion.Close(conn);
        }
        
        return noticias;
    }
    
    @Override
    public List listarNoticiaOrden() {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        List<Noticion> noticias = new ArrayList<Noticion>();
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT_DESC);
            rs = stms.executeQuery();
            
            while (rs.next()) {
                int idNoticias = rs.getInt("idNoticias");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String fecha = rs.getString("fecha");
                String autor = rs.getString("autor");
                
                noticias.add(new Noticion(idNoticias, titulo, descripcion, fecha, autor));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.Close(rs);
            Conexion.Close(stms);
            Conexion.Close(conn);
        }
        
        return noticias;
    }

    @Override
    public Noticion listarNoticiaID(int id) {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        Noticion noticia = new Noticion();
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT_BY_ID);
            stms.setInt(1, id);
            rs = stms.executeQuery();

                rs.next();
                int idNoticias = rs.getInt("idNoticias");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String fecha = rs.getString("fecha");
                String autor = rs.getString("autor");
                
            noticia.setIdNoticia(idNoticias);
            noticia.setTitulo(titulo);
            noticia.setDescripcion(descripcion);
            noticia.setFecha(fecha);
            noticia.setAutor(autor);
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.Close(rs);
            Conexion.Close(stms);
            Conexion.Close(conn);
        }
        
        return noticia;
    }

    @Override
    public boolean addNoticia(Noticion noticia) {
        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;
        boolean funciono = false;
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_INSERT);
            stms.setString(1, noticia.getTitulo());
            stms.setString(2, noticia.getDescripcion());
            stms.setString(3, noticia.getFecha());
            stms.setString(4, noticia.getAutor());
            
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
    public boolean editNoticia(Noticion noticia) {
        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;
        boolean funciono = false;
        
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_UPDATE);
            stms.setString(1, noticia.getTitulo());
            stms.setString(2, noticia.getDescripcion());
            stms.setString(3, noticia.getFecha());
            stms.setString(4, noticia.getAutor());
            stms.setInt(5, noticia.getIdNoticia());
            
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
    public boolean deleteNoticia(int id) {
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
