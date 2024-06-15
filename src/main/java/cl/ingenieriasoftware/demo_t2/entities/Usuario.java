package cl.ingenieriasoftware.demo_t2.entities;

public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private int edad;
    private int Admin;
    private boolean activo;
    private int puntos;

    /**
     * Constructor de la clase Usuario
     * @param nombre del cliente
     * @param apellido del cliente
     * @param email del cliente
     * @param contrasena del cliente
     * @param edad del cliente
     */
    public Usuario(String nombre, String apellido, String email, String contrasena, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.edad = edad;
        this.Admin = 0;
        this.activo = false;
        this.puntos = 0;
    }

    /**
     * Método que obtiene el email del usuario
     * @return email del cliente
     */
    public String getEmail(){return this.email;}

    /**
     * Método que obtiene la contraseña del usuario
     * @return
     */
    public String getContrasena(){return this.contrasena;}

    public int getAdmin() {
        return Admin;
    }

    /**
     * Método que formatea los parametros del usuario
     * @return
     */
    public String toString() {
        return String.format("%-20s %-20s %s/%s %s",
                nombre,
                apellido,
                email);
    }

    /**
     * Método que asigna a un usuario el rol de administrador
     * @param i, número que indica si es administrador o no
     */
    public void setAdmin(int i){
        this.Admin = i;
        return;
    }

    /**
     * Método que indica que usuario se encuentra activo dentro del sistema
     * @param activo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Método que obtiene si el usuario está activo dentro del sistema
     * @return si el usuario se encuentra activo
     */
    public boolean getActivo() {
        return activo;
    }

    /**
     * Método que asigna los puntos totales del cliente
     * @param puntos
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Método que obtiene los puntos totales del cliente
     * @return
     */
    public int getPuntos() {
        return puntos;
    }
}
