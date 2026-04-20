public class Pila_LinkedList_Manual {
    /**Atributions Declaration*/
    private Nodo tope; // Referencia al nodo superior de la pila

    /**Constructors & Destructors*/
    public Pila_LinkedList_Manual(Nodo tope) {
        this.tope = tope;
    }

    public Pila_LinkedList_Manual() {
    }

    /**Setters & Getters*/
    public Nodo getTope() {
        return tope;
    }

    public void setTope(Nodo tope) {
        this.tope = tope;
    }

    /**Dev Methods*/

    // Agregar al tope
    public void push(int valor) {
        Nodo nuevoNodo = new Nodo(valor, tope); // Crear un nuevo nodo que apunte al nodo actual
        tope = nuevoNodo; // Actualizar el tope para que apunte al nuevo nodo
    }

    // Remover del tope
    public int pop() {
        if (tope == null) {
            System.out.println("Error: Pila vacía. No se puede hacer pop.");
            return -1; // Retornar -1 para indicar error
        }
        int valor = tope.getDato(); // Obtener el valor del nodo superior
        tope = tope.getSiguiente(); // Actualizar el tope para que apunte al siguiente nodo
        return valor; // Retornar el valor del nodo que se ha removido
    }

    // Imprimir todos los elementos de arriba hacia abajo
    public void mostrar() {
        Nodo actual = tope; // Empezar desde el tope
        System.out.println("Pila (de arriba hacia abajo):");
        while (actual != null) {
            System.out.println("- " + actual.getDato()); // Imprimir el dato del nodo actual
            actual = actual.getSiguiente(); // Mover al siguiente nodo
        }
    }

    // Retornar true si está vacía
    public boolean estaVacia() {
        return tope == null; // La pila está vacía si el tope es null
    }


}
