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

    // Método para manejar el evento del botón "Volver"
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

    // Método para manejar el evento del botón "Agregar"
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

    // Método para manejar el evento del botón "Modificar"
    @FXML
    private void handleModificar(ActionEvent event) {
        System.out.println("Modificar button clicked");
        // Lógica para modificar un servicio
    }

    // Método para manejar el evento del botón "Eliminar"
    @FXML
    private void handleEliminar(ActionEvent event) {
        System.out.println("Eliminar button clicked");
        // Lógica para eliminar un servicio
    }

    // Método para manejar la selección del menú
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
