package colasdeprioridad;

/**
 * Representa un elemento en la cola de prioridad.
 * Contiene un valor y un nivel de prioridad.
 * La clase implementa `Comparable` para poder ordenar los elementos.
 *
 * @param <T> El tipo de dato del valor.
 */
public class Elemento<T> implements Comparable<Elemento<T>> {
    private T valor;
    private int prioridad; // Mayor número = Mayor prioridad

    public Elemento(T valor, int prioridad) {
        this.valor = valor;
        this.prioridad = prioridad;
    }

    public T getValor() {
        return valor;
    }

    public int getPrioridad() {
        return prioridad;
    }

    /**
     * Compara este elemento con otro basado en su prioridad.
     * Se usa para ordenar los elementos en la cola de prioridad.
     *
     * @param otro El otro elemento a comparar.
     * @return Un número negativo si este elemento tiene menor prioridad,
     *         cero si tienen la misma prioridad,
     *         y un número positivo si este elemento tiene mayor prioridad.
     */
    @Override
    public int compareTo(Elemento<T> otro) {
        // Comparamos las prioridades.
        // Devuelve la diferencia para determinar el orden.
        // Si se quisiera que menor número fuera mayor prioridad, se invertiría la resta.
        return Integer.compare(this.prioridad, otro.prioridad);
    }

    @Override
    public String toString() {
        return "{" +
               "valor=" + valor +
               ", prioridad=" + prioridad +
               '}';
    }
}

