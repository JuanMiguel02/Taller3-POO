package utils;

import co.edu.uniquindio.fx10.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SceneNavigator {

    /**
     * Vuelve a mostrar el dashboard
     */
    public static void cargarDashboard(HBox contenedorPrincipal) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/co/edu/uniquindio/fx10/vista/Dashboard.fxml"));
            Parent dashboard = loader.load();

            contenedorPrincipal.getChildren().clear();
            contenedorPrincipal.getChildren().add(dashboard);

        } catch (IOException e) {
            AlertHelper.mostrarAlerta("Error", "No se pudo volver al dashboard", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
}
