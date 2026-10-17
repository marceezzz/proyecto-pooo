
package src;
import java.util.Scanner;
/**
 *
 * @author PC
 */
public class Mesa {
    //atributos
    private int numero;
    private String tipo;
    private boolean ocupada;
    
    //constructor
    public Mesa (int numero, String tipo){
    this.numero = numero;
    this.tipo = tipo;
        }
 
    //metodos
    public int getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public boolean getOcupada() { return ocupada; }
    public void setOcupada(boolean ocupada) { this.ocupada = ocupada; }
    
    //0
    public boolean ocupar (){
        if (ocupada == true){
            System.out.println("La mesa seleccionada esta ocupada, elegir otra");
               return false;
        }
        else 
            return true;     
    }


}
