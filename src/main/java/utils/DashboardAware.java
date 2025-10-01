package utils;

import co.edu.uniquindio.fx10.controllers.DashboardController;
import javafx.scene.layout.HBox;

public interface DashboardAware {
    void setDashboardController(DashboardController dashboardController);
    void setContenedorPrincipal(HBox contenedorPrincipal);

}
