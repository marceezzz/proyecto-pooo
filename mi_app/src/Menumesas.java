package src;

import java.util.Scanner;

// Submenú de la cuadrícula de mesas. Se llama desde el menú principal del Main.
public class MenuMesas {

    public static void mostrar(Scanner scn, LocalRestaurante local) {
        int opcion = -1;
        int fila = 0;
        int columna = 0;
        Mesa mesa;

        while (opcion != 0) {
            System.out.println();
            System.out.println("|Cuadricula de mesas|");
            local.dibujar();
            System.out.println("Mesas libres: " + local.contarLibres());
            System.out.println("1. Consultar mesa");
            System.out.println("2. Ocupar mesa");
            System.out.println("3. Liberar mesa");
            System.out.println("4. Reservar mesa");
            System.out.println("0. Volver");
            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Fila: ");
                    fila = scn.nextInt();
                    System.out.println("Columna: ");
                    columna = scn.nextInt();
                    mesa = local.getMesa(fila, columna);
                    if (mesa == null) {
                        System.out.println("Posición inválida");
                    } else {
                        System.out.println(mesa);
                    }
                    break;
                case 2:
                    System.out.println("Fila: ");
                    fila = scn.nextInt();
                    System.out.println("Columna: ");
                    columna = scn.nextInt();
                    if (local.ocuparMesa(fila, columna)) {
                        System.out.println("Mesa ocupada");
                    } else {
                        System.out.println("No se pudo ocupar: la posición no existe o la mesa ya está ocupada");
                    }
                    break;
                case 3:
                    System.out.println("Fila: ");
                    fila = scn.nextInt();
                    System.out.println("Columna: ");
                    columna = scn.nextInt();
                    if (local.liberarMesa(fila, columna)) {
                        System.out.println("Mesa liberada");
                    } else {
                        System.out.println("No se pudo liberar: la posición no existe o la mesa ya estaba libre");
                    }
                    break;
                case 4:
                    System.out.println("Fila: ");
                    fila = scn.nextInt();
                    System.out.println("Columna: ");
                    columna = scn.nextInt();
                    if (local.reservarMesa(fila, columna)) {
                        System.out.println("Mesa reservada");
                    } else {
                        System.out.println("No se pudo reservar: la posición no existe o la mesa no está libre");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
