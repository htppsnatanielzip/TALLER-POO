package Principal;

import Logica.Producto;
import Logica.Perecedero;
import Logica.NoPerecedero;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Local {
    private static GestorInventario gestorInventario = new GestorInventario();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    modificarProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    buscarProducto();
                    break;
                case 5:
                    generarListado();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Menú de la tienda:");
        System.out.println("1. Agregar producto");
        System.out.println("2. Modificar producto");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Buscar producto");
        System.out.println("5. Generar lista detallada de productos");
        System.out.println("6. Salir");
    }

    private static int obtenerOpcion() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }
    
    

public static void agregarProducto() {
    System.out.println("¿Qué tipo de producto deseas agregar?");
    System.out.println("1. Producto general");
    System.out.println("2. Producto perecedero");
    System.out.println("3. Producto no perecedero");
    int tipo = obtenerInt();

    System.out.print("Ingresa el ID del producto (número entero): ");
    int id = obtenerInt();
    scanner.nextLine();  // Limpiar buffer de entrada
    System.out.print("Ingresa el nombre del producto: ");
    String nombre = scanner.nextLine();
    System.out.print("Ingresa el precio del producto: ");
    double precio = obtenerDouble();
    System.out.print("Ingresa la cantidad en inventario: ");
    int cantidad = obtenerInt();

    switch (tipo) {
        case 1:
            Producto productoGeneral = new Producto(id, nombre, precio, cantidad);
            gestorInventario.agregarProducto(productoGeneral);
            break;
        case 2:
            System.out.print("Ingresa la fecha de caducidad (yyyy-mm-dd): ");
            String fechaCaducidadStr = scanner.nextLine();
            // Aquí deberías parsear la fecha de caducidad a un formato adecuado, por ejemplo:
            // LocalDate fechaCaducidad = LocalDate.parse(fechaCaducidadStr);
            int fechaCaducidad = 20251115; // Simplificación para el ejemplo

            System.out.print("Ingresa la temperatura de almacenamiento: ");
            double temperatura = obtenerDouble();

            Perecedero productoPerecedero = new Perecedero(id, nombre, precio, cantidad, fechaCaducidad, temperatura);
            gestorInventario.agregarProducto(productoPerecedero);
            break;
        case 3:
            System.out.print("Ingresa el ID del producto: ");
            int idNoPerecedero = obtenerInt();
            scanner.nextLine();  // Limpiar buffer de entrada
            System.out.print("Ingresa el nombre del producto: ");
            String nombreNoPerecedero = scanner.nextLine();
            System.out.print("Ingresa el precio del producto: ");
            double precioNoPerecedero = obtenerDouble();
            System.out.print("Ingresa la cantidad en inventario: ");
            int cantidadNoPerecedero = obtenerInt();
            System.out.print("Ingresa la garantía del producto en meses: ");
            int garantia = obtenerInt();

            NoPerecedero productoNoPerecedero = new NoPerecedero(idNoPerecedero, nombreNoPerecedero, precioNoPerecedero, cantidadNoPerecedero, garantia);
            gestorInventario.agregarProducto(productoNoPerecedero);
            break;
        default:
            System.out.println("Opción no válida.");
            break;
    }
}




    private static void modificarProducto() {
    System.out.print("Ingresa el ID del producto a modificar: ");
    int id = obtenerInt();  // Usa obtenerInt() para manejar errores de entrada

    Producto productoExistente = gestorInventario.BuscarProducto(id);
    if (productoExistente != null) {
        // Solicitar nueva información
        System.out.println("Ingresa la nueva información del producto:");

        System.out.print("Ingresa el nuevo nombre del producto (o presiona Enter para mantener el actual): ");
        scanner.nextLine();  // Limpiar buffer de entrada
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.isEmpty()) {
            productoExistente.setNombre(nuevoNombre);
        }

        System.out.print("Ingresa el nuevo precio del producto (o presiona Enter para mantener el actual): ");
        String nuevoPrecioStr = scanner.nextLine();
        if (!nuevoPrecioStr.isEmpty()) {
            try {
                double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
                productoExistente.setPrecio(nuevoPrecio);
            } catch (NumberFormatException e) {
                System.out.println("Precio no válido. Se mantendrá el valor actual.");
            }
        }

        System.out.print("Ingresa la nueva cantidad en inventario (o presiona Enter para mantener el actual): ");
        String nuevaCantidadStr = scanner.nextLine();
        if (!nuevaCantidadStr.isEmpty()) {
            try {
                int nuevaCantidad = Integer.parseInt(nuevaCantidadStr);
                productoExistente.setCantidadEnInventario(nuevaCantidad);
            } catch (NumberFormatException e) {
                System.out.println("Cantidad no válida. Se mantendrá el valor actual.");
            }
        }

        // Para productos perecederos o no perecederos, puedes añadir lógica adicional aquí

        gestorInventario.modificarProducto(id, productoExistente);
        System.out.println("Producto modificado correctamente.");
    } else {
        System.out.println("Producto no encontrado.");
    }
}


    private static void eliminarProducto() {
        System.out.print("Ingresa el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        gestorInventario.eliminarProducto(id);
    }

    private static void buscarProducto() {
        System.out.print("Ingresa el ID del producto a buscar: ");
        int id = scanner.nextInt();
        Producto producto = gestorInventario.BuscarProducto(id);
        if (producto != null) {
            producto.mostrarInformacion();
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void generarListado() {
        gestorInventario.generarInforme();
    }
    
    private static int obtenerInt() {
    while (true) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor ingrese un número entero.");
            scanner.next(); // Limpiar el buffer de entrada
        }
    }
}

   private static double obtenerDouble() {
    while (true) {
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor ingrese un número decimal.");
            scanner.next(); // Limpiar el buffer de entrada
        }
    }
}

}
