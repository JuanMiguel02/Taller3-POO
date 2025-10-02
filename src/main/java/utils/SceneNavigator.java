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

public abstract class SceneNavigator {

    /**
     * Carga la vista principal del Dashboard en el contenedor especificado.
     *
     * Este método reemplaza cualquier contenido actual del contenedor
     * por el layout definido en {@Dashboard.fxml}. Además ajusta
     * el nodo cargado para que se expanda y ocupe todo el espacio disponible.</p>
     *
     * @param contenedorPrincipal contenedor (generalmente un {HBox}) donde se cargará el Dashboard.
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

    /**
     * Carga dinámicamente una vista en el contenedor principal del Dashboard.
     * Este método reemplaza el contenido actual del contenedor principal
     * por la vista definida en el archivo FXML especificado. Si el controlador
     * de la vista implementa la interfaz {@link DashboardAware}, se inyectan
     * el {DashboardController} y el contenedor principal para permitir
     * comunicación entre la vista y el Dashboard.</p>
     *
     * @param dashboardController controlador principal del Dashboard que actúa como contexto de navegación.
     * @param rutaFxml ruta al archivo FXML de la vista que se desea cargar.
     * @throws RuntimeException si ocurre un error al cargar el archivo FXML.
     */
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

    /*
    *   Método para expandir las ventanas de modo que conserven proporción
    */
    private static void expandir(Node nodo){
        HBox.setHgrow(nodo, Priority.ALWAYS);
        VBox.setVgrow(nodo, Priority.ALWAYS);
    }
}
