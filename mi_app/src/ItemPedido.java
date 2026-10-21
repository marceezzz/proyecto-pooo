package src;


public class ItemPedido {
    // atributos
    private Producto producto;
    private int cantidad;

    // constructor
    public ItemPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // getters
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    // suma unidades cuando el mismo producto se vuelve a pedir
    public void sumarCantidad(int extra) {
        this.cantidad += extra;
    }

    // precio del producto por la cantidad pedida
    public int getSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return cantidad + "x " + producto.getNombre() + " - " + getSubtotal();
    }
}
