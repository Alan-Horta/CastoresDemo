
package web;

import java.util.List;
import modelo.Comentario;
import modelo.Noticion;
import modelo.Personal;
import modelo.Usuario;

public class CRUD {
     

    public interface CRUDUser {

        //USUARIO
        public List listarUser();

        public Usuario listarUserID(int id);
        
        public Usuario listarUserName(String name);
        
        public Usuario listarUserLogin(Usuario usuario);

        public boolean addUser(Usuario usuario);

        public boolean editUser(Usuario usuario);

        public boolean deleteUser(int id);
    }

    public interface CRUDPersonal {

        //PERSONAL
        public List listarPersonal();

        public Personal listarPersonalID(int id);

        public boolean addPersonal(Personal persona);
        
        public int addPersonalReturnId(Personal persona);
        
        public int retrieveIdPersonal(Personal persona);

        public boolean editPersonal(Personal persona);

        public boolean deletePersonal(int id);
    }

    public interface CRUDNoticias {
        //NOTICIAS

        public List listarNoticia();
        
        public List listarNoticiaOrden();

        public Noticion listarNoticiaID(int id);

        public boolean addNoticia(Noticion noticia);

        public boolean editNoticia(Noticion noticia);

        public boolean deleteNoticia(int id);
    }

    public interface CRUDComentarios {
        //COMENTARIOS

        public List listarComentario();
        
        public List listarComentarioIDNoticia(int id);

        public Comentario listarComentarioID(int id);

        public boolean addComentario(Comentario comentario);

        public boolean editComentario(Comentario comentario);

        public boolean deleteComentario(int id);
    }
}
