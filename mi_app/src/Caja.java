package src;
 
// Esta clase registra los cobros del dia y acumula todo los pagos hasta el cierre
public class Caja {
 
  //Atributos
  private double ventasDeldia ;
  private int pedidosAtendidos ;
  private double totalEfectivo ;
  private double totalTarjeta  ;
  private double recargosCobrados ;
 
  //Constructor , la caja inicia en 0
  public Caja() {
    this.ventasDeldia = 0.0 ;
    this.pedidosAtendidos = 0 ;
    this.totalEfectivo = 0.0 ;
    this.totalTarjeta = 0.0 ;
    this.recargosCobrados = 0.0 ;
  }
 
  // Getters
  public double getVentasDeldia(){
    return this.ventasDeldia ;
  }
 
  public int getPedidosAtendidos(){
    return this.pedidosAtendidos ;
  }
 
  public double getTotalEfectivo(){
    return this.totalEfectivo ;
  }
 
  public double getTotalTarjeta(){
    return this.totalTarjeta ;
  }
 
  public double getRecargosCobrados(){
    return this.recargosCobrados ;
  }
 
  //Setters : No hay setters ya que estos solo cambian a partir del metodo registrarVenta , para evitar que se altere la caja
 
  //Metodos
 
  //calcularTotal = retorna lo que debe pagar el cliente o -1 si es invalido
  public double calcularTotal (double subtotal , int metodo){
    final int EFECTIVO  = 1 ;
    final int TARJETA = 2 ;
    final int RECARGO_TARJETA = 5 ;
 
    if (subtotal <= 0 ) {
      return -1.0 ;
    }
 
    if  (metodo == EFECTIVO ) {
      return subtotal;
    } else if (metodo == TARJETA){
      double recargo = subtotal * RECARGO_TARJETA / 100.0 ;
      return subtotal + recargo ;
    } else {
      return -1.0 ;
    }
  }
 
  //registrarVenta = retorna el total cobrado o -1 si es invalido
  public double registrarVenta (double subtotal , int metodo){
    final int EFECTIVO = 1 ;
 
    double total = calcularTotal (subtotal , metodo) ;
    if (total == -1.0 ) {
      return -1.0 ;
    }
    this.ventasDeldia = this.ventasDeldia + total ;
    this.pedidosAtendidos = this.pedidosAtendidos + 1 ;
    if (metodo == EFECTIVO ) {
      this.totalEfectivo = this.totalEfectivo + total ;
    } else {
      this.totalTarjeta = this.totalTarjeta + total ;
      this.recargosCobrados = this.recargosCobrados + (total - subtotal) ;
    }
    return total ;
  }
 
  //resumen
  public String resumen () {
return "Pedidos atendidos: " + this.pedidosAtendidos + " \nVendidos : $" + this.ventasDeldia + "\nEfectivo: $" + this.totalEfectivo + "\nTarjeta: $" + this.totalTarjeta + "\nRecargos: $" + this.recargosCobrados + "\n";
  }
 
  //toString = informacion principal de la caja
  public String toString() {
    return "Caja - ventas del dia: $" + this.ventasDeldia + ", pedidos atendidos: " + this.pedidosAtendidos ;
  }
}
