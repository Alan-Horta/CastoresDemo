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
import modelo.Usuario;
import web.CRUD.CRUDUser;
import web.Conexion;

/**
 *
 * @author alanh
 */
public class UsuarioDao implements CRUDUser {

    public static final String SQL_SELECT = "SELECT * FROM usuarios";
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM usuarios WHERE idusuarios=?";
    public static final String SQL_SELECT_BY_NAME = "SELECT * FROM usuarios WHERE usuario=?";
    public static final String SQL_SELECT_BY_LOGIN = "SELECT * FROM usuarios WHERE usuario=? AND password=?";
    public static final String SQL_INSERT = "INSERT INTO usuarios(usuario,password,tipoUsuario,idPersonal) VALUES(?,?,?,?)";
    public static final String SQL_UPDATE = "UPDATE usuarios SET usuario=?, password=?, tipoUsuario=?, idPersonal=? WHERE idusuarios=?";
    public static final String SQL_DELETE = "DELETE FROM usuarios WHERE idusuarios=?";

    @Override
    public List listarUser() {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT);
            rs = stms.executeQuery();

            while (rs.next()) {
                int idUsuario = rs.getInt("idusuarios");
                String user = rs.getString("usuario");
                String pass = rs.getString("password");
                int tipoUser = rs.getInt("tipoUsuario");
                int idPersonal = rs.getInt("idPersonal");

                System.out.println(user + " " + pass + " " + tipoUser);

                usuarios.add(new Usuario(idUsuario, user, pass, tipoUser, idPersonal));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stms);
            Conexion.Close(conn);
        }

        return usuarios;
    }

    @Override
    public Usuario listarUserID(int id) {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT_BY_ID);
            stms.setInt(1, id);
            rs = stms.executeQuery();

            rs.next();
            int idUsuario = rs.getInt("idusuarios");
            String user = rs.getString("usuario");
            String pass = rs.getString("password");
            int tipoUser = rs.getInt("tipoUsuario");
            int idPersonal = rs.getInt("idPersonal");

            usuario.setIdUsuario(idUsuario);
            usuario.setIdPersonal(idPersonal);
            usuario.setUsuario(user);
            usuario.setPassword(pass);
            usuario.setTipoUser(tipoUser);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stms);
            Conexion.Close(conn);
        }

        return usuario;
    }
    
    @Override
    public Usuario listarUserName(String name) {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT_BY_NAME);
            stms.setString(1, name);
            rs = stms.executeQuery();

            rs.next();
            int idUsuario = rs.getInt("idusuarios");
            String user = rs.getString("usuario");
            String pass = rs.getString("password");
            int tipoUser = rs.getInt("tipoUsuario");
            int idPersonal = rs.getInt("idPersonal");

            usuario.setIdUsuario(idUsuario);
            usuario.setIdPersonal(idPersonal);
            usuario.setUsuario(user);
            usuario.setPassword(pass);
            usuario.setTipoUser(tipoUser);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stms);
            Conexion.Close(conn);
        }

        return usuario;
    }

    @Override
    public Usuario listarUserLogin(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stms = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_SELECT_BY_LOGIN);
            stms.setString(1, usuario.getUsuario());
            stms.setString(2, usuario.getPassword());
            rs = stms.executeQuery();

            if (rs.next()) {
                int idUsuario = rs.getInt("idusuarios");
                String user = rs.getString("usuario");
                String pass = rs.getString("password");
                int tipoUser = rs.getInt("tipoUsuario");
                int idPersonal = rs.getInt("idPersonal");

                usuario.setIdUsuario(idUsuario);
                usuario.setIdPersonal(idPersonal);
                usuario.setUsuario(user);
                usuario.setPassword(pass);
                usuario.setTipoUser(tipoUser);
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stms);
            Conexion.Close(conn);
        }

        return usuario;
    }

    @Override
    public boolean addUser(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;
        boolean funciono = false;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_INSERT);
            stms.setString(1, usuario.getUsuario());
            stms.setString(2, usuario.getPassword());
            stms.setInt(3, usuario.getTipoUser());
            stms.setInt(4, usuario.getIdPersonal());

            rows = stms.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(stms);
            Conexion.Close(conn);
        }

        if (rows == 1) {
            funciono = true;
        }

        return funciono;
    }

    @Override
    public boolean editUser(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stms = null;
        int rows = 0;
        boolean funciono = false;

        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_UPDATE);
            stms.setString(1, usuario.getUsuario());
            stms.setString(2, usuario.getPassword());
            stms.setInt(3, usuario.getTipoUser());
            stms.setInt(4, usuario.getIdPersonal());
            stms.setInt(5, usuario.getIdUsuario());

            rows = stms.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(stms);
            Conexion.Close(conn);
        }

        if (rows == 1) {
            funciono = true;
        }

        return funciono;
    }

    @Override
    public boolean deleteUser(int id) {
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
        } finally {
            Conexion.Close(stms);
            Conexion.Close(conn);
        }

        if (rows == 1) {
            funciono = true;
        }

        return funciono;
    }
}
