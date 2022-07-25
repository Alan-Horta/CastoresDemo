/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alanh
 */
public class Noticion {
    private int idNoticia;
    private String titulo;
    private String descripcion;
    private String fecha;
    private String autor;

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

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Noticion() {
    }

    public Noticion(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public Noticion(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Noticion(String titulo, String descripcion, String fecha, String autor) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.autor = autor;
    }

    public Noticion(int idNoticia, String titulo, String descripcion, String fecha, String autor) {
        this.idNoticia = idNoticia;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.autor = autor;
    }
    
    
}
