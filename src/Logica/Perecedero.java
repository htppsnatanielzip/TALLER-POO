package Logica;

public class Perecedero extends Producto {

    private int fechaDeCaducidad;
    private double temperaturaDeAlmacenamiento;

    public Perecedero(int ID, String Nombre, double Precio, int cantidadEnInventario, int fechaDeCaducidad, double temperaturaDeAlmacenamiento) {
        super(ID, Nombre, Precio, cantidadEnInventario); // Llamada correcta al constructor de Producto
        this.fechaDeCaducidad = fechaDeCaducidad;
        this.temperaturaDeAlmacenamiento = temperaturaDeAlmacenamiento;
    }

    public int getFechaDeCaducidad() {
        return fechaDeCaducidad;
    }

    public double getTemperaturaDeAlmacenamiento() {
        return temperaturaDeAlmacenamiento;
    }

    public void setFechaDeCaducidad(int fechaDeCaducidad) {
        this.fechaDeCaducidad = fechaDeCaducidad;
    }

    public void setTemperaturaDeAlmacenamiento(double temperaturaDeAlmacenamiento) {
        this.temperaturaDeAlmacenamiento = temperaturaDeAlmacenamiento;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Fecha de vencimiento: " + fechaDeCaducidad);
        System.out.println("Temperatura del producto: " + temperaturaDeAlmacenamiento);
    }
}
