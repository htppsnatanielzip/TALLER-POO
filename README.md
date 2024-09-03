# Sistema de Gestión de Inventario

Este es un proyecto de Java para la gestión de inventarios de una tienda. El sistema permite agregar, modificar, eliminar y buscar productos, además de generar un listado detallado de todos los productos en el inventario.

## Características

- **Agregar Producto**: Puedes agregar productos generales, perecederos y no perecederos.
- **Modificar Producto**: Modifica la información de productos existentes.
- **Eliminar Producto**: Elimina productos del inventario utilizando su ID.
- **Buscar Producto**: Busca un producto por su ID y muestra su información.
- **Generar Listado**: Genera un listado completo de los productos en el inventario con todos sus detalles.

## Estructura del Proyecto

El proyecto está dividido en varios paquetes y clases:

- **Principal**:
  - `Local.java`: Es el punto de entrada del programa. Contiene el menú principal y maneja la interacción con el usuario.
  
- **Logica**:
  - `Producto.java`: Clase base para todos los productos.
  - `Perecedero.java`: Clase que extiende `Producto` para productos perecederos.
  - `NoPerecedero.java`: Clase que extiende `Producto` para productos no perecederos.
  - `GestorInventario.java`: Clase que gestiona la colección de productos en el inventario.

## Requisitos

- Java Development Kit (JDK) 8 o superior.
- [NetBeans](https://netbeans.apache.org/) o cualquier otro IDE compatible con proyectos Java.

## Instrucciones para Ejecutar

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/htppsnatanielzip/TALLER-POO.git
   ```
   
2. **Importar el proyecto en NetBeans**:
   - Abre NetBeans.
   - Ve a `File > Open Project`.
   - Selecciona la carpeta del proyecto clonado.

3. **Compilar y ejecutar**:
   - Ve a `Run > Clean and Build Project` para compilar el proyecto.
   - Luego, ve a `Run > Run Project` para ejecutarlo.

4. **Interacción con el programa**:
   - El programa mostrará un menú con las opciones disponibles.
   - Selecciona la opción deseada ingresando el número correspondiente.
   - Sigue las instrucciones en pantalla para agregar, modificar, eliminar o buscar productos.

## Detalles de Funcionalidades

### Agregar Producto

- Puedes agregar tres tipos de productos:
  1. **Producto General**: Solo requiere ID, nombre, precio y cantidad.
  2. **Producto Perecedero**: Además de los atributos generales, requiere fecha de caducidad y temperatura de almacenamiento.
  3. **Producto No Perecedero**: Además de los atributos generales, requiere un período de garantía en meses.

### Modificar Producto

- Puedes modificar el nombre, precio y cantidad de cualquier producto existente en el inventario.
- Al ingresar el ID de un producto, se te solicitará que ingreses los nuevos valores. Puedes dejar los campos en blanco para mantener los valores actuales.

### Eliminar Producto

- Elimina un producto del inventario ingresando su ID.

### Buscar Producto

- Busca un producto específico en el inventario utilizando su ID y muestra todos sus detalles.

### Generar Listado

- Genera y muestra un listado de todos los productos en el inventario, mostrando la información completa de cada uno.

###Aplicación de los Principios de Poo en este proyecto!

1. **Encapsulación**:

La encapsulación se utiliza para ocultar el estado interno de los objetos y exponer solo las funcionalidades necesarias a través de métodos públicos. En el proyecto:

Clases Producto, Perecedero y NoPerecedero: Los atributos como ID, Nombre, Precio, cantidadEnInventario están privados, y se accede a ellos a través de métodos getters y setters. Esto asegura que el estado de los objetos solo pueda ser modificado de manera controlada. Método mostrarInformacion(): Permite a las clases derivadas como Perecedero y NoPerecedero mostrar la información de manera adecuada, sin exponer directamente los atributos.

2. **Herencia**:

La herencia permite crear nuevas clases basadas en clases existentes, promoviendo la reutilización de código. En el proyecto:

Clase Producto: Es la clase base que define los atributos y métodos comunes para todos los tipos de productos. Clases Perecedero y NoPerecedero: Heredan de Producto y añaden atributos específicos (fechaDeCaducidad y temperaturaDeAlmacenamiento para Perecedero; MesDeGarantia para NoPerecedero). Esto evita la duplicación de código y permite extender la funcionalidad de la clase base.

3. **Polimorfismo**:

El polimorfismo permite a las clases derivadas proporcionar una implementación específica de métodos que ya están definidos en su clase base. En el proyecto:

Método mostrarInformacion(): En la clase base Producto y las clases derivadas Perecedero y NoPerecedero, este método se sobrescribe para proporcionar una implementación específica que muestra la información relevante de acuerdo con el tipo de producto. Esto permite tratar a todos los productos de manera uniforme a través de referencias de tipo Producto, mientras se accede a la información específica del tipo de producto.

4. **Abstracción**:

La abstracción permite simplificar la complejidad ocultando los detalles de implementación y mostrando solo las funcionalidades esenciales. En el proyecto:

Clase GestorInventario: Encapsula la lógica de gestión del inventario, como agregar, buscar, eliminar y modificar productos. Los usuarios del GestorInventario interactúan con estos métodos sin preocuparse por los detalles internos de cómo se manejan los productos. Interacción con Producto: A través de métodos como AgregarProducto y BuscarProducto, se facilita la manipulación de productos sin necesidad de conocer los detalles internos de cada tipo de producto.

## Contribuciones

Daniel Diaz (htppsnatanielzip)

## Licencia

Este proyecto está bajo la Licencia MIT. Para más detalles, consulta el archivo `LICENSE`.
