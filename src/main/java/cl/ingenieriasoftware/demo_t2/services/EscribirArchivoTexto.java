package cl.ingenieriasoftware.demo_t2.services;
import cl.ingenieriasoftware.demo_t2.services.UsuarioService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class EscribirArchivoTexto {
    /**
     * Método que realiza la escritura de archivo del sistema
     * @param nombre del usuario
     * @param apellido del usuario
     * @param email del usuario
     * @param contrasena del usuario
     * @param edad del usuario
     */
    public static void main(String nombre, String apellido, String email, String contrasena, int edad) {
        String nombreArchivo = "usuarios.txt";
        String code = String.valueOf(UsuarioService.getInstance().getUsuarioC(email).getAdmin());
        String puntos = String.valueOf(UsuarioService.getInstance().getUsuarioC(email).getPuntos());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.newLine();
            bw.write(nombre + "," + apellido + "," + email + "," + contrasena + "," + edad + "," + "," + puntos+ ","+ code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite la escritura de archivo de servicio
     * @param nombre del servicio
     * @param precio del servicio
     */
    public static void escrituraServicio(String nombre, int precio) {
        String nombreArchivo = "servicios.txt";
        String costo = String.valueOf(ServicioService.getInstance().buscarServicio(nombre).getPrecio());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.newLine();
            bw.write(nombre + "," + costo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}