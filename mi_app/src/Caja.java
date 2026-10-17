// Esta clase registra los cobros del dia y acumula todo los pagos hasta el cierre 
public class Caja {

  //Atributos
  private int ventasDeldia ;
  private int pedidosAtendidos ;
  private int totalEfectivo ;
  private int totalTarjeta  ; 
  private int recargosCobrados ; 

  //Constructor , la caja inicia en 0 
  public Caja() {
    this.ventasDeldia = 0 ;
    this.pedidosAtendidos = 0 ;
    this.totalEfectivo = 0 ;
    this.totalTarjeta = 0 ;
    this.recargosCobrados = 0 ;
    }

  // Getters 
  public int getVentasDeldia(){
    return this.ventasDeldia ; 
    }
  
  public int getPedidosAtendidos(){
    return this.pedidosAtendidos ; 
    }

  public int getTotalEfectivo(){
    return this.totalEfectivo ; 
    }

  public int getTotalTarjeta(){
    return this.totaltarjeta ; 
    }
  
  public int getRecargosCobrados(){
    return this.recargosCobrados ; 
    }
  
  //Setters : No hay setters ya que estos solo cambian a partir del metodo registrasVenta , para evitar que se altere la caja

  //Metodos

  //calcularTotal = 
  public int calcularTotal (int subtotal , int metodo){
      final int EFECTIVO  = 1 ;
      final int TARJETA = 2 ;
      final int RECARGO_TARJETA = 5 ; 

    if (subtotal <= 0 ) {
        return -1;
    }

    if  (metodo == EFECTIVO ) {
        return subtotal;
    } else if (metodo == TARJETA){  
        int recargo = subtotal * RECARGO_TARJETA/ 100
        return subtotal + recargo ;
    } else {
      return -1 ;
    }  
  }
  
  //regitrarVenta = returna el total cobrado o -1 si es invalido 
  public int registrarVenta (){
      final int EFECTIVO = 1 ; 

      int total = calcularTotal (subtotal , metodo) ;
      if (total == -1 )
        return -1 
      this.ventasDeldia = this.ventasDeldia + total ; 
      this.pedidosAtendidos = this.pedidosAtendidos + 1 
      if (metodo == EFECTIVO ) {
          this .totalEfectivo = this.totalEfectivo + total ;
      } else {
        this.totalTarjeta = this.totalTarjeta + total ; 
        this.recargosCobrados = this.recargosCobrados + (total - subtotal)  ; 
      }
       return total ; 
  }

  //resumen 
  public  String resumen () {
      return "Pedidos atendidos: " + this.pedidosAtendidos + " \n | Vendidos : $" + this.ventasDeldia + "\nEfectivo: $" + this.totalEfectivo + "\n | Tarjeta: $" + this.totalTarjeta + "\n(recargos: $" + this.recargosCobrados + ")";
    }
        
      }
      
      
  }
