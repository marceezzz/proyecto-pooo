package src;

public class Cliente {

    // Atributos
    private String nombre;
    private String documento;
    private String telefono;
    private Mesa mesa;

    // Constructor
    public Cliente(String nombre, String documento, String telefono) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.mesa = null;
    }

    // Getters
    public String getNombre() {return nombre;}
    public String getDocumento() {return documento;}
    public String getTelefono() {return telefono;}
    public Mesa getMesa() {return mesa;}

    // Setters
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Asigna una mesa disponible al cliente
    public boolean asignarMesa(Mesa mesa) {
        if (mesa.getOcupada()) {
            System.out.println("La mesa " + mesa.getNumero() + " está ocupada.");
            return false;
        }

        this.mesa = mesa;
        mesa.setOcupada(true);
        return true;
    }

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
                + "\nDocumento: " + documento
                + "\nTeléfono: " + telefono
                + "\n" + informacionMesa;
    }
}