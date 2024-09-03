package Logica;

public class NoPerecedero extends Producto {
    private int garantia;

  
    public NoPerecedero(int id, String nombre, double precio, int cantidadEnInventario, int garantia) {
        super(id, nombre, precio, cantidadEnInventario);
        this.garantia = garantia;
    }

   
    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Garantía: " + garantia + " meses");
    }
}