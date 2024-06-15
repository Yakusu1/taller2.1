package cl.ingenieriasoftware.demo_t2.entities;

public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private int edad;
    private int Admin;
    private boolean activo;
    public Usuario(String nombre, String apellido, String email, String contrasena, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.edad = edad;
        this.Admin = 0;
        this.activo = false;
    }

    public String getEmail(){return this.email;}

    public String getContrasena(){return this.contrasena;}

    public int getAdmin() {
        return Admin;
    }

    public String toString() {
        return String.format("%-20s %-20s %s/%s %s",
                nombre,
                apellido,
                email);
    }
    public void setAdmin(int i){
        this.Admin = i;
        return;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getActivo() {
        return activo;
    }
}
