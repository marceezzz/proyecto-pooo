package src;

public class Cliente {

    // Atributos
    private String nombre;
    private Mesa mesa;

    // Constructor
    public Cliente(String nombre, Mesa mesa) {
        this.nombre = nombre;
        this.mesa = mesa;
    }

    // Getters
    public String getNombre() {return nombre;}
    public Mesa getMesa() {return mesa;}

    

    // Asigna una mesa disponible al cliente
    /*public boolean asignarMesa(Mesa mesa) {
        if (mesa.getOcupada()) {
            System.out.println("La mesa " + mesa.getNumero() + " está ocupada.");
            return false;
        }

        this.mesa = mesa;
        mesa.setOcupada(true);
        return true;
    }*/

    // Libera la mesa cuando termina el pedido
    public void liberarMesa() {
        if (mesa != null) {
            mesa.setOcupada(false);
            mesa = null;
        }
    }

    @Override
    public String toString() {
        String informacionMesa = "Sin mesa asignada";

        if (mesa != null) {
            informacionMesa = "Mesa: " + mesa.getNumero();
        }

        return "Cliente: " + nombre
                + "\n" + informacionMesa;
    }
}
