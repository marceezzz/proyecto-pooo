package src;

public class Plato extends Producto {

    public Plato(String nombre, int precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public int CalcularTotal() {
        return getPrecio() * getCantidad();
    }

    @Override
    public String getCategoria() { return "Plato"; }

    @Override
    public Producto copiar(int cantidad) {
        return new Plato(getNombre(), getPrecio(), cantidad);
    }
}