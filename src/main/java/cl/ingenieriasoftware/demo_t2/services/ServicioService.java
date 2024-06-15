package cl.ingenieriasoftware.demo_t2.services;

import cl.ingenieriasoftware.demo_t2.entities.Servicio;
import java.util.LinkedList;

public class ServicioService {
    private static ServicioService instance;
    private LinkedList<Servicio> servicios;
    private ServicioService() {
        this.servicios = new LinkedList<>();
    }
    public static ServicioService getInstance(){
        if (instance == null) {
            instance = new ServicioService();
        }
        return instance;
    }
    public boolean addServicio(String nombre, int precio){
        for(Servicio servicio : servicios){
            if(servicio.getNombre().equals(nombre)){
                return false;
            }
        }
        Servicio servicio = new Servicio(nombre, precio);
        servicios.add(servicio);
        return true;
    }
    public Servicio buscarServicio(String nombre){
        for (Servicio servicio : servicios){
            if (servicio.getNombre().equals(nombre)){
                return servicio;
            }
        }
        return null;
    }
}
