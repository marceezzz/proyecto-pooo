package src;

// Atributos
public class Pedido {
  private Cliente cliente; // Lo estoy relacionando directamente con la clase cliente
  private Producto[] items; //Lista de productos para comprar
  private boolean finalizado; // si el pedido esta finalizado o esta en curso

  public Pedido (Cliente cliente) {
    this.cliente = cliente;
    this.items = new Producto[0];
    this.finalizado = false;
  }

  //getters
  public Cliente getCliente() { return cliente; }
  public Producto[] getItems() { return items;}
  public boolean getfinalizado() { return finalizado; }
  
//aqui hice un metodo para poder escoger los productos dentro de las opciones del menu
  public boolean agregarDesdeMenu(Producto[] menu, int opcion, int cantidad) {
    if (finalizado) {
        System.out.println("El pedido ya está finalizado, no se pueden agregar productos.");
        return false;
      }
    if (opcion < 1 || opcion > menu.length) {
        System.out.println("Opción no válida");
        return false;
      }
    if (cantidad < 1) {
        System.out.println("La cantidad debe ser al menos 1");
        return false;
        }
    
    Producto elegido = menu[opcion - 1];

    if (elegido.getCantidad() < cantidad){
        System.out.println("La cantidad ingresada es mayor a la que tenemos en el inventario");
        return false;
    }

    elegido.RestarCantidad(cantidad);
    // por si se pide el mismo ya solo se suma la cantidad
      for (Producto item : items) {
        
           if (item.getNombre().equals(elegido.getNombre())){
               item.SumarCantidad(cantidad);
               return true;
            }
        }
    
    items = java.util.Arrays.copyOf(items, items.length + 1);
    items[items.length - 1] = new Producto(elegido, cantidad);
        return true;}
    
    
    public void ProductosEscogidos(){
        System.out.println("|Pedido|");
        for (Producto p : items){
            System.out.println(p);
        }
        System.out.println("Total: $" + calcularTotal() + "\n");
    }

    // suma los subtotales de todas las líneas
    public int calcularTotal() {
        int total = 0;
        for (Producto item : items) {
            total += item.CalcularTotal();
        }
        return total;
    }

    //Termina el pedido
    public void PedidoFinalizado(){finalizado = true;}

    // las impresiones
public void Mostrar() {
    System.out.println("|Pedido de " + cliente.getNombre() + "|");

    if (cliente.getMesa() != null) {
        System.out.println("Mesa: " + cliente.getMesa().getNumero());
    }

    if (items.length == 0) {
        System.out.println("(sin productos)");
    } else {
        for (Producto item : items) {
            System.out.println(item);
        }
    }

    System.out.println("Total: $" + calcularTotal() + "\n");

}
}
