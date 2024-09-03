package Principal;

import Logica.Producto;
import Logica.Perecedero;
import Logica.NoPerecedero;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
        System.out.println("\nMenú de la tienda:");
        System.out.println("1. Agregar producto");
        System.out.println("2. Modificar producto");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Buscar producto");
        System.out.println("5. Generar lista detallada de productos");
        System.out.println("6. Salir");
    }

    private static int obtenerOpcion() {
        System.out.print("Seleccione una opción: ");
        return obtenerInt();
    }

    public static void agregarProducto() {
        System.out.println("\n¿Qué tipo de producto deseas agregar?");
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
        scanner.nextLine();  // Limpiar buffer de entrada

        System.out.print("Ingresa la cantidad en inventario: ");
        int cantidad = obtenerInt();
        scanner.nextLine();  // Limpiar buffer de entrada

        switch (tipo) {
            case 1:
                Producto productoGeneral = new Producto(id, nombre, precio, cantidad);
                gestorInventario.agregarProducto(productoGeneral);
                System.out.println("Producto general agregado exitosamente.");
                break;
            case 2:
            System.out.print("Ingresa la fecha de caducidad (yyyy-mm-dd): ");
            String fechaCaducidadStr = scanner.nextLine();
            LocalDate fechaCaducidad = parseFechaCaducidad(fechaCaducidadStr);  // Convertir a LocalDate
            System.out.print("Ingresa la temperatura de almacenamiento: ");
            double temperatura = obtenerDouble();

            Perecedero productoPerecedero = new Perecedero(id, nombre, precio, cantidad, fechaCaducidad, temperatura);
            gestorInventario.agregarProducto(productoPerecedero);
            break;
            case 3:
                System.out.print("Ingresa la garantía del producto en meses: ");
                int garantia = obtenerInt();
                scanner.nextLine();  // Limpiar buffer de entrada

                NoPerecedero productoNoPerecedero = new NoPerecedero(id, nombre, precio, cantidad, garantia);
                gestorInventario.agregarProducto(productoNoPerecedero);
                System.out.println("Producto no perecedero agregado exitosamente.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public static LocalDate parseFechaCaducidad(String fechaCaducidadStr) {
        try {
            return LocalDate.parse(fechaCaducidadStr);
        } catch (DateTimeParseException e) {
            System.out.println("Fecha no válida. Se usará la fecha actual por defecto.");
            return LocalDate.now(); // Puedes usar una fecha por defecto aquí
        }
    }

    private static void modificarProducto() {
        System.out.print("\nIngresa el ID del producto a modificar: ");
        int id = obtenerInt();  // Usa obtenerInt() para manejar errores de entrada
        scanner.nextLine();  // Limpiar buffer de entrada

        Producto productoExistente = gestorInventario.BuscarProducto(id);
        if (productoExistente != null) {
            // Solicitar nueva información
            System.out.println("Ingresa la nueva información del producto (deja en blanco para mantener el actual):");

            System.out.print("Ingresa el nuevo nombre del producto: ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.trim().isEmpty()) {
                productoExistente.setNombre(nuevoNombre);
            }

            System.out.print("Ingresa el nuevo precio del producto: ");
            String nuevoPrecioStr = scanner.nextLine();
            if (!nuevoPrecioStr.trim().isEmpty()) {
                try {
                    double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
                    productoExistente.setPrecio(nuevoPrecio);
                } catch (NumberFormatException e) {
                    System.out.println("Precio no válido. Se mantendrá el valor actual.");
                }
            }

            System.out.print("Ingresa la nueva cantidad en inventario: ");
            String nuevaCantidadStr = scanner.nextLine();
            if (!nuevaCantidadStr.trim().isEmpty()) {
                try {
                    int nuevaCantidad = Integer.parseInt(nuevaCantidadStr);
                    productoExistente.setCantidadEnInventario(nuevaCantidad);
                } catch (NumberFormatException e) {
                    System.out.println("Cantidad no válida. Se mantendrá el valor actual.");
                }
            }

            
            if (productoExistente instanceof Perecedero) {
                Perecedero perecedero = (Perecedero) productoExistente;

                System.out.print("Ingresa la nueva fecha de caducidad (yyyy-mm-dd): ");
                String nuevaFechaStr = scanner.nextLine();
                if (!nuevaFechaStr.trim().isEmpty()) {
                    LocalDate nuevaFecha = parseFechaCaducidad(nuevaFechaStr);
                    perecedero.setFechaDeCaducidad(nuevaFecha);
                }

                System.out.print("Ingresa la nueva temperatura de almacenamiento: ");
                String nuevaTempStr = scanner.nextLine();
                if (!nuevaTempStr.trim().isEmpty()) {
                    try {
                        double nuevaTemp = Double.parseDouble(nuevaTempStr);
                        perecedero.setTemperaturaDeAlmacenamiento(nuevaTemp);
                    } catch (NumberFormatException e) {
                        System.out.println("Temperatura no válida. Se mantendrá el valor actual.");
                    }
                }
            } else if (productoExistente instanceof NoPerecedero) {
                NoPerecedero noPerecedero = (NoPerecedero) productoExistente;

                System.out.print("Ingresa la nueva garantía del producto en meses: ");
                String nuevaGarantiaStr = scanner.nextLine();
                if (!nuevaGarantiaStr.trim().isEmpty()) {
                    try {
                        int nuevaGarantia = Integer.parseInt(nuevaGarantiaStr);
                        noPerecedero.setGarantia(nuevaGarantia);
                    } catch (NumberFormatException e) {
                        System.out.println("Garantía no válida. Se mantendrá el valor actual.");
                    }
                }
            }

            gestorInventario.modificarProducto(id, productoExistente);
            System.out.println("Producto modificado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void eliminarProducto() {
        System.out.print("\nIngresa el ID del producto a eliminar: ");
        int id = obtenerInt();
        scanner.nextLine();  // Limpiar buffer de entrada
        gestorInventario.eliminarProducto(id);
        System.out.println("Producto eliminado correctamente (si existía).");
    }

    private static void buscarProducto() {
        System.out.print("\nIngresa el ID del producto a buscar: ");
        int id = obtenerInt();
        scanner.nextLine();  // Limpiar buffer de entrada
        Producto producto = gestorInventario.BuscarProducto(id);
        if (producto != null) {
            producto.mostrarInformacion();
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void generarListado() {
        System.out.println("\nGenerando listado detallado de productos:");
        gestorInventario.generarInforme();
    }

    private static int obtenerInt() {
        while (true) {
            try {
                int numero = scanner.nextInt();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número entero.");
                scanner.next(); // Limpiar el buffer de entrada
            }
        }
    }

    private static double obtenerDouble() {
        while (true) {
            try {
                double numero = scanner.nextDouble();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número decimal.");
                scanner.next(); // Limpiar el buffer de entrada
            }
        }
    }
}
