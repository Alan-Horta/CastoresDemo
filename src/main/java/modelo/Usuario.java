/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alanh
 */
public class Usuario {
    private int idUsuario;
    private String usuario;
    private String password;
    private int tipoUser;
    private int idPersonal;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }
    

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Usuario(int idUsuario, String usuario, String password, int tipoUser) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.tipoUser = tipoUser;
    }

    public Usuario(int idUsuario, String usuario, String password, int tipoUser, int idPersonal) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.tipoUser = tipoUser;
        this.idPersonal = idPersonal;
    }

    public Usuario(String usuario, String password, int tipoUser, int idPersonal) {
        this.usuario = usuario;
        this.password = password;
        this.tipoUser = tipoUser;
        this.idPersonal = idPersonal;
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", password=" + password + ", tipoUser=" + tipoUser + ", idPersonas=" + idPersonal + '}';
    }
}
