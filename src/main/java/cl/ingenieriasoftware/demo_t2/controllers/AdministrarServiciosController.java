package cl.ingenieriasoftware.demo_t2.controllers;

import cl.ingenieriasoftware.demo_t2.DemoApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AdministrarServiciosController {

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnEliminar;

    @FXML
    private MenuButton menuSeleccionarServicio;

    @FXML
    private Label lblSeleccionarServicio;

    @FXML
    private Label lblAgregarServicio;

    @FXML
    private Label lblTitulo;

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
        MenuItem selectedItem = menuSeleccionarServicio.getItems().stream()
                .filter(item -> item.getText().equals(menuSeleccionarServicio.getText()))
                .findFirst()
                .orElse(null);

        if (selectedItem != null) {
            System.out.println("Selected service: " + selectedItem.getText());
            // Lógica para manejar la selección del servicio
        }
    }
}
