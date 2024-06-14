package cl.ingenieriasoftware.demo_t2.Util;

import javafx.scene.control.Alert;

public class AlertMessage {

    public static void show(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
