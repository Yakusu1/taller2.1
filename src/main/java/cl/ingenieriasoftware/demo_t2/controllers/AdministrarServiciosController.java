package cl.ingenieriasoftware.demo_t2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;

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
    private void handleBtnVolver() {
        System.out.println("Volver button clicked");
        // Lógica para volver a la pantalla anterior
    }

    // Método para manejar el evento del botón "Agregar"
    @FXML
    private void handleBtnAgregar() {
        System.out.println("Agregar button clicked");
        // Lógica para agregar un servicio
    }

    // Método para manejar el evento del botón "Modificar"
    @FXML
    private void handleBtnModificar() {
        System.out.println("Modificar button clicked");
        // Lógica para modificar un servicio
    }

    // Método para manejar el evento del botón "Eliminar"
    @FXML
    private void handleBtnEliminar() {
        System.out.println("Eliminar button clicked");
        // Lógica para eliminar un servicio
    }

    // Método para manejar la selección del menú
    @FXML
    private void handleMenuSeleccionarServicio() {
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
