package src;
import java.util.ArrayList;
import java.util.Scanner; 

//Menu de opciones
public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner (System.in);
        int x = -1; //Controlador del primer bucle
        
        //Lista de productos
        ArrayList<Producto> ListaProductos = new ArrayList<>();

        //Lista de mesas
        ArrayList<Mesa> ListaMesas = new ArrayList<>();
        for (int i = 1; i < 11; i++){
            ListaMesas.add(new Mesa(i));
        }   

        //Lista de clientes
        ArrayList<Cliente> ListaClientes = new ArrayList<>();

        //Lista de pedidos
        ArrayList<Pedido> ListaPedidos = new ArrayList<>();

        //Caja del restaurante 
        var caja = new Caja();

        while (x != 0){

            System.out.println("|Menu de opciones|");
            System.out.println("1. Trabajador");
            System.out.println("2. Cliente");
            System.out.println("0. Salir");
            x = scn.nextInt();
            scn.nextLine();
            
            switch (x){
                //fin programa
                case 0:
                    System.out.println("Fin del programa");
                    break;
                //Opciones para trabajadores
                case 1:{
                    int y = -1; //Controlador del segundo bucle
                    while (y != 0){
                    System.out.println("|Menu de opciones|");
                    System.out.println("1. Crear producto");
                    System.out.println("2. Ver lista de productos");
                    System.out.println("3. Cobrara Caja");
                    System.out.println("4. Resumen del dia");
                    System.out.println("5. Crear Pedido");
                    System.out.println("0. Salir");
                    y = scn.nextInt();
                    scn.nextLine();
                    
                    switch (y){                                               
                        //Crear productos
                        case 1:{
                            System.out.println("Nombre del producto: ");
                            String nombre = scn.nextLine();
                            System.out.println("Ingrese el precio: ");
                            int precio = scn.nextInt();
                            System.out.println("Ingrese la cantidad de productos: ");
                            int cantidad = scn.nextInt();
                            
                            if (cantidad < 0) //controla que no pongan cantidades negativas de productos
                                cantidad = 0;

                            ListaProductos.add(new Producto(nombre,precio,cantidad));
                            System.out.println();
                            break;}

                        //Ver lista de productos
                        case 2:{
                            System.out.println("|Lista de productos|");
                            for (Producto p : ListaProductos)
                            System.out.println(p);
                            break;}

                        //cobrar ( caja )
                        case 3:{
                            System.out.println("Subtotal del pedido: ");
                            double subtotal = scn.nextDouble();
                            System.out.println("Método (1. Efectivo, 2. Tarjeta): ");
                            int metodo = scn.nextInt();
                            double total = caja.registrarVenta(subtotal, metodo);
                            if (total == -1.0) {
                                System.out.println("Cobro inválido, revise el monto y el método");
                            } else {
                                System.out.println("Total cobrado: $" + total);
                            }
                            break;}
                
                        // cierre de caja 
                        case 4: {
                            System.out.println("|Cierre del día|");
                            System.out.println(caja.resumen());
                            break;}

                        case 5: {
                          if (ListaProductos.isEmpty()) {
                            System.out.println("Primero crea productos (opcion 1).");
                            break;
                         }
 
                         System.out.println("Nombre del cliente: ");
                         String nombreCliente = scn.nextLine();
                         System.out.println("Documento: ");
                         String documento = scn.nextLine();
                         System.out.println("Telefono: ");
                         String telefono = scn.nextLine();
                         Cliente cliente = new Cliente(nombreCliente, documento, telefono);
 
                    
                        if (!ListaMesas.isEmpty()) {
                         System.out.println("Mesas libres:");
                         for (Mesa m : ListaMesas) {
                            if (!m.getOcupada()) {
                                System.out.println("Mesa " + m.getNumero() + " (" + m.getTipo() + ")");
                            }
                        }
                        System.out.println("Numero de mesa (0 para ninguna): ");
                        int numMesa = scn.nextInt();
                        scn.nextLine();
 
                        if (numMesa != 0) {
                            boolean encontrada = false;
                            for (Mesa m : ListaMesas) {
                                if (m.getNumero() == numMesa) {
                                    encontrada = true;
                                    cliente.asignarMesa(m);
                                }
                            }
                            if (!encontrada) {
                                System.out.println("Esa mesa no existe, el pedido queda sin mesa.");
                            }
                        }
                    }
 
                    Pedido pedido = new Pedido(cliente);
 
                    
                    int opcion = -1;
                    while (opcion != 0) {
                        for (int i = 0; i < ListaProductos.size(); i++) {
                            System.out.println((i + 1) + ". " + ListaProductos.get(i));
                        }
                        System.out.println("Numero de producto (0 para terminar): ");
                        opcion = scn.nextInt();
 
                        if (opcion != 0) {
                            System.out.println("Cantidad: ");
                            int cantidad = scn.nextInt();
                            pedido.agregarDesdeMenu(ListaProductos, opcion, cantidad);
                        }
                        scn.nextLine();
                    }
 
                    ListaPedidos.add(pedido);
                    System.out.println(pedido);
                    break;
                }
               
                        
                        }
                    }
                }
                break;
        
                //Opciones para los clientes
                case 2:{
                    System.out.println("Ingrese su nombre: "); //Nombre cliente
                    String nombre = scn.nextLine();
                    int z = -1;  //controlador tercer bucle
                    
                    //Seleccion de mesa
                    while (z != 0) {
                        System.out.println("|Seleccione una mesa|");
                        for (Mesa m : ListaMesas)
                            System.out.println(m);
                        
                        System.out.println("Ingrese el numero de la mesa: ");
                        int mesaSeleccionada = scn.nextInt();
                        mesaSeleccionada -=1;//Le resto uno para hallar su posicion en la lista

                        //Verificacion si la mesa seleccionada se encuentra disponible
                        if (ListaMesas.get(mesaSeleccionada).getOcupada() == false){
                            ListaMesas.get(mesaSeleccionada).ocupar();
                            //añadimos el cliente a la lista de clientes
                            ListaClientes.add(new Cliente(nombre, ListaMesas.get(mesaSeleccionada)));
                            z = 0; // fin bucle
                            break;}

                        //Mesa ocupada
                        ListaMesas.get(mesaSeleccionada).ocupar();}

                        //Generar pedido
                        ListaPedidos.add(new Pedido(ListaClientes.get((ListaClientes.size())-1)));
                        
                        //Muestra el menú
                         while (!ListaPedidos.get((ListaPedidos.size())-1).getfinalizado()){
                            System.out.println("|MENÚ|"+"\n");
                            System.out.println("0."+"Ver pedido\n");
                            int i = 1;
                                for (Producto p : ListaProductos){ 
                                    System.out.println(i+"." + p.getNombre());
                                    System.out.println("Precio: " + p.getPrecio());
                                    System.out.println("Cantidad disponible: " + p.getCantidad()+"\n");
                                    ++i;}
                        
                        //Selección de productos
                            System.out.println("Seleccione un producto del menú: ");
                            int opcion = scn.nextInt();
                            //Muestra los productos pedidos
                            if (opcion==0){
                                ListaPedidos.get((ListaPedidos.size())-1).ProductosEscogidos();
                                continue;}
                            System.out.println("Ingrese la cantidad: ");
                            int cantidad = scn.nextInt();
                            scn.nextLine();
                            
                            //Agrega los productos pedidos
                            ListaPedidos.get((ListaPedidos.size())-1).agregarDesdeMenu(ListaProductos,opcion,cantidad);
                            
                            
                            System.out.println("¿Desea seguir ordenando?");
                            System.out.println("1.SI    2.NO");
                            int seguirOrdenando = scn.nextInt();
                            scn.nextLine();
                            if (seguirOrdenando == 2){
                                ListaPedidos.get((ListaPedidos.size())-1).PedidoFinalizado();//termina el pedido
                                ListaPedidos.get((ListaPedidos.size())-1).ProductosEscogidos();//muestra los productos escogidos
                            }
                        }
                        




                        break;
                    }

                default:{
                    System.out.println("Opción inválida");
                    break;
                    }
                }
                
            }
            
        }
    }
        
    

