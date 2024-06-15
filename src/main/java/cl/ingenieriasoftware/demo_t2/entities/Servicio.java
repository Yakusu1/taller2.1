package cl.ingenieriasoftware.demo_t2.entities;


public class Servicio {
    String nombre;
    int precio;

    /**
     * Contrusctor de la clase Servicio
     * @param nombre del servicio
     * @param precio del servicio
     */
    public Servicio(String nombre, int precio) {
        this.nombre = nombre;
        this.precio =  precio;
    }

    /**
     * Método que obtiene el nombre
     * @return nombre del servicio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que obtiene el precio
     * @return precio del servicio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Método que asigna el nombre al servicio
     * @param nombre nuevo que se desea poner al servicio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Méotodo que asigna el precio al servicio
     * @param precio nuevo que se desea poner al servicio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }


}
