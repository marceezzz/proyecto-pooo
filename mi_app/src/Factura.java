package src;

public class Factura {
    private String metodo;
    private Pedido pedido;
    private int numeroFactura;
    private double totalPagado;

//Constructor
public Factura(Pedido pedido, int metodo, int numeroFactura, double totalPagado){
    if (metodo == 1)
        this.metodo = "Efectivo";  
    else
        this.metodo = "Tarjeta";

    this.pedido = pedido;
    this.numeroFactura = numeroFactura;
    this.totalPagado = totalPagado;
}

//Getters
public String getMetodo(){
    return metodo;
}   
public Pedido getPedido(){
    return pedido;
}
public int getNumeroFactura(){
    return numeroFactura;
}

//Regresa la informacion de la factura
public void MostrarFactura(){
    System.out.println("|Factura #" + numeroFactura + "|");
    System.out.println( pedido.getCliente());
    System.out.println("\nProductos comprados: \n");
    for (Producto p : pedido.getItems()){
        System.out.println(p);
    }
    System.out.println("Metodo de pago: " + metodo);
    System.out.println("Total pagado: $" + totalPagado + "\n");
}
}


