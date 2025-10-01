package utils;

import co.edu.uniquindio.fx10.App;
import co.edu.uniquindio.fx10.controllers.DashboardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
            expandir(dashboard);
            contenedorPrincipal.getChildren().add(dashboard);

        } catch (IOException e) {
            AlertHelper.mostrarAlerta("Error", "No se pudo volver al dashboard", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
    public static void cargarVista(DashboardController dashboardController, String rutaFxml){
        try{
            FXMLLoader loader = new FXMLLoader(App.class.getResource(rutaFxml));
            Parent vista = loader.load();

            Object controller = loader.getController();
            if(controller instanceof DashboardAware aware){
                aware.setDashboardController(dashboardController);
                aware.setContenedorPrincipal(dashboardController.getContenedorPrincipal());
            }

            var contenedor = dashboardController.getContenedorPrincipal();
            expandir(vista);
            contenedor.getChildren().setAll(vista);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void expandir(Node nodo){
        HBox.setHgrow(nodo, Priority.ALWAYS);
        VBox.setVgrow(nodo, Priority.ALWAYS);
    }
}
