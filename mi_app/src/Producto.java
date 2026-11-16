package src;



//Esta clase sirve para crear productos


public abstract class Producto {
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

    //Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    //Función restar cantidad
    public void RestarCantidad(int numero){
        cantidad -= numero;}

    //Sumar cantidad
    public void SumarCantidad(int numero){
        cantidad += numero;}
    
    // Metodos que las clases hijas codificaran a su manera
    public abstract int CalcularTotal();
    public abstract String getCategoria();
    public abstract Producto copiar(int cantidad);

    
    //muestra los atributos de los objetos
    @Override 
    public String toString(){
        return "Nombre: " + nombre + "\n" + "Precio: " + precio + "\n" + "Cantidad: " + cantidad + "\n" ;
    }

    static void main(String[] args){
    }
}
