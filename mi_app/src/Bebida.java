package src;

public class Bebida extends Producto {
    private boolean alcoholica;

    public Bebida(String nombre, int precio, int cantidad, boolean alcoholica) {
        super(nombre, precio, cantidad);
        this.alcoholica = alcoholica;
    }

    @Override
    public int CalcularTotal() {
        int total = getPrecio() * getCantidad();
        if (alcoholica) {
            total = total + total * 10 / 100;
        }
        return total;
    }

    @Override
    public String getCategoria() {
        return alcoholica ? "Bebida alcoholica" : "Bebida";
    }

    @Override
    public Producto copiar(int cantidad) {
        return new Bebida(getNombre(), getPrecio(), cantidad, alcoholica);
    }
}