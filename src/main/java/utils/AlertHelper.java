package utils;

import javafx.scene.control.Alert;

public abstract class AlertHelper {
    /*
    *Clase que contieene el metodo para mostrar alertas desde cualquier otra clase
    */

    public static void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
