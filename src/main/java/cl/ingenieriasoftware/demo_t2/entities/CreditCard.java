package cl.ingenieriasoftware.demo_t2.entities;

public class CreditCard {

    private String numero;
    private String nombre;
    private String mes;
    private String anio;
    private String codigoSeguridad;

    /**
     * Método para crear la tejeta de credito
     * @param numero de la tarjeta
     * @param nombre del titular de la tarjeta
     * @param mes de expiración
     * @param anio de exíración
     * @param codigoSeguridad cvc de la tarjeta
     */
    public CreditCard(String numero, String nombre, String mes, String anio, String codigoSeguridad) {
        this.numero = numero;
        this.nombre = nombre;
        this.mes = mes;
        this.anio = anio;
        this.codigoSeguridad = codigoSeguridad;
    }


    /**
     * Método para obtener el número de la tarjeta
     * @return
     */
    public String getNumero() {
        return this.numero;
    }


    /**
     * Método que formatea el string con los parametros entregados
     * @return el nuevo string con el formato
     */
    public String toString() {
        return String.format("%-20s %-20s %s/%s %s",
                nombre,
                numero,
                mes,
                anio,
                codigoSeguridad);
    }
}
