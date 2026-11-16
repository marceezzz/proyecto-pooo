package src;

import java.util.Arrays;
import java.util.Locale;

/** Busca productos por nombre o categoría, incluyendo las subclases de Producto. */
public class Buscador {

    public Producto[] buscar(Producto[] productos, String consulta) {
        if (productos == null || consulta == null || consulta.isBlank()) {
            return new Producto[0];
        }

        String consultaNormalizada = normalizar(consulta);
        Producto[] resultados = new Producto[0];

        for (Producto producto : productos) {
            if (producto == null) {
                continue;
            }

            boolean coincideNombre = coincide(producto.getNombre(), consultaNormalizada);
            boolean coincideCategoria = coincide(producto.getCategoria(), consultaNormalizada);

            if (coincideNombre || coincideCategoria) {
                resultados = Arrays.copyOf(resultados, resultados.length + 1);
                resultados[resultados.length - 1] = producto;
            }
        }

        return resultados;
    }

    private boolean coincide(String texto, String consultaNormalizada) {
        return texto != null && normalizar(texto).contains(consultaNormalizada);
    }

    private String normalizar(String texto) {
        return texto.strip().toLowerCase(Locale.ROOT);
    }
}
