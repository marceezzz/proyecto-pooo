package scr;
import java.util.ArrayList;

// Atributos
public class Pedido {
  private Cliente cliente; // Lo estoy relacionando directamente con la clase cliente
  private ArrayList<ItemPedido> items;
  private boolean finalizado; // si el pedido esta finalizado o esta en curso

  public Pedidos {
    this.cliente = cliente;
    this.items = new ArrayList<>();
    this.finalizado = false;
  }

  //getters
  public Clientes getCliente() { return cliente; }
  public ArrayList<ItemPedido> getItems() { return items;}
  public boolean getfinalizado() { return finalizado; }
  
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

    // por si se pide el mismo ya solo se suma la cantidad
      for (ItemPedido item : items) {
           if (item.getProducto() == elegido) {
               item.sumarCantidad(cantidad);
               return true;
            }
        }
   items.add(new ItemPedido(elegido, cantidad));
        return true;
    }
 
    // suma los subtotales de todas las líneas
    public int calcularTotal() {
        int total = 0;
        for (ItemPedido item : items) {
            total += item.getSubtotal();
        }
        return total;
    }
 
    // cierra el pedido y libera la mesa del cliente
    public void finalizar() {
        if (finalizado) {
            return;
        }
        finalizado = true;
        cliente.liberarMesa();
    }
 
    // resumen del pedido para mostrar en consola
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|Pedido de ").append(cliente.getNombre()).append("|\n");
 
        if (cliente.getMesa() != null) {
            sb.append("Mesa: ").append(cliente.getMesa().getNumero()).append("\n");
        }
 
        if (items.isEmpty()) {
            sb.append("(sin productos)\n");
        } else {
            for (ItemPedido item : items) {
                sb.append(item).append("\n");
            }
        }
 
        sb.append("Total: ").append(calcularTotal()).append("\n");
        sb.append("Estado: ").append(finalizado ? "Finalizado" : "Abierto");
        return sb.toString();
    }
}
