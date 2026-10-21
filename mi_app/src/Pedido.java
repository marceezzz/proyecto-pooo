package src;
import java.util.ArrayList;

// Atributos
public class Pedido {
  private Cliente cliente; // Lo estoy relacionando directamente con la clase cliente
  private ArrayList<Producto> items; //Lista de productos para comprar
  private boolean finalizado; // si el pedido esta finalizado o esta en curso

  public Pedido (Cliente cliente) {
    this.cliente = cliente;
    this.items = new ArrayList<>();
    this.finalizado = false;
  }

  //getters
  public Cliente getCliente() { return cliente; }
  public ArrayList<Producto> getItems() { return items;}
  public boolean getfinalizado() { return finalizado; }

  //setters
  public void PedidoFinalizado(){finalizado = true;}
  
//aqui hice un metodo para poder escoger los productos dentro de las opciones del menu
  public boolean agregarDesdeMenu(ArrayList<Producto> menu, int opcion, int cantidad) {
    if (finalizado) {
        System.out.println("El pedido ya está finalizado, no se pueden agregar productos.");
        return false;
      }
    if (opcion < 1 || opcion > menu.size()) {
        System.out.println("Opción no válida");
        return false;
      }
    if (cantidad < 1) {
        System.out.println("La cantidad debe ser al menos 1");
        return false;
        }
    
    Producto elegido = menu.get(opcion - 1);

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
    
    items.add(new Producto(elegido, cantidad));
        return true;}
    
    
    public void ProductosEscogidos(){
        System.out.println("|Pedido|");
        for (Producto p : items){
            System.out.println(p);
        }
        System.out.println("Total: " + calcularTotal() + "\n");
    }

    // suma los subtotales de todas las líneas
    public int calcularTotal() {
        int total = 0;
        for (Producto item : items) {
            total += item.CalcularTotal();
        }
        return total;
    }
}
    /* 
    // cierra el pedido y libera la mesa del cliente
    public void finalizar() {
        if (finalizado) {
            return;
        }
        finalizado = true;
        cliente.liberarMesa();
    }
 
    // las impresiones
public void mostrar() {
    System.out.println("|Pedido de " + cliente.getNombre() + "|");

    if (cliente.getMesa() != null) {
        System.out.println("Mesa: " + cliente.getMesa().getNumero());
    }

    if (items.isEmpty()) {
        System.out.println("(sin productos)");
    } else {
        for (ItemPedido item : items) {
            System.out.println(item);
        }
    }

    System.out.println("Total: " + calcularTotal());

    if (finalizado) {
        System.out.println("Estado: Finalizado");
    } else {
        System.out.println("Estado: Abierto");
    }
}
}
*/