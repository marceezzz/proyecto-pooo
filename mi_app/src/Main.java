package src;
import java.util.ArrayList;
import java.util.Scanner; 

//Menu de opciones
public class Main{
    static void main(String[] args){
        Scanner scn = new Scanner (System.in);
        int control1 = -1; //Controlador del primer bucle
        
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

        while (control1 != 0){

            System.out.println("|Menu de opciones|");
            System.out.println("1. Trabajador");
            System.out.println("2. Cliente");
            System.out.println("0. Salir");
            control1 = scn.nextInt();
            scn.nextLine();
            
            switch (control1){
                //fin programa
                case 0:
                    System.out.println("Fin del programa");
                    break;
                //Opciones para trabajadores
                case 1:{
                    int control2 = -1; //Controlador del segundo bucle
                    while (control2 != 0){
                    System.out.println("|Menu de opciones|");
                    System.out.println("1. Modificar producto");
                    System.out.println("2. Ver lista de productos");
                    System.out.println("3. Ver mesas");
                    System.out.println("4. Cobrar Caja");
                    System.out.println("5. Resumen del dia");
                    System.out.println("0. Salir");
                    control2 = scn.nextInt();
                    scn.nextLine();
                    
                    switch (control2){ 
                        //Salir
                        case 0:
                            break;                                              
                        //Modificar productos
                        case 1:{
                            int control3 = -1;
                            while (control3 != 0){
                                System.out.println("|Menú de opciones|");
                                System.out.println("1. Crear productos");
                                System.out.println("2. Modificar productos");
                                System.out.println("0. Salir");
                                control3 = scn.nextInt();
                                scn.nextLine();
                                switch (control3) {
                                    //Salir
                                    case 0:
                                        break;
                                    //Crear productos
                                    case 1:
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
                                        break;
                                
                                    default:
                                        System.out.println("Opción invalida");
                                        break;
                                    
                                    //Modificar productos
                                    case 2:
                                        if (ListaProductos.size()==0){ //Verifica que si hayan productos para modificar
                                            System.out.println("!Sin productos para modificar! \n");
                                            break;}
                                        int control6 = -1;
                                        int productoModificar = -1;
                                        while (control6 != 0) {
                                        
                                        //Seleccion producto a modificar
                                        System.out.println("|Seleccione un producto para modificar|");
                                        int numero1 = 1;
                                        for (Producto p : ListaProductos){
                                                System.out.print(numero1 + ". ");
                                                System.out.println(p.getNombre());
                                                ++numero1;
                                        }

                                        productoModificar = scn.nextInt()-1;//Posicion del producto elegido
                                        scn.nextLine();

                                        //verifica que la opciones sea valida
                                        if (productoModificar < 0 || productoModificar > ListaProductos.size()-1){
                                            System.out.println("Opción invalida \n");
                                            continue;}
                                        control6 = 0;} //fin bucle
                                        
                                        
                                        
                                        int control5 = -1; //controlador bucle 5
                                        while (control5 != 0){
                                            System.out.println("|Menú de opciones|");
                                            System.out.println("1. Ver caracteristicas");
                                            System.out.println("2. Cambiar nombre");
                                            System.out.println("3. Cambiar precio");
                                            System.out.println("4. Cambiar cantidad");
                                            System.out.println("5. Borrar producto");
                                            System.out.println("0. salir");
                                            control5 = scn.nextInt();
                                            scn.nextLine();

                                        switch (control5) {
                                            //salir
                                            case 0:
                                                break;

                                            //Ver caracteristicas del producto
                                            case 1:
                                                System.out.println(ListaProductos.get(productoModificar));
                                                break;

                                            //Cambia nombre del producto
                                            case 2:
                                                System.out.println("Ingrese el nuevo nombre: ");
                                                String nombre2 = scn.nextLine();
                                                ListaProductos.get(productoModificar).setNombre(nombre2);
                                                break;

                                            //Cambia precio del producto
                                            case 3:
                                                System.out.println("Ingrese el nuevo precio: ");
                                                int precio2 = scn.nextInt();
                                                scn.nextLine();
                                                ListaProductos.get(productoModificar).setPrecio(precio2);
                                                break;

                                            //Cambia la cantidad del producto
                                            case 4:
                                                System.out.println("Ingrese la nueva cantidad: ");
                                                int cantidad2 = scn.nextInt();
                                                scn.nextLine();
                                                ListaProductos.get(productoModificar).setCantidad(cantidad2);
                                                break;
                                            
                                            //borrar producto
                                            case 5:
                                                System.out.println("Producto borrado");
                                                ListaProductos.remove(productoModificar);
                                                control5 = 0;
                                                break;

                                            default:
                                                System.out.println("Opción invalida");
                                                break;
                                        }}
                                        break;
                                }
                                break;
                                
                            }
                            break;
                        }
                            
                        

                        //Ver lista de productos
                        case 2:{
                            if (ListaProductos.size()==0){ //Verifica que si hayan productos para mostrar
                                System.out.println("!Sin productos para mostrar! \n");
                                break;}
                            System.out.println("|Lista de productos|");
                            for (Producto p : ListaProductos)
                            System.out.println(p);
                            break;}

                        //Mostrar mesas ocupadas
                        case 3:{
                            for(Mesa m : ListaMesas)
                                System.out.println(m);

                            break;
                        }

                        //cobrar ( caja )
                        case 4:{
                            //Verifica si hay pedidos
                            if (ListaPedidos.size()==0){
                                System.out.println("No hay pedidos \n");
                                break;}

                            //Seleccion pedido a cobrar
                            boolean control = true; //variable control bucle
                            int numeroPedido = -1;
                            while(control){
                            System.out.println("Seleccione el pedido a cobrar: ");
                            int numero = 1;
                            for (Pedido p : ListaPedidos){
                                System.out.print("#" + numero + " ");
                                p.Mostrar();
                                ++numero;}
                                
                            numeroPedido = (scn.nextInt()) - 1;

                            if (numeroPedido < 0 || numeroPedido > ListaPedidos.size()-1 ){ //Controla poner numeros negativos o mayores a la cantidad de pedidos
                                System.out.println("Opcion invalida \n");
                                continue;}
                            
                            control = false;
                            }

                            //Seleccion metodo de cobro
                            System.out.println("Método (1. Efectivo, 2. Tarjeta): ");
                            int metodo = scn.nextInt();

                            double total = caja.registrarVenta(ListaPedidos.get(numeroPedido).calcularTotal(), metodo);
                            
                            if (total == -1.0) {
                                System.out.println("Cobro inválido, revise el monto y el método\n");
                                break;

                            } else {
                                System.out.println("Total cobrado: $" + total + "\n");
                            }
                            //Desocupa la mesa
                            ListaPedidos.get(numeroPedido).getCliente().getMesa().desocupar();
                            //Borra el cliente de la lista
                            ListaClientes.remove(numeroPedido);
                            //Borra el pedido de la lista
                            ListaPedidos.remove(numeroPedido);
                            break;}
                
                        // cierre de caja 
                        case 5: {
                            System.out.println("|Cierre del día|");
                            System.out.println(caja.resumen());
                            break;}
                        default:
                            System.out.println("Opcion invalida \n");
                            break;
                        
                        }
                    }
                }
                break;
        
                //Opciones para los clientes
                case 2:{

                    //Verifica que existan productos para comprar
                    if (ListaProductos.size()==0){ 
                        System.out.println("!Lo sentimos, no tenemos productos ahora mismo! \n");
                        break;}

                    System.out.println("Ingrese su nombre: "); //Nombre cliente
                    String nombre = scn.nextLine();
                    int control4 = -1;  //controlador cuatro bucle
                    

                    //Seleccion de mesa
                    while (control4 != 0) {
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
                            control4 = 0; // fin bucle
                            break;}

                        //Mesa ocupada
                        ListaMesas.get(mesaSeleccionada).ocupar();}

                        //Generar pedido
                        ListaPedidos.add(new Pedido(ListaClientes.get((ListaClientes.size())-1)));
                        
                        //Muestra el menú
                         while (!ListaPedidos.get((ListaPedidos.size())-1).getfinalizado()){
                            System.out.println("|MENÚ|"+"\n");

                            int i = 1;
                                for (Producto p : ListaProductos){ 
                                    System.out.println(i+"." + p.getNombre());
                                    System.out.println("Precio: " + p.getPrecio());
                                    System.out.println("Cantidad disponible: " + p.getCantidad()+"\n");
                                    ++i;}

                            System.out.println(i + "." + "Ver pedido\n");
                            System.out.println("0. Salir\n");
                        
                        //Selección de productos
                            System.out.println("Seleccione un producto del menú: ");
                            int opcion = scn.nextInt();                            
                            
                            //Salirse del menu
                            if (opcion == 0){
                                //El cliente no compro ningun producto
                                if (ListaPedidos.getLast().getItems().size()==0){
                                    //Desocupa la mesa
                                    ListaPedidos.getLast().getCliente().getMesa().desocupar();
                                    //Borra el cliente de la lista
                                    ListaClientes.remove(ListaClientes.getLast());
                                    //Borra el pedido de la lista
                                    ListaPedidos.remove(ListaPedidos.getLast());
                                    break;
                                }
                                break;                          
                            }

                            //Muestra los productos pedidos
                            if (opcion==i){
                                ListaPedidos.get((ListaPedidos.size())-1).ProductosEscogidos();
                                continue;}

                            //Verifica que la opcion tenga sentido
                            if (opcion < 1 || opcion > ListaProductos.size()){
                                System.out.println("Opción invalida");
                                continue;}

                            System.out.println("Ingrese la cantidad: ");
                            int cantidad = scn.nextInt();
                            scn.nextLine();
                            
                            //Verifica que la cantidad escogida no sea mayor al inventario de productos
                            if (cantidad < 1 || cantidad > ListaProductos.get(opcion-1).getCantidad()){
                                System.out.println("!No tenemos esa cantidad de producto!");
                                continue;}
                            

                            //Agrega los productos pedidos
                            ListaPedidos.get((ListaPedidos.size())-1).agregarDesdeMenu(ListaProductos,opcion,cantidad);
                            
                            
                            boolean control8 = true;
                            while (control8){
                            System.out.println("¿Desea seguir ordenando?");
                            System.out.println("1.SI    2.NO");
                            int seguirOrdenando = scn.nextInt();
                            scn.nextLine();
                            switch (seguirOrdenando){
                                case 1:
                                    control8 = false;
                                    continue;
                                case 2:
                                    control8 = false;
                                    ListaPedidos.get((ListaPedidos.size())-1).PedidoFinalizado();//termina el pedido
                                    ListaPedidos.get((ListaPedidos.size())-1).ProductosEscogidos();//muestra los productos escogidos
                                    break;
                                default:
                                    System.out.println("Opción invalida");

                            }}
                        }
                        




                        break;
                    }

                default:{
                    System.out.println("Opción inválida \n");
                    break;
                    }
                }
                
            }
            
        }
    }
        
    

