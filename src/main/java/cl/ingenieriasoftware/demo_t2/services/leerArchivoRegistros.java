package cl.ingenieriasoftware.demo_t2.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class leerArchivoRegistros {

    /**
     * Método que lee el archivo
     */
    public static void main() {
        String nombreArchivo = "usuarios.txt";
        File archivo = new File(nombreArchivo);

        try (Scanner scanner = new Scanner(archivo)) {

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.split(",");

                String nombre = campos[0].trim();
                String apellido = campos[1].trim();
                String email = campos[2].trim();
                String contrasena = campos[3].trim();
                int edad = Integer.parseInt(campos[4].trim());
                int puntos = Integer.parseInt(campos[5].trim());

                UsuarioService.getInstance().addUsuario(nombre, apellido, email, contrasena, edad);
                if (puntos != 0){
                    UsuarioService.getInstance().getUsuarioC(email).setPuntos(puntos);
                }
                int code = Integer.parseInt(campos[6].trim());
                if( code != 0){
                    UsuarioService.getInstance().getUsuarioC(email).setAdmin(code);
                }
            }

        } catch (FileNotFoundException e) {

            System.out.println("Error");

        }

        nombreArchivo = "servicios.txt";
        archivo = new File(nombreArchivo);

        try (Scanner entrada = new Scanner(archivo)) {
            int i = 0;
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                String[] datos = linea.split(",");
                String nombre = datos[0];
                String precio = datos[1];
                ServicioService.getInstance().addServicio(nombre, Integer.parseInt(precio));
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}
