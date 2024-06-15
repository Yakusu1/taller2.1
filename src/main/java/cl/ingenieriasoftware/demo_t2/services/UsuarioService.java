package cl.ingenieriasoftware.demo_t2.services;

import cl.ingenieriasoftware.demo_t2.entities.CreditCard;
import cl.ingenieriasoftware.demo_t2.entities.Usuario;
import java.util.LinkedList;

public class UsuarioService {
    private static UsuarioService instance;
    private LinkedList<Usuario> Usuarios;
    private UsuarioService() {
        this.Usuarios = new LinkedList<>();
    }
    public static UsuarioService getInstance(){
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }
    public boolean addUsuario(String nombre, String apellido, String email, String contrasena, int edad) {

        for (Usuario usuario : Usuarios) {
            if (usuario.getEmail().equals(email)) {
                return false;
            }
        }
        Usuario nuevoUsuario = new Usuario(nombre, apellido, email, contrasena, edad);
        Usuarios.add(nuevoUsuario);
        return true;
    }
    public  boolean getUsuario(String email, String contrasena){
        for(Usuario usuario : Usuarios){
            if(usuario.getEmail().equals(email) && usuario.getContrasena().equals(contrasena)){
                return true;
            }
        }
        return false;
    }
    public Usuario getUsuarioC(String email){
        for (Usuario usuario : Usuarios){
            if (usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }
    public Usuario getUsuarioActivo(){
        for (Usuario usuario : Usuarios){
            if (usuario.getActivo()){
                return usuario;
            }
        }
        return null;
    }
    public LinkedList<Usuario> getUsuarios() {
        return Usuarios;
    }

}
