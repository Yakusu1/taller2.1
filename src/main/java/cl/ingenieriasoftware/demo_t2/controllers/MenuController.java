package cl.ingenieriasoftware.demo_t2.controllers;

import cl.ingenieriasoftware.demo_t2.DemoApplication;
import cl.ingenieriasoftware.demo_t2.services.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import cl.ingenieriasoftware.demo_t2.entities.Usuario;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private Button btnMenuAgregar;
    @FXML
    private Button btnMenuComprar;
    @FXML
    private Button btnMenuEditar;


    /**
     * Método que permite ingresar a la interfaz de compra de giftcard al accionar el botón comprar
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleComprar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(DemoApplication.class.getResource("comprar-giftcard-view.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Comprar");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    /**
     * Método que permite ingresar a la interfaz de agregar servicio
     * @param event
     * @throws IOException
     */
    public void HandleAgregar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(DemoApplication.class.getResource("agregar-servicio-view.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Agregar servicio");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    /**
     * Método que permite ingresar a la interfaz de editar servicio
     * @param event
     * @throws IOException
     */
    public void handleEditar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(DemoApplication.class.getResource("administrar-servicios-view.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("administrar servicio");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    /**
     * Método que oculta los botones al usuario si no tiene rol de administrador dentro del sistema
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("hola");
        Usuario activo = UsuarioService.getInstance().getUsuarioActivo();
        if(activo.getAdmin() == 0){
            btnMenuAgregar.setDisable(true);
            btnMenuEditar.setDisable(true);
        }
    }
}
