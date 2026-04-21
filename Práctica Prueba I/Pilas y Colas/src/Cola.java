public class Cola {
    /** Attribute Declaration*/
    private Nodo frente;
    private Nodo fin;
    private int tamano;

    /** Constrcutors and Destructors*/
    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamano = 0;
    }

    /**Getters & Setters*/
    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    /**Dev Methods*/
    // enqueue
    public void enqueue(char elemento) {
        Nodo nuevoNodo = new Nodo(elemento, null);
        if (isEmpty()) {
            frente = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
        }
        fin = nuevoNodo;
        tamano++;
    }

    //dequeue
    public char dequeue() {
        if (!isEmpty()) {
            char elemento = frente.getDato();
            frente = frente.getSiguiente();
            if (frente == null) {
                fin = null;
            }
            tamano--;
            return elemento;
        } else {
            System.out.println("Cola vacía. No se puede eliminar ningún elemento.");
            return '\0'; // Retorna un carácter nulo para indicar que la cola está vacía
        }
    }

    //isEmpty
    public boolean isEmpty() {
        return frente == null;
    }
}
