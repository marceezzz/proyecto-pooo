package src;
import java.util.Scanner; 

//Menu de opciones
public class Main{
    static void main(String[] args){
        Scanner scn = new Scanner (System.in);
        int control1 = -1; //Controlador del primer bucle
        
        //Lista de productos
        Producto[] ListaProductos = new Producto[0];
        Buscador buscador = new Buscador();

        //Local con la cuadrícula de mesas (2 filas x 5 columnas = 10 mesas)
        LocalRestaurante local = new LocalRestaurante(2, 5);

        //Lista de clientes
        Cliente[] ListaClientes = new Cliente[0];

        //Lista de pedidos
        Pedido[] ListaPedidos = new Pedido[0];

        //Lista de facturas
        Factura[] ListaFacturas = new Factura[0];
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
                    System.out.println("6. Ver facturas");
                    System.out.println("7. Buscar producto por nombre o categoría");
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
                                        //Elige el tipo de producto a crear
                                        System.out.println("Tipo de producto: ");
                                        System.out.println("1. Plato");
                                        System.out.println("2. Bebida");
                                        System.out.println("3. Postre");
                                        int tipo = scn.nextInt();
                                        scn.nextLine();
                                        
                                        if (tipo < 1 || tipo > 3){
                                            System.out.println("Opción invalida \n");
                                            break;}
                                        
                                        
                                        System.out.println("Ingrese el nombre del producto: ");
                                        String nombre = scn.nextLine();
                                        System.out.println("Ingrese el precio: ");
                                        int precio = scn.nextInt();
                                        System.out.println("Ingrese la cantidad de productos: ");
                                        int cantidad = scn.nextInt();
                            
                                        if (cantidad < 0) //controla que no pongan cantidades negativas de productos
                                            cantidad = 0;

                                        switch (tipo){
                                            case 1:
                                                ListaProductos = agregar(ListaProductos, new Plato(nombre,precio,cantidad));
                                                break;
                                            case 2:
                                                System.out.println("¿Es alcoholica? 1. Si  2. No");
                                                int alcoholica = scn.nextInt();
                                                ListaProductos = agregar(ListaProductos, new Bebida(nombre,precio,cantidad, alcoholica == 1));
                                                break;
                                            case 3:
                                                ListaProductos = agregar(ListaProductos, new Postre(nombre,precio,cantidad));
                                                break;
                                        }       
                                        System.out.println();
                                        break;
                                
                                    default:
                                        System.out.println("Opción invalida");
                                        break;
                                    
                                    //Modificar productos
                                    case 2:
                                        if (ListaProductos.length==0){ //Verifica que si hayan productos para modificar
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
                                        if (productoModificar < 0 || productoModificar > ListaProductos.length-1){
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
                                                System.out.println(ListaProductos[productoModificar]);
                                                break;

                                            //Cambia nombre del producto
                                            case 2:
                                                System.out.println("Ingrese el nuevo nombre: ");
                                                String nombre2 = scn.nextLine();
                                                ListaProductos[productoModificar].setNombre(nombre2);
                                                break;

                                            //Cambia precio del producto
                                            case 3:
                                                System.out.println("Ingrese el nuevo precio: ");
                                                int precio2 = scn.nextInt();
                                                scn.nextLine();
                                                ListaProductos[productoModificar].setPrecio(precio2);
                                                break;

                                            //Cambia la cantidad del producto
                                            case 4:
                                                System.out.println("Ingrese la nueva cantidad: ");
                                                int cantidad2 = scn.nextInt();
                                                scn.nextLine();
                                                ListaProductos[productoModificar].setCantidad(cantidad2);
                                                break;
                                            
                                            //borrar producto
                                            case 5:
                                                System.out.println("Producto borrado");
                                                ListaProductos = eliminar(ListaProductos, productoModificar);
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
                            if (ListaProductos.length==0){ //Verifica que si hayan productos para mostrar
                                System.out.println("!Sin productos para mostrar! \n");
                                break;}
                            System.out.println("|Lista de productos|");
                            for (Producto p : ListaProductos)
                            System.out.println(p);
                            break;}

                        //Ver mesas (cuadrícula)
                        case 3:{
                            Menumesas.mostrar(scn, local);
                            break;
                        }

                        //cobrar ( caja )
                        case 4:{
                            //Verifica si hay pedidos
                            if (ListaPedidos.length==0){
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

                            if (numeroPedido < 0 || numeroPedido > ListaPedidos.length-1 ){ //Controla poner numeros negativos o mayores a la cantidad de pedidos
                                System.out.println("Opcion invalida \n");
                                continue;}
                            
                            control = false;
                            }

                            //Seleccion metodo de cobro
                            System.out.println("Método 1. Efectivo   2. Tarjeta (se cobra 5%): ");
                            int metodo = scn.nextInt();

                            double total = caja.registrarVenta(ListaPedidos[numeroPedido].calcularTotal(), metodo);
                            
                            if (total == -1.0) {
                                System.out.println("Cobro inválido, revise el monto y el método\n");
                                break;

                            } else {
                                System.out.println("Total cobrado: $" + total + "\n");
                            }

                            //Crea la factura
                            ListaFacturas = agregar(ListaFacturas, new Factura(ListaPedidos[numeroPedido], metodo, caja.getPedidosAtendidos(),total));

                            //Desocupa la mesa
                            ListaPedidos[numeroPedido].getCliente().getMesa().desocupar();
                            //Borra el cliente de la lista
                            ListaClientes = eliminar(ListaClientes, numeroPedido);
                            //Borra el pedido de la lista
                            ListaPedidos = eliminar(ListaPedidos, numeroPedido);
                            break;}
                
                        // cierre de caja 
                        case 5: {
                            System.out.println("|Cierre del día|");
                            System.out.println(caja.resumen());
                            break;}
                        
                        // Ver facturas
                        case 6: {
                            // Comprueba si hay facturas registradas
                            if (ListaFacturas.length==0){
                                System.out.println("No hay facturas registradas \n");
                                break;
                            }
                            for (Factura f : ListaFacturas)
                                f.MostrarFactura();
                            break;
                        }
                        // Buscar por nombre o por la categoría de Plato, Bebida o Postre
                        case 7: {
                            if (ListaProductos.length == 0) {
                                System.out.println("No hay productos registrados para buscar.\n");
                                break;
                            }

                            System.out.print("Escribe un nombre o una categoría: ");
                            String consulta = scn.nextLine();

                            if (consulta.isBlank()) {
                                System.out.println("La búsqueda no puede estar vacía.\n");
                                break;
                            }

                            Producto[] resultados = buscador.buscar(ListaProductos, consulta);
                            if (resultados.length == 0) {
                                System.out.println("No se encontraron coincidencias.\n");
                            } else {
                                System.out.println("|Resultados de búsqueda|");
                                for (Producto producto : resultados) {
                                    System.out.println("Categoría: " + producto.getCategoria());
                                    System.out.println(producto);
                                }
                            }
                            break;
                        }
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
                    if (ListaProductos.length==0){ 
                        System.out.println("!Lo sentimos, no tenemos productos ahora mismo! \n");
                        break;}

                    //Verifica si hay mesas libres
                    if (local.contarLibres() == 0){
                        System.out.println("!Lo sentimos, no tenemos mesas disponibles!");
                        break;
                    }

                    System.out.println("Ingrese su nombre: "); //Nombre cliente
                    String nombre = scn.nextLine();
                    int control4 = -1;  //controlador cuatro bucle
                    

                    //Seleccion de mesa
                    while (control4 != 0) {
                        System.out.println("|Seleccione una mesa|");
                        local.dibujar();
                        
                        System.out.println("Fila: ");
                        int fila = scn.nextInt();
                        System.out.println("Columna: ");
                        int columna = scn.nextInt();
                        scn.nextLine();

                        Mesa mesaSeleccionada = local.getMesa(fila, columna);

                        //Verificacion mesa seleccionada valida
                        if (mesaSeleccionada == null){
                            System.out.println("Opción invalida \n");
                            continue;}

                        //Verificacion si la mesa seleccionada se encuentra disponible
                        if (mesaSeleccionada.getEstado().equals("L")){
                            mesaSeleccionada.ocupar();
                            //añadimos el cliente a la lista de clientes
                            ListaClientes = agregar(ListaClientes, new Cliente(nombre, mesaSeleccionada));
                            control4 = 0; // fin bucle
                            break;}

                        //Mesa ocupada o reservada
                        System.out.println("La mesa seleccionada no esta disponible, elegir otra");}

                        //Generar pedido
                        ListaPedidos = agregar(ListaPedidos, new Pedido(ListaClientes[ListaClientes.length-1]));
                        
                        //Muestra el menú
                         while (!ListaPedidos[ListaPedidos.length-1].getfinalizado()){
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
                                if (ListaPedidos[ListaPedidos.length-1].getItems().length==0){
                                    //Desocupa la mesa
                                    ListaPedidos[ListaPedidos.length-1].getCliente().getMesa().desocupar();
                                    //Borra el cliente de la lista
                                    ListaClientes = eliminar(ListaClientes, ListaClientes.length-1);
                                    //Borra el pedido de la lista
                                    ListaPedidos = eliminar(ListaPedidos, ListaPedidos.length-1);
                                    break;
                                }
                                break;                          
                            }

                            //Muestra los productos pedidos
                            if (opcion==i){
                                ListaPedidos[ListaPedidos.length-1].ProductosEscogidos();
                                continue;}

                            //Verifica que la opcion tenga sentido
                            if (opcion < 1 || opcion > ListaProductos.length){
                                System.out.println("Opción invalida");
                                continue;}

                            System.out.println("Ingrese la cantidad: ");
                            int cantidad = scn.nextInt();
                            scn.nextLine();
                            
                            //Verifica que la cantidad escogida no sea mayor al inventario de productos
                            if (cantidad < 1 || cantidad > ListaProductos[opcion-1].getCantidad()){
                                System.out.println("!No tenemos esa cantidad de producto!");
                                continue;}
                            

                            //Agrega los productos pedidos
                            ListaPedidos[ListaPedidos.length-1].agregarDesdeMenu(ListaProductos,opcion,cantidad);
                            
                            
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
                                    ListaPedidos[ListaPedidos.length-1].PedidoFinalizado();//termina el pedido
                                    ListaPedidos[ListaPedidos.length-1].ProductosEscogidos();//muestra los productos escogidos
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
    
    private static Producto[] agregar(Producto[] a, Producto x) { Producto[] n=java.util.Arrays.copyOf(a,a.length+1); n[a.length]=x; return n; }
    private static Cliente[] agregar(Cliente[] a, Cliente x) { Cliente[] n=java.util.Arrays.copyOf(a,a.length+1); n[a.length]=x; return n; }
    private static Pedido[] agregar(Pedido[] a, Pedido x) { Pedido[] n=java.util.Arrays.copyOf(a,a.length+1); n[a.length]=x; return n; }
    private static Factura[] agregar(Factura[] a, Factura x) { Factura[] n=java.util.Arrays.copyOf(a,a.length+1); n[a.length]=x; return n; }
    private static Producto[] eliminar(Producto[] a,int i) { Producto[] n=new Producto[a.length-1]; System.arraycopy(a,0,n,0,i); System.arraycopy(a,i+1,n,i,a.length-i-1); return n; }
    private static Cliente[] eliminar(Cliente[] a,int i) { Cliente[] n=new Cliente[a.length-1]; System.arraycopy(a,0,n,0,i); System.arraycopy(a,i+1,n,i,a.length-i-1); return n; }
    private static Pedido[] eliminar(Pedido[] a,int i) { Pedido[] n=new Pedido[a.length-1]; System.arraycopy(a,0,n,0,i); System.arraycopy(a,i+1,n,i,a.length-i-1); return n; }
}
