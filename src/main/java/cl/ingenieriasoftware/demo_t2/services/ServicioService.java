package cl.ingenieriasoftware.demo_t2.services;

import cl.ingenieriasoftware.demo_t2.entities.Servicio;
import java.util.LinkedList;

public class ServicioService {
    private static ServicioService instance;
    private LinkedList<Servicio> listaServicios;
    private ServicioService() {
        this.listaServicios = new LinkedList<>();
    }

    /**
     * Método que obtiene la instancia de la clase ServicioService
     * @return
     */
    public static ServicioService getInstance(){
        if (instance == null) {
            instance = new ServicioService();
        }
        return instance;
    }

    /**
     * Método para agregar un servicio
     *
     * @param nombre del servicio
     * @param precio del servicio
     * @return true si se agrega el servicio, false si ya existe
     */

    public boolean addServicio(String nombre, int precio){
        for(Servicio servicio : listaServicios){
            if(servicio.getNombre().equals(nombre)){
                return false;
            }
        }
        Servicio servicio = new Servicio(nombre, precio);
        listaServicios.add(servicio);
        return true;
    }
    public Servicio buscarServicio(String nombre){
        for (Servicio servicio : listaServicios){
            if (servicio.getNombre().equals(nombre)){
                return servicio;
            }
        }
        return null;
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

    public LinkedList<Servicio> getListaServicios() {
        return listaServicios;
    }
}
