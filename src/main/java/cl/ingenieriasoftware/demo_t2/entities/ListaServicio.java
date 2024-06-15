package cl.ingenieriasoftware.demo_t2.entities;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ListaServicio {

    private SimpleStringProperty nombre;
    public SimpleIntegerProperty precio;
    public SimpleBooleanProperty seleccion;

    /**
     * Constructor de la clase
     * @param nombre del servicio
     * @param precio del servicio
     * @param seleccion booleano que permite ver si el servicio está seleccionado o no
     */
    public ListaServicio(String nombre, Integer precio, boolean seleccion) {
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleIntegerProperty(precio);
        this.seleccion = new SimpleBooleanProperty(seleccion);
    }

    /**
     * Método para obtener el nombre del servicio
     * @return
     */
    public String getNombre() {
        return nombre.get();
    }

    /**
     * Método para asignar el nombre del servicio
     * @param nombre del servicio
     */
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    /**
     * Método para obtener el precio del servicio
     * @return precio del profcuto
     */
    public double getPrecio() {
        return precio.get();
    }

    /**
     * Método para asignar el precio del servicio
     * @param precio del servicio
     */
    public void setPrecio(Integer precio) {
        this.precio.set(precio);
    }

    /**
     * Método que indica si esta seleccionado el servicio o no
     * @return seleccion del servicio
     */
    public boolean isSelected() {
        return seleccion.get();
    }

    /**
     *
     * @param seleccion del servicio
     */
    public void setSelected(boolean seleccion) {
        this.seleccion.set(seleccion);
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public SimpleIntegerProperty priceProperty() {
        return precio;
    }

    public SimpleBooleanProperty selectedProperty() {
        return seleccion;
    }
}
