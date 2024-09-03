package Principal;

import Logica.Producto;
import java.util.ArrayList;

public class GestorInventario {
    private ArrayList<Producto> Productos;

    public GestorInventario() {
        Productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        Productos.add(producto);
        System.out.println("Producto agregado correctamente.");
    }

    public void modificarProducto(int id, Producto nuevoProducto) {
        for (int i = 0; i < Productos.size(); i++) {
            if (Productos.get(i).getID() == id) {
                Productos.set(i, nuevoProducto);
                System.out.println("Producto modificado correctamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void eliminarProducto(int id) {
        Productos.removeIf(producto -> producto.getID() == id);
        System.out.println("Producto eliminado correctamente.");
    }

    public Producto BuscarProducto(int ID) {
        for (Producto producto_tienda : Productos) {
            if (producto_tienda.getID() == ID)
                return producto_tienda;
        }
        return null;
    }

    public void generarInforme() {
        System.out.println("Informe de inventario:");
        for (Producto producto : Productos) {
            producto.mostrarInformacion();
        }
    }
}


