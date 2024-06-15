package cl.ingenieriasoftware.demo_t2.services;

import cl.ingenieriasoftware.demo_t2.entities.CreditCard;
import cl.ingenieriasoftware.demo_t2.entities.Usuario;
import java.util.LinkedList;
import java.util.Map;

public class UsuarioService {
    private static UsuarioService instance;
    private LinkedList<Usuario> Usuarios;
    private UsuarioService() {
        this.Usuarios = new LinkedList<>();
    }

    /**
     * Método que obtiene la instacia de la clase UsuarioService
     * @return la instancia
     */
    public static UsuarioService getInstance(){
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }

    /**
     * Método que permite añadir un usuario
     * @param nombre del usuario
     * @param apellido del usuario
     * @param email del usuario
     * @param contrasena del usuario
     * @param edad del usuario
     * @return true si se ingresa de manera correcta, false si el usuario ya se encuentra en el sistema
     */
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

    /**
     * Método que obtiene el usuario de la lista de usuarios
     * @param email del usuario
     * @param contrasena del usuario
     * @return true si encuentra al usuario dentro de la lista, false si no encuentra al usuario
     */
    public  boolean getUsuario(String email, String contrasena){
        for(Usuario usuario : Usuarios){
            if(usuario.getEmail().equals(email) && usuario.getContrasena().equals(contrasena)){
                return true;
            }
        }
        return false;
    }

    /**
     * Método que obtiene al usuario mediante el correo
     * @param email del usuario
     * @return true si encuentra al usuario, false si no existe dentro de la lista
     */
    public Usuario getUsuarioC(String email){
        for (Usuario usuario : Usuarios){
            if (usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }

    /**
     * Método que ve si elusario está activo o no dentro de la lista
     * @return true si lo encuentra, false si no existe
     */
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
