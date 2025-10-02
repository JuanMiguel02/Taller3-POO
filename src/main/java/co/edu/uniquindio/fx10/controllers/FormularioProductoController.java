package co.edu.uniquindio.fx10.controllers;

import co.edu.uniquindio.fx10.models.Producto;
import co.edu.uniquindio.fx10.repositories.ProductoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import utils.DashboardAware;

import static utils.AlertHelper.mostrarAlerta;
import static utils.SceneNavigator.cargarDashboard;

/**
 * Controlador para el formulario de creación de productos
 */
public class FormularioProductoController implements DashboardAware {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtStock;

    @FXML private HBox contenedorPrincipal;

    private ProductoRepository productoRepository;
    private ListadoProductoController listadoProductoController;
    private DashboardController dashboardController;

    @FXML
    public void initialize() {
        productoRepository = ProductoRepository.getInstancia();
    }

    /**
     * Maneja el evento de guardar producto
     */

    @FXML
    private void onGuardarProducto() {
        if (!validarCampos()) {
            return;
        }

        try {
            String codigo = txtCodigo.getText().trim();
            String nombre = txtNombre.getText().trim();
            String descripcion = txtDescripcion.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int stock = Integer.parseInt(txtStock.getText().trim());

            // Verificar si el código ya existe
            if (productoRepository.buscarPorCodigo(codigo) != null) {
                mostrarAlerta("Error", "Ya existe un producto con ese código", Alert.AlertType.ERROR);
                return;
            }

            // Crear y guardar el producto
            Producto nuevoProducto = new Producto(codigo, nombre, descripcion, precio, stock);
            productoRepository.agregarProducto(nuevoProducto);

            mostrarAlerta("Éxito", "Producto creado correctamente", Alert.AlertType.INFORMATION);
            
            // Volver al dashboard
            volverAlDashboard();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El precio y stock deben ser valores numéricos válidos", Alert.AlertType.ERROR);
        }
    }

    /**
     * Maneja el evento de cancelar
     */
    @FXML
    private void onCancelar() {
        volverAlDashboard();
    }

    /**
     * Vuelve a mostrar el dashboard
     */
    private void volverAlDashboard() {
        //Llama al metodo que carga el dashboard principal
       cargarDashboard(contenedorPrincipal);
    }

    /**
     * Valida que los campos del formulario estén completos
     */
    private boolean validarCampos() {
        if (txtCodigo.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El código es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtNombre.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El nombre es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtDescripcion.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "La descripción es obligatoria", Alert.AlertType.WARNING);
            return false;
        }
        if (txtPrecio.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El precio es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtStock.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El stock es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }


    @Override
    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }
    @Override
    public void setContenedorPrincipal(HBox contenedorPrincipal){
        this.contenedorPrincipal = contenedorPrincipal;
    }

}

