package co.edu.uniquindio.fx10.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import static utils.SceneNavigator.cargarVista;

/**
 * Controlador para el Dashboard principal
 */
public class DashboardController {

    @FXML
    private HBox contenedorPrincipal;

    /**
     * Maneja los eventos para cargar las otras ventanas
     */
    @FXML
    private void onCargarFormulario() {
        //llama al metodo que carga las vistas
        cargarVista(this, "/co/edu/uniquindio/fx10/vista/FormularioProducto.fxml");

    }
    @FXML
    private void onVerLista() {
        cargarVista(this, "/co/edu/uniquindio/fx10/vista/ListadoProducto.fxml");
    }

    public HBox getContenedorPrincipal() {
        return contenedorPrincipal;
    }

}

