package colasdeprioridad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Implementación de una Cola de Prioridad (Priority Queue).
 * Esta versión utiliza un ArrayList y lo mantiene ordenado por prioridad.
 * El elemento con la MAYOR prioridad (número más alto) es atendido primero.
 *
 * @param <T> El tipo de dato del valor de los elementos.
 */
public class ColaPrioridad<T> {
    // Usamos un ArrayList para almacenar los elementos.
    private ArrayList<Elemento<T>> elementos;

    public ColaPrioridad() {
        this.elementos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo elemento a la cola con su respectiva prioridad.
     * Después de agregar, la lista se reordena para mantener la propiedad de la cola de prioridad.
     *
     * @param valor El valor del elemento.
     * @param prioridad La prioridad del elemento (mayor número es mayor prioridad).
     */
    public void encolar(T valor, int prioridad) {
        Elemento<T> nuevoElemento = new Elemento<>(valor, prioridad);
        elementos.add(nuevoElemento);
        // Mantenemos la lista ordenada. El elemento con mayor prioridad quedará al final.
        Collections.sort(elementos);
    }

    /**
     * Remueve y devuelve el elemento con la mayor prioridad.
     * En esta implementación, es el último elemento de la lista ordenada.
     *
     * @return El elemento con la mayor prioridad.
     * @throws NoSuchElementException si la cola está vacía.
     */
    public Elemento<T> desencolar() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola de prioridad está vacía.");
        }
        // El elemento con la mayor prioridad está al final de la lista ordenada.
        return elementos.remove(elementos.size() - 1);
    }

    /**
     * Devuelve el elemento con la mayor prioridad sin removerlo.
     *
     * @return El próximo elemento a ser desencolado.
     * @throws NoSuchElementException si la cola está vacía.
     */
    public Elemento<T> verFrente() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola de prioridad está vacía.");
        }
        // El elemento con la mayor prioridad está al final.
        return elementos.get(elementos.size() - 1);
    }

    /**
     * Verifica si la cola de prioridad está vacía.
     * @return true si no hay elementos, false en caso contrario.
     */
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    /**
     * Devuelve el número de elementos en la cola.
     * @return El tamaño de la cola.
     */
    public int tamano() {
        return elementos.size();
    }

    @Override
    public String toString() {
        return "ColaPrioridad (ordenada de menor a mayor prioridad): " + elementos.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Pruebas de la Cola de Prioridad ---");
        ColaPrioridad<String> cola = new ColaPrioridad<>();

        System.out.println("Encolando tareas...");
        cola.encolar("Tarea normal 1", 1);
        System.out.println(cola);
        cola.encolar("Tarea urgente", 5);
        System.out.println(cola);
        cola.encolar("Tarea de baja prioridad", 0);
        System.out.println(cola);
        cola.encolar("Tarea normal 2", 1);
        System.out.println(cola);
        cola.encolar("Tarea crítica", 10);
        System.out.println(cola);

        System.out.println("\nProcesando tareas en orden de prioridad:");
        while (!cola.estaVacia()) {
            Elemento<String> tarea = cola.desencolar();
            System.out.println("Atendiendo -> " + tarea);
            System.out.println("  Cola restante: " + cola);
        }
    }
}

