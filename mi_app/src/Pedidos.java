package scr;
import java.util.ArrayList;

// Atributos
public class Pedidos {
  private Cliente cliente; // Lo estoy relacionando directamente con la clase cliente
  private ArrayList<ProductosPedidos> productosPedidos;
  private boolean finalizado; // si el pedido esta finalizado o esta en curso

  public Pedidos {
    this.cliente = cliente;
    this.productosPedidos = new ArrayList<>();
    this.finalizado = false;
  }

  //getters
  public Clientes getCliente() { return cliente; }
  public ArrayList<ProductosPedidos> getproductosPedidos() { return productosPedidos;}
  public boolean getfinalizado() { return finalizado; }
}
