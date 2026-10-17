package src;
import java.util.Scanner;


//Esta clase sirve para crear productos


public class Producto {
    //atributos
    private String nombre;
    private int precio; 
    

    //constructor
    Producto (String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    

    //muestra los atributos de los objetos
    public String toString(){
        return "Nombre: " + nombre + "\n" + "Precio: " + precio + "\n";
    }

    static void main(String[] args){
    }
}
