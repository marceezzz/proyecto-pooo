
package src;

/**
 *
 * @author PC
 */
public class Mesa {
    //atributos
    private int numero;
    private boolean ocupada;
    private boolean reservada;
    
    //constructor
    public Mesa (int numero){
    this.numero = numero;
    this.ocupada = false;
    this.reservada = false;
        }
 
    //metodos
    public int getNumero() { return numero; }
    public boolean getOcupada() { return ocupada; }
    public void setOcupada(boolean ocupada) { this.ocupada = ocupada; }
    public boolean getReservada () { return reservada ;}
    //0
    
  // Retorna la letra que se dibuja en la cuadrícula: L, O o R
     public String getEstado() {
        if (this.ocupada) {
            return "O";
        } else if (this.reservada) {
            return "R";
        }
        return "L";
    }
    public boolean ocupar(){
        if (ocupada){
            System.out.println("La mesa seleccionada esta ocupada, elegir otra");
            return false;}
        
        ocupada = true;
        reservada =false ; 
        return true;}
    
    public void desocupar(){
        ocupada = false;
    }
     // Reserva la mesa.
    public boolean reservar() {
        if (this.ocupada || this.reservada) {
            return false;
        }
        this.reservada = true;
        return true;
    }
    
    // Cancela reserva.
    public boolean cancelarReserva() {
        if (!this.reservada) {
            return false;
        }
        this.reservada = false;
        return true;
    }

    
    public String toString(){
        return "Mesa #: " + numero + "\n" + "Ocupada: " + ocupada  + "\n" + "Reservada: " + this.reservada;
    }


}
