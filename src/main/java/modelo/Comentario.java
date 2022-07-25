/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alanh
 */
public class Comentario {
    private int idComentario;
    private String comentario;
    private int idNoticia;
    private int idRespuesta;
    private int idUsuario;
    private String fecha;
    private String autor;

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Comentario() {
    }

    public Comentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public Comentario(int idComentario, String comentario, int idNoticia) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.idNoticia = idNoticia;
    }

    public Comentario(String comentario, int idNoticia) {
        this.comentario = comentario;
        this.idNoticia = idNoticia;
    }

    public Comentario(String comentario) {
        this.comentario = comentario;
    }

    public Comentario(int idComentario, String comentario, int idNoticia, int idRespuesta, int idUsuario, String fecha, String autor) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.idNoticia = idNoticia;
        this.idRespuesta = idRespuesta;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.autor = autor;
    }

    public Comentario(String comentario, int idNoticia, int idRespuesta, int idUsuario, String fecha, String autor) {
        this.comentario = comentario;
        this.idNoticia = idNoticia;
        this.idRespuesta = idRespuesta;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.autor = autor;
    }

    
    
    
}
