
package src;

/**
 *
 * @author PC
 */
public class Mesa {
    //atributos
    private int numero;
    private boolean ocupada;
    
    //constructor
    public Mesa (int numero){
    this.numero = numero;
    this.ocupada = false;
        }
 
    //metodos
    public int getNumero() { return numero; }
    public boolean getOcupada() { return ocupada; }
    public void setOcupada(boolean ocupada) { this.ocupada = ocupada; }
    
    //0
    public boolean ocupar(){
        if (ocupada){
            System.out.println("La mesa seleccionada esta ocupada, elegir otra");
            return false;}
        
        
        
        ocupada = true;
        return true;}
        
    
    public String toString(){
        return "Mesa #: " + numero + "\n" + "Ocupada: " + ocupada;
    }


}
