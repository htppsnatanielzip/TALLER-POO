package Logica;

import java.time.LocalDate;

public class Perecedero extends Producto {

    private LocalDate fechaDeCaducidad;
    private double temperaturaDeAlmacenamiento;

    public Perecedero(int ID, String Nombre, double Precio, int cantidadEnInventario, LocalDate fechaDeCaducidad, double temperaturaDeAlmacenamiento) {
        super(ID, Nombre, Precio, cantidadEnInventario);
        this.fechaDeCaducidad = fechaDeCaducidad;
        this.temperaturaDeAlmacenamiento = temperaturaDeAlmacenamiento;
    }

    public LocalDate getFechaDeCaducidad() {
        return fechaDeCaducidad;
    }

    public double getTemperaturaDeAlmacenamiento() {
        return temperaturaDeAlmacenamiento;
    }

    public void setFechaDeCaducidad(LocalDate fechaDeCaducidad) {
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

