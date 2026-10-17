package src;
import java.util.ArrayList;
import java.util.Scanner; 

//Menu de opciones
public class Main{
    static void main(String[] args){
        Scanner scn = new Scanner (System.in);
        int x = -1; //Controlador del bucle

        //Lista de productos
        ArrayList<Producto> ListaProductos = new ArrayList<>();


        while (x != 0){ 
           
            System.out.println("|Menu de opciones|");
            System.out.println("1. Crear producto");
            System.out.println("2. Ver lista de productos");
            System.out.println("3. Mesas");
            System.out.println("0. Salir");
            x = scn.nextInt();
            scn.nextLine();

            switch (x) {
                //crear productos
                case 1:{ 
                    System.out.println("Nombre del producto: ");
                    String nombre = scn.nextLine();
                    System.out.println("Ingrese el precio: ");
                    int precio = scn.nextInt();
                    ListaProductos.add(new Producto(nombre,precio));
                    System.out.println();
                    break;
                }

                //mostrar lista de productos
                case 2:{
                    System.out.println("|Lista de productos|");
                    for (Producto p : ListaProductos){
                        System.out.println(p);
                    }
                    
                }
                case 3:{
                   System.out.println("|Mesas|");
                   System.out.print("fff");
                }
   
            }
        }

        System.out.println("Fin programa"); //Prueba de fin programa
    }
}