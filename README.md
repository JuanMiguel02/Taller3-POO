# Sistema de Gestión de Productos - JavaFX

Sistema de gestión de productos desarrollado con JavaFX que permite crear, listar y eliminar productos.

## 🚀 Características

- **Dashboard principal** que permite ver y guardar productos
- **Listado de productos** representado en una tabla organizada
- **Formulario de creación** de productos
- **Navegación dinámica** entre vistas
- **Gestión centralizada** de datos con patrón Singleton
- **Interfaz moderna** y responsive

## 📋 Requisitos

- Java 17 o superior
- Maven 3.6 o superior

## 🛠️ Instalación y Ejecución

### Compilar el proyecto

```bash
mvn clean compile
```

### Ejecutar la aplicación

```bash
mvn javafx:run
```

## 📁 Estructura del Proyecto

```
fx10/
├── src/
│   └── main/
│       ├── java/
│       │   ├── module-info.java
│       │   └── co/edu/uniquindio/fx10/
│       │       ├── App.java                          # Clase principal
│       │       ├── models/
│       │       │   └── Producto.java                 # Modelo de datos
│       │       ├── repositories/
│       │       │   └── ProductoRepository.java       # Gestión del ArrayList
│       │       └── controllers/
│       │           ├── DashboardController.java          # Controlador del dashboard
│       │           └── FormularioProductoController.java # Controlador del formulario
│       │           └── ListadoProductoController.java    # Controlador de la tabla de productos
│       │       └── utils/
│       │           ├── AlertHelper.java                  # Métodos para crear alertas 
│       │           └── SceneNavigator.java               # Métodos para cambiar entre escenas
│       │           └── DashboardAware.java               # Métodos para establecer el controlador del Dashboard
│       └── resources/
│           └── co/edu/uniquindio/fx10/vista/
│               ├── Dashboard.fxml                    # Vista del dashboard
│               └── FormularioProducto.fxml           # Vista del formulario
│               └── ListadoProducto.fxml              # Vista de la tabla
│           └── images/
│               └── diseno-de-producto.png            # Imagen usada para el dashboard
└── pom.xml                                           # Configuración Maven
```

## 💡 Uso

### Dashboard Principal

- Ventana principal con menú de opciones
- Haz clic en "Añadir Nuevo Producto" para agregar un nuevo producto
- Selecciona "Ver Productos" para desplegar la tabla de productos


### Crear Producto

1. Haz clic en el botón "Crear Producto"
2. Completa todos los campos del formulario:
   - Código (único)
   - Nombre
   - Descripción
   - Precio
   - Stock
3. Haz clic en "Guardar Producto" o "Cancelar"

### Crear Producto
- Selecciona un producto y haz clic en "Eliminar Producto" para eliminarlo

## 🏗️ Arquitectura

### Patrón Singleton
El `ProductoRepository` utiliza el patrón Singleton para garantizar que existe una única instancia del ArrayList de productos en toda la aplicación.

### Separación de Capas
- **Modelo**: Clase `Producto` con los atributos del negocio
- **Repositorio**: Gestión centralizada de los datos
- **Utilis**: Métodos auxiliares que permiten la reutilización
- **Controlador**: Lógica de negocio y coordinación entre vista y modelo
- **Vista**: Archivos FXML con la interfaz de usuario

## 🎨 Características de la Interfaz

- Diseño moderno con colores profesionales
- Efectos de sombra y bordes redondeados
- Tabla responsive con formato de moneda en precios
- Validación de campos del formulario
- Mensajes de confirmación y error

## 📦 Datos de Ejemplo

La aplicación incluye 3 productos de ejemplo:
- Laptop Dell
- Mouse Logitech
- Teclado Mecánico

## 🔧 Tecnologías Utilizadas

- **JavaFX 21**: Framework de interfaz gráfica
- **Java 17**: Lenguaje de programación
- **Maven**: Gestión de dependencias y compilación
- **FXML**: Diseño de interfaces

## 👨‍💻 Autor

- Proyecto desarrollado para el curso de Programación 1 - Universidad del Quindío
- Actualizado por Juan Miguel Henao

