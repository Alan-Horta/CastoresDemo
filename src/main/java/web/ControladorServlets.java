/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import modelo.Comentario;
import modelo.Noticion;
import modelo.Personal;
import modelo.Usuario;
import modelo.dao.ComentarioDao;
import modelo.dao.NoticionDao;
import modelo.dao.PersonalDao;
import modelo.dao.UsuarioDao;

/**
 *
 * @author alanh
 */
@WebServlet(name = "ControladorServlets", urlPatterns = {"/ControladorServlets"})
public class ControladorServlets extends HttpServlet {

    String cookieNameUser = "usuario";
    String cookieNamePersona = "persona";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String tipo = request.getParameter("tipo");
        if (tipo != null) {
            switch (tipo) {
                case "back":
                    verNoticias(request, response);
                    break;
                case "sesion":
                    if (accion != null) {
                        switch (accion) {
                            case "modificar":
                                this.modificarUsuario(request, response);
                                break;
                            case "eliminar":
                                eliminarUsuario(request, response);
                                break;
                            default:
                        }
                    }
                    break;
                case "noticias":
                    if (accion != null) {
                        switch (accion) {
                            case "ver":
                                this.verNoticiaEspecifica(request, response);
                                break;
                            case "eliminar":
                                eliminarNoticia(request, response);
                                break;
                            default:
                        }
                    }
                    break;
                case "comentarios":
                    if (accion != null) {
                        switch (accion) {
                            case "eliminar":
                                eliminarComentario(request, response);
                                break;
                            default:
                        }
                    }
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        String accion = request.getParameter("accion");
        if (tipo != null) {
            switch (tipo) {
                case "sesion":
                    if (accion != null) {
                        switch (accion) {
                            case "iniciar":
                                iniciarSesion(request, response);
                                break;
                            case "crear":
                                crearUsuario(request, response);
                                break;
                            case "eliminar":
                                eliminarUsuario(request, response);
                                break;
                            case "editar":
                                editarUsuario(request, response);
                                break;
                            default:

                        }
                    }
                    break;
                case "noticias":
                    if (accion != null) {
                        switch (accion) {
                            case "crear":
                                crearNoticia(request, response);
                                break;
                            case "editar":
                                editarNoticia(request, response);
                                break;
                            default:

                        }
                    }
                    break;
                case "comentarios":
                    if (accion != null) {
                        switch (accion) {
                            case "crear":
                                crearComentario(request, response);
                                break;
                            default:

                        }
                    }
                    break;
            }
        }
    }

    private void verNoticias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Noticion> noticias = new NoticionDao().listarNoticiaOrden();
        System.out.println("noticias = " + noticias);
        Cookie[] cookies = request.getCookies();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("noticias", noticias);
        Usuario ususario = new Usuario();
        ObjectMapper objectMapper = new ObjectMapper();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieNameUser)) {
                    Usuario user = objectMapper.readValue(c.getValue(), Usuario.class);
                    ususario = user;
                    //ususario.toString();
                }
            }
        }
        sesion.setAttribute("user", ususario);

        response.sendRedirect("noticiero.jsp");
    }

    private void verNoticias(HttpServletRequest request, HttpServletResponse response, Cookie[] cookies) throws ServletException, IOException {
        List<Noticion> noticias = new NoticionDao().listarNoticiaOrden();
        System.out.println("noticias = " + noticias);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("noticias", noticias);
        Usuario ususario = new Usuario();
        ObjectMapper objectMapper = new ObjectMapper();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieNameUser)) {
                    Usuario user = objectMapper.readValue(c.getValue(), Usuario.class);
                    ususario = user;
                    //ususario.toString();
                }
            }
        }
        sesion.setAttribute("user", ususario);

        response.sendRedirect("noticiero.jsp");
    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("user");
        String pass = request.getParameter("pass");
        Usuario sesion = new UsuarioDao().listarUserLogin(new Usuario(usuario, pass));
        PrintWriter out = response.getWriter();
        System.out.println(sesion.toString());
        if (sesion.getIdUsuario() <= 0) {
            System.out.println("usuario no encontrado");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Usuario o password incorrecto');");
            out.println("location='index.jsp';");
            out.println("</script>");
            return;
            //response.sendRedirect("index.jsp");
        }

        System.out.println("usuario encontrado");

        String jsonUser = "";
        String jsonPersona = "";
        ObjectMapper objectMapper = new ObjectMapper();

        Personal persona = new PersonalDao().listarPersonalID(sesion.getIdPersonal());
        if (persona.getIdPersonal() <= 0) {
            System.out.println("persona no encontrado");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error en el back');");
            out.println("location='index.jsp';");
            out.println("</script>");
            return;
        }

        Cookie[] galletitas = new Cookie[2];

        try {
            jsonUser = objectMapper.writeValueAsString(sesion);
            jsonPersona = objectMapper.writeValueAsString(persona);
            Cookie userCookie = new Cookie(cookieNameUser, jsonUser);
            Cookie personaCookie = new Cookie(cookieNamePersona, jsonPersona);
            response.addCookie(userCookie);
            response.addCookie(personaCookie);
            galletitas[0] = userCookie;
            galletitas[1] = personaCookie;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        verNoticias(request, response, galletitas);
    }

    private void crearUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("paterno");
        String apellidoM = request.getParameter("materno");
        String direccion = request.getParameter("direccion");
        String usuario = request.getParameter("user");
        String pass = request.getParameter("pass");
        String rol = request.getParameter("intern");
        PrintWriter out = response.getWriter();
        int tipoUsuario = 0;
        if (rol != null) {
            tipoUsuario = Integer.parseInt(rol);
        }

        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String currentTime = sdf.format(dt);

        Usuario verifUser = new UsuarioDao().listarUserName(usuario);
        if (verifUser.getIdUsuario() > 0) {
            System.out.println("usuario ya existente");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('El usuario ya existe, intente con otro');");
            out.println("location='noticiero.jsp';");
            out.println("</script>");
            return;
        }

        boolean personalCreado = new PersonalDao().addPersonal(new Personal(nombre, apellidoP, apellidoM, direccion, currentTime));
        if (!personalCreado) {
            System.out.println("personal salio malito");
            return;
        }

        int idPersonal = new PersonalDao().retrieveIdPersonal(new Personal(nombre, apellidoP, apellidoM, direccion, currentTime));
        if (idPersonal == -1) {
            System.out.println("idRetornado salio malito");
            return;
        }

        boolean nuevoUser = new UsuarioDao().addUser(new Usuario(usuario, pass, tipoUsuario, idPersonal));
        if (nuevoUser) {
            System.out.println("Usuario creado");
        } else {
            boolean borrarPersonaSinUser = new PersonalDao().deletePersonal(idPersonal);
            System.out.println("Usuario fallo");
        }

        response.sendRedirect("index.jsp");
    }

    private void crearNoticia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("title");
        String descripcion = request.getParameter("descripcion");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        ObjectMapper objectMapper = new ObjectMapper();
        String autor = "";

        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String currentTime = sdf.format(dt);

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieNameUser)) {
                    Usuario user = objectMapper.readValue(c.getValue(), Usuario.class);
                    autor = user.getUsuario();
                }
            }
        }

        boolean noticiaCreada = new NoticionDao().addNoticia(new Noticion(titulo, descripcion, currentTime, autor));
        if (!noticiaCreada) {
            System.out.println("noticia no creada");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error en el back');");
            out.println("location='noticiero.jsp';");
            out.println("</script>");
            return;
        }
        verNoticias(request, response);
    }

    private void editarNoticia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("title");
        String descripcion = request.getParameter("descripcion");
        int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        ObjectMapper objectMapper = new ObjectMapper();
        String autor = "";

        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String currentTime = sdf.format(dt);

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieNameUser)) {
                    Usuario user = objectMapper.readValue(c.getValue(), Usuario.class);
                    autor = user.getUsuario();
                }
            }
        }

        boolean noticiaCreada = new NoticionDao().editNoticia(new Noticion(idNoticia, titulo, descripcion, currentTime, autor));
        if (!noticiaCreada) {
            System.out.println("noticia no editada");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error en el back');");
            out.println("location='noticiero.jsp';");
            out.println("</script>");
            return;
        }
        verNoticiaEspecifica(request, response);
    }

    private void crearComentario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
        int idRespuesta = Integer.parseInt(request.getParameter("idRespuesta"));
        String comentario = request.getParameter("comment");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        ObjectMapper objectMapper = new ObjectMapper();
        Usuario user = new Usuario();

        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String currentTime = sdf.format(dt);

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieNameUser)) {
                    user = objectMapper.readValue(c.getValue(), Usuario.class);
                }
            }
        }

        boolean comentCreado = new ComentarioDao().addComentario(new Comentario(comentario, idNoticia, idRespuesta, user.getIdUsuario(), currentTime, user.getUsuario()));
        if (!comentCreado) {
            System.out.println("comentario no creada");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error en el back');");
            out.println("location='noticiero.jsp';");
            out.println("</script>");
            return;
        }
        verNoticiaEspecifica(request, response);
    }

    private void verNoticiaEspecifica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
        Noticion noticia = new NoticionDao().listarNoticiaID(idNoticia);
        List<Comentario> comentarios = new ComentarioDao().listarComentarioIDNoticia(idNoticia);
        System.out.println("noticia = " + noticia);
        System.out.println("comentarios = " + comentarios);
        Cookie[] cookies = request.getCookies();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("noticia", noticia);
        sesion.setAttribute("comentarios", comentarios);
        Usuario ususario = new Usuario();
        ObjectMapper objectMapper = new ObjectMapper();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieNameUser)) {
                    Usuario user = objectMapper.readValue(c.getValue(), Usuario.class);
                    ususario = user;
                }
            }
        }
        sesion.setAttribute("user", ususario);

        response.sendRedirect("verNoticia.jsp");
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUser = Integer.parseInt(request.getParameter("idUsuario"));
        boolean usuarioEliminado = new UsuarioDao().deleteUser(idUser);
        PrintWriter out = response.getWriter();
        if (usuarioEliminado) {
            System.out.println("usuario eliminado");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('usuario eliminado con exito');");
            out.println("location='index.jsp';");
            out.println("</script>");
            return;
        } else {
            System.out.println("usuario no eliminado");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('usuario no eliminado');");
            out.println("location='index.jsp';");
            out.println("</script>");
            return;
        }
        //response.sendRedirect("index.jsp");
    }

    private void eliminarNoticia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
        boolean noticiaEliminada = new NoticionDao().deleteNoticia(idNoticia);
        PrintWriter out = response.getWriter();
        if (noticiaEliminada) {
            /*System.out.println("noticia eliminado");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('noticia eliminado con exito');");
            out.println("location='noticiero.jsp';");
            out.println("</script>");
            return;*/
        } else {
            System.out.println("noticia no eliminado");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('noticia no eliminado');");
            out.println("location='noticiero.jsp';");
            out.println("</script>");
            return;
        }
        verNoticias(request, response);
        //response.sendRedirect("index.jsp");
    }

    private void eliminarComentario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
        int idComentario = Integer.parseInt(request.getParameter("idComentario"));
        boolean comentEliminada = new ComentarioDao().deleteComentario(idComentario);
        PrintWriter out = response.getWriter();
        if (comentEliminada) {
            /*System.out.println("noticia eliminado");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('noticia eliminado con exito');");
            out.println("location='noticiero.jsp';");
            out.println("</script>");
            return;*/
        } else {
            System.out.println("comentario no eliminado");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('comentario no eliminado');");
            out.println("location='noticiero.jsp';");
            out.println("</script>");
            return;
        }
        verNoticiaEspecifica(request, response);
    }

    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        HttpSession sesion = request.getSession();
        Usuario ususario = new Usuario();
        Personal persona = new Personal();
        ObjectMapper objectMapper = new ObjectMapper();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieNameUser)) {
                    ususario = objectMapper.readValue(c.getValue(), Usuario.class);
                }
                if (c.getName().equals(cookieNamePersona)) {
                    persona = objectMapper.readValue(c.getValue(), Personal.class);
                }
            }
        }

        request.setAttribute("usuario", ususario);
        request.setAttribute("persona", persona);
        String jspEditar = "/WEB-INF/paginas/secciones/editarUsuario.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //int idUser = Integer.parseInt(request.getParameter("idUsuario"));
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String dir = request.getParameter("dir");

        Cookie[] cookies = request.getCookies();
        Usuario userCookie = new Usuario();
        Personal personaCookie = new Personal();
        Usuario userEdit = new Usuario();
        Personal personaEdit = new Personal();

        ObjectMapper objectMapper = new ObjectMapper();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieNameUser)) {
                    userCookie = objectMapper.readValue(c.getValue(), Usuario.class);
                }
                if (c.getName().equals(cookieNamePersona)) {
                    personaCookie = objectMapper.readValue(c.getValue(), Personal.class);
                }
            }
        }
        userEdit.setIdPersonal(userCookie.getIdPersonal());
        userEdit.setTipoUser(userCookie.getTipoUser());
        userEdit.setUsuario(userCookie.getUsuario());
        userEdit.setIdUsuario(userCookie.getIdUsuario());
        userEdit.setPassword(pass);

        personaEdit.setIdPersonal(personaCookie.getIdPersonal());
        personaEdit.setFecha(personaCookie.getFecha());
        personaEdit.setNombre(name);
        personaEdit.setApellidoPaterno(paterno);
        personaEdit.setApellidoMaterno(materno);
        personaEdit.setDireccion(dir);

        boolean personaEditada = new PersonalDao().editPersonal(personaEdit);
        boolean usuarioEditado = new UsuarioDao().editUser(userEdit);
        PrintWriter out = response.getWriter();
        if (usuarioEditado) {
            System.out.println("usuario editado");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('usuario editado con exito, vuelve a iniciar sesión');");
            out.println("location='index.jsp';");
            out.println("</script>");
            return;
        } else {
            System.out.println("usuario no editado");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('usuario no editado');");
            out.println("location='index.jsp';");
            out.println("</script>");
            return;
        }
        //response.sendRedirect("index.jsp");
    }
}
