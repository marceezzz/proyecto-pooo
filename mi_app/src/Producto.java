package src;



//Esta clase sirve para crear productos


public class Producto {
    //atributos
    private String nombre;
    private int precio; 
    private int cantidad;

    //constructor
    Producto (String nombre, int precio, int cantidad){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //Copiar producto
    Producto (Producto copia, int cantidad){
        this.nombre = copia.nombre;
        this.precio = copia.precio;
        this.cantidad = cantidad;
    }

    //Getters
    String getNombre(){
        return nombre;
    }

    int getPrecio(){
        return precio;
    }

    int getCantidad(){
        return cantidad;
    }
    //Función restar cantidad
    public void RestarCantidad(int numero){
        cantidad -= numero;}

    //Sumar cantidad
    public void SumarCantidad(int numero){
        cantidad += numero;}
    
    //Calcular precio
    public int CalcularTotal(){
        int total = cantidad*precio;
        return total;
    }
    

    

    //muestra los atributos de los objetos
    public String toString(){
        return "Nombre: " + nombre + "\n" + "Precio: " + precio + "\n" + "Cantidad: " + cantidad + "\n" ;
    }

    static void main(String[] args){
    }
}
