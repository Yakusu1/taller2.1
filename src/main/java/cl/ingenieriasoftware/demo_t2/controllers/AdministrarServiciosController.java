package cl.ingenieriasoftware.demo_t2.controllers;

import cl.ingenieriasoftware.demo_t2.DemoApplication;
import cl.ingenieriasoftware.demo_t2.entities.Usuario;
import cl.ingenieriasoftware.demo_t2.services.UsuarioService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import cl.ingenieriasoftware.demo_t2.entities.Servicio;
import cl.ingenieriasoftware.demo_t2.services.ServicioService;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class AdministrarServiciosController implements Initializable {

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnAgregar;

    @FXML

    private Button btnModificar;

    @FXML
    private Button btnEliminar;

    @FXML
    private MenuButton menuButton;

    @FXML
    private Label lblSeleccionarServicio;

    @FXML
    private Label lblAgregarServicio;

    @FXML
    private Label lblTitulo;

    private LinkedList<Servicio> servicios = ServicioService.getInstance().getListaServicios();

    /**
     * Método que permite volver a la interfaz anterior
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleVolver(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(DemoApplication.class.getResource("menu-usuario-view.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Menu");
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    /**
     * Método que al accionar el botón de agregar va hacía otra interfaz para agregar el servicio
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleAgregar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(DemoApplication.class.getResource("agregar-servicio-view.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Agregar servicio");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    /**
     * Método que al accionar el botoón de moidificar permite ir a otra interfaz para modificar el servicio
     * @param event
     */
    @FXML
    private void handleModificar(ActionEvent event) {
        System.out.println("Modificar button clicked");
        // Lógica para modificar un servicio
    }

    /**
     * Método que al accionar el boton de eliminar permite borrar un servicio
     * @param event
     */
    @FXML
    private void handleEliminar(ActionEvent event) {
        System.out.println("Eliminar button clicked");
        // Lógica para eliminar un servicio
    }

    /**
     * Método que permite seleccionar un servicio del menú
     * @param event
     */
    @FXML
    private void handleMenuSeleccionarServicio(ActionEvent event) {
        Platform.runLater(() -> {
            if (menuButton != null) {
                menuButton.getItems().clear(); // Limpiar elementos previos
                for (Servicio servicio : ServicioService.getInstance().getListaServicios()) {
                    System.out.println("hola ctm");
                    String hola = servicio.getNombre() + "," + String.valueOf(servicio.getPrecio());
                    MenuItem m = new MenuItem(hola);
                    menuButton.getItems().add(m);
                }
            } else {
                System.out.println("menuButton is null");
            }
        });
        TilePane vb = new TilePane(lblTitulo, menuButton);

    }

    private void mostrarServicios() {
        System.out.println("Servicios disponibles:");
        for (Servicio servicio : servicios) {
            System.out.println(servicio);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize method called");
        actualizarMenuButton();
    }

    private void actualizarMenuButton() {
        Platform.runLater(() -> {
            if (menuButton != null) {
                menuButton.getItems().clear(); // Limpiar elementos previos
                for (Servicio servicio : ServicioService.getInstance().getListaServicios()) {
                    System.out.println("hola ctm");
                    String hola = servicio.getNombre() + "," + String.valueOf(servicio.getPrecio());
                    MenuItem m = new MenuItem(hola);
                    menuButton.getItems().add(m);
                }
            } else {
                System.out.println("menuButton is null");
            }
        });
    }

    // Método para agregar un nuevo servicio y actualizar la UI
    public void agregarNuevoServicio(Servicio nuevoServicio) {
        ServicioService.getInstance().addServicio(nuevoServicio.getNombre(), nuevoServicio.getPrecio());
        actualizarMenuButton();
    }
}
