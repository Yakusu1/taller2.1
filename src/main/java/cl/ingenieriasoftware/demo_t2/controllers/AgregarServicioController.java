package cl.ingenieriasoftware.demo_t2.controllers;

import cl.ingenieriasoftware.demo_t2.DemoApplication;
import cl.ingenieriasoftware.demo_t2.Util.AlertMessage;
import cl.ingenieriasoftware.demo_t2.services.ServicioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AgregarServicioController {
    @FXML
    private TextField textNombre;
    @FXML
    private TextField textPrecio;

    @FXML
    public void handleAgregar(ActionEvent event) {
        String nombre = textNombre.getText();
        String precio = textPrecio.getText();
        if(nombre.isEmpty() || precio.isEmpty()){
            AlertMessage.show(Alert.AlertType.ERROR, "ERROR", "debes rellenar todos los campos");
            return;
        }
        int precio1;
        try {
            precio1 = Integer.parseInt(precio);
        } catch (NumberFormatException e) {

            AlertMessage.show(Alert.AlertType.ERROR, "ERROR", "el precio debe ser un numero");
            return;
        }
        if(precio1 < 500){
            AlertMessage.show(Alert.AlertType.ERROR, "ERROR", "el precio debe ser mayor a 500");
            return;
        }
        if(!ServicioService.getInstance().addServicio(nombre,precio1)){
            AlertMessage.show(Alert.AlertType.ERROR, "ERROR", "ya existe un servicio con ese nombre");
            return;
        }
        AlertMessage.show(Alert.AlertType.INFORMATION, "AGREGADO", "el servicio se a agregado correctamente");
    }

    public void handleVolver(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(DemoApplication.class.getResource("menu-usuario-view.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Menu");
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
