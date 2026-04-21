public class Pila {
    /** Attribute Declaration*/
    private Nodo tope;
    private int tamano;

    /** Constrcutors and Destructors*/
    public Pila() {
        this.tope = null;
        this.tamano = 0;
    }

    /**Getters & Setters*/
    public Nodo getTope() {
        return tope;
    }

    public void setTope(Nodo tope) {
        this.tope = tope;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    /**Dev Methods*/
    //push
    public void push(char elemento) {
        Nodo nuevoNodo = new Nodo(elemento, tope);
        tope = nuevoNodo;
        tamano++;
    }

    //pop
    public char pop() {
        if (!isEmpty()) {
            char elemento = tope.getDato();
            tope = tope.getSiguiente();
            tamano--;
            return elemento;
        } else {
            System.out.println("Pila vacía. No se puede eliminar ningún elemento.");
            return '\0'; // Retorna un carácter nulo para indicar que no se pudo realizar la operación
        }
    }

    //peek
    public char peek() {
        if (!isEmpty()) {
            return tope.getDato();
        } else {
            System.out.println("Pila vacía. No se puede obtener el elemento superior.");
            return '\0'; // Retorna un carácter nulo para indicar que no se pudo realizar la operación
        }
    }

    //isEmpty
    public boolean isEmpty() {
        return tope == null; //devuelve true si la pila está vacía, false en caso contrario
    }
}
