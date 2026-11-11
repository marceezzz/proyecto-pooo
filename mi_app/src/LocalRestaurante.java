package src;
 
 
// Plano del local de Ricos BBq: una matriz de mesas.
// Las filas y columnas que recibe cada método empiezan en 1 (como las cuenta el usuario).
public class LocalRestaurante {
 
    // Atributo: la matriz de objetos Mesa
    private Mesa[][] mesas;
 
    // Constructor: crea la matriz y numera las mesas 1, 2, 3... por filas
    public LocalRestaurante(int filas, int columnas) {
        this.mesas = new Mesa[filas][columnas];
        int numero = 1;
        for (int i = 0; i < this.mesas.length; i++) {
            for (int j = 0; j < this.mesas[i].length; j++) {
                this.mesas[i][j] = new Mesa(numero);
                numero = numero + 1;
            }
        }
    }
 
    // Número de filas (tamaño del arreglo principal)
    public int getFilas() {
        return this.mesas.length;
    }
 
    // Número de columnas (tamaño de la primera fila)
    public int getColumnas() {
        return this.mesas[0].length;
    }
 
    // ---------- Lógica del negocio ----------
 
    // Verifica que la posición exista dentro de la matriz
    public boolean posicionValida(int fila, int columna) {
        return fila >= 1 && fila <= this.mesas.length
                && columna >= 1 && columna <= this.mesas[0].length;
    }
 
    // Retorna la mesa de esa posición, o null si la posición no existe
    public Mesa getMesa(int fila, int columna) {
        if (!this.posicionValida(fila, columna)) {
            return null;
        }
        return this.mesas[fila - 1][columna - 1];
    }
 
    // Ocupa la mesa. Retorna false si la posición es inválida o ya está ocupada.
    public boolean ocuparMesa(int fila, int columna) {
        Mesa mesa = this.getMesa(fila, columna);
        if (mesa == null || mesa.getOcupada()) {
            return false;
        }
        return mesa.ocupar();
    }
 
    // Libera la mesa. Retorna false si la posición es inválida o la mesa ya estaba libre.
    public boolean liberarMesa(int fila, int columna) {
        Mesa mesa = this.getMesa(fila, columna);
        if (mesa == null || !mesa.getOcupada()) {
            return false;
        }
        mesa.desocupar();
        return true;
    }
 
    // Reserva la mesa. Retorna false si la posición es inválida o la mesa no está libre.
    public boolean reservarMesa(int fila, int columna) {
        Mesa mesa = this.getMesa(fila, columna);
        if (mesa == null) {
            return false;
        }
        return mesa.reservar();
    }
 
    // Cuenta las mesas que están libres (ni ocupadas ni reservadas)
    public int contarLibres() {
        int libres = 0;
        for (int i = 0; i < this.mesas.length; i++) {
            for (int j = 0; j < this.mesas[i].length; j++) {
                if (this.mesas[i][j].getEstado().equals("L")) {
                    libres = libres + 1;
                }
            }
        }
        return libres;
    }
 
    // Dibuja la cuadrícula en consola: L = libre, O = ocupada, R = reservada
    public void dibujar() {
        System.out.print("    ");
        for (int j = 0; j < this.mesas[0].length; j++) {
            System.out.print("  C" + (j + 1) + "  ");
        }
        System.out.println();
        for (int i = 0; i < this.mesas.length; i++) {
            System.out.print("F" + (i + 1) + "  ");
            for (int j = 0; j < this.mesas[i].length; j++) {
                System.out.print(String.format("[ %s ] ", this.mesas[i][j].getEstado()));
            }
            System.out.println();
        }
        System.out.println("L = libre, O = ocupada, R = reservada");
    }
}
 
