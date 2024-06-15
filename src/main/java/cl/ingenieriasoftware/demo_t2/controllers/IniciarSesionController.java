package cl.ingenieriasoftware.demo_t2.controllers;

import cl.ingenieriasoftware.demo_t2.DemoApplication;
import cl.ingenieriasoftware.demo_t2.Util.AlertMessage;
import cl.ingenieriasoftware.demo_t2.entities.CreditCard;
import cl.ingenieriasoftware.demo_t2.entities.Usuario;
import cl.ingenieriasoftware.demo_t2.services.ApiService;
import cl.ingenieriasoftware.demo_t2.services.CreditCardService;
import cl.ingenieriasoftware.demo_t2.services.UsuarioService;
import cl.ingenieriasoftware.demo_t2.services.leerArchivoRegistros;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class IniciarSesionController {
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtContrasena;
    private ObservableList<Usuario> UsuarioList;
    @FXML
    private void handleIngresar(ActionEvent event) throws IOException {
        leerArchivoRegistros.main();
        String email = txtEmail.getText();
        String contrasena = txtContrasena.getText();
        if (email.isEmpty() || contrasena.isEmpty()) {
            AlertMessage.show(Alert.AlertType.ERROR, "ERROR", "debes rellenar todos los campos");
            return;
        }
        if (!UsuarioService.getInstance().getUsuario(email, contrasena)) {
            AlertMessage.show(Alert.AlertType.ERROR, "ERROR", "correo o contraseña incorrecto");
            return;
        }
        UsuarioService.getInstance().getUsuarioC(email).setActivo(true);
        FXMLLoader loader = new FXMLLoader(DemoApplication.class.getResource("menu-usuario-view.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Menu");
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    public void handleRegistrar(ActionEvent event) throws IOException {
        leerArchivoRegistros.main();
        FXMLLoader loader = new FXMLLoader(DemoApplication.class.getResource("registrar-usuario-view.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Registrarse");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
