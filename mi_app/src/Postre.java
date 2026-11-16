package src;

public class Postre extends Producto {

    public Postre(String nombre, int precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public int CalcularTotal() {
        int total = getPrecio() * getCantidad();
        if (getCantidad() >= 3) {
            total = total - total * 10 / 100;
        }
        return total;
    }

    @Override
    public String getCategoria() { return "Postre"; }

    @Override
    public Producto copiar(int cantidad) {
        return new Postre(getNombre(), getPrecio(), cantidad);
    }
}