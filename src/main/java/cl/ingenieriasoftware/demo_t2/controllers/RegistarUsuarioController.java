package cl.ingenieriasoftware.demo_t2.controllers;

import cl.ingenieriasoftware.demo_t2.DemoApplication;
import cl.ingenieriasoftware.demo_t2.Util.AlertMessage;
import cl.ingenieriasoftware.demo_t2.entities.Usuario;
import cl.ingenieriasoftware.demo_t2.services.EscribirArchivoTexto;
import cl.ingenieriasoftware.demo_t2.services.UsuarioService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class RegistarUsuarioController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtContrasena;
    @FXML
    private TextField txtContrasena2;
    @FXML
    private TextField txtEdad;
    private ObservableList<Usuario> UsuarioList;

    /**
     * Método que permite registar usuario cuando se completan todos los campos requeridos
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleRegistrar(ActionEvent event) throws IOException {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String email = txtEmail.getText();
        String contrasena = txtContrasena.getText();
        String contrasena2 = txtContrasena2.getText();
        String edad = txtEdad.getText();
        if(nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contrasena.isEmpty() || contrasena2.isEmpty() || edad.isEmpty()){
            AlertMessage.show(Alert.AlertType.ERROR, "ERROR", "debes rellenar todos los campos");
            return;
        }
        int edad1;
        try {
            edad1 = Integer.parseInt(edad);
        } catch (NumberFormatException e) {

            AlertMessage.show(Alert.AlertType.ERROR, "ERROR", "la edad debe ser un numero");
            return;
        }
        if(!contrasena.equals(contrasena2)){
            AlertMessage.show(Alert.AlertType.ERROR, "ERROR", "ambas contraseñas deben ser iguales");
            return;
        }
        if(edad1 < 18 || edad1 > 65){
            AlertMessage.show(Alert.AlertType.ERROR, "ERROR", "el rango de edad no puede estar mal");
            return;
        }
        if(!UsuarioService.getInstance().addUsuario(nombre, apellido, email, contrasena,edad1)){
            AlertMessage.show(Alert.AlertType.ERROR, "ERROR", "este correo ya esta asociado a otra cuenta");
        }
        EscribirArchivoTexto.main(nombre,apellido,email,contrasena,edad1);
        FXMLLoader loader = new FXMLLoader(DemoApplication.class.getResource("iniciar-sesion-usuario-view.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Iniciar sesion");
        stage.show();


        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    /**
     * Método que permite volver a la interfaz anterior
     * @param event
     * @throws IOException
     */
    public void handleVolver(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(DemoApplication.class.getResource("iniciar-sesion-usuario-view.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Iniciar sesion");
        stage.show();


        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
