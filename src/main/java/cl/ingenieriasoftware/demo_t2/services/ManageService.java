package cl.ingenieriasoftware.demo_t2.services;

import cl.ingenieriasoftware.demo_t2.entities.Servicio;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;


public class ManageService {

    private static ManageService instance;
    private static LinkedList<Servicio> listaServicios;
    private ManageService() {this.listaServicios = new LinkedList<>();}

    /**
     * Método que crea ManageService
     * @return instancia del ManageService
     */

    public static ManageService getInstance() {
        if (instance == null) {
            instance = new ManageService();
        }
        return instance;
    }

    /**
     * Método que lee el archivo con los servicio y crea los servicio
     */
    public static void leerArchivo(){
        String Nombrearchivo = "servicios.txt";
        File archivo = new File(Nombrearchivo);

        try (Scanner entrada = new Scanner(archivo)){
            int i = 0;
            while (entrada.hasNext()){
                String linea = entrada.nextLine();
                String[] datos = linea.split(",");
                String nombre = datos[0];
                String precio = datos[1];
                addServicio(nombre, precio);
            }

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public static boolean addServicio(String nombre, String precio){
        Servicio servicio = new Servicio(nombre, Integer.parseInt(precio));
        listaServicios.add(servicio);
        return true;
    }

    /**
     * Método que modifica el nombre y o precio de un servicio
     * @param nombre del servicio
     * @param precio del servicio
     * @param servicio que deseamos modificar
     * @return true si se logra modificar, false si no se puede modificar
     */

    public static boolean modificarServicio(String nombre, String precio, Servicio servicio){
        if(nombre == null || nombre.isEmpty() || precio == null || precio.isEmpty() || Integer.parseInt(precio) < 300){
            return false;
        }
        else{
            servicio.setNombre(nombre);
            servicio.setPrecio(Integer.parseInt(precio));
        }
        return true;
    }

    /**
     * Método para eliminar un servicio
     * @param servicio que deseamos eliminar
     * @return true si se eliminó correctamente, false si el servicio no existe.
     */
    public static boolean eliminarServicio(String servicio){
        if(servicio == null || servicio.isEmpty()){
            return false;
        }
        else {
            servicio = servicio.trim();
        }
        return true;
    }


}
