public class Nodo {
    /** Attribute Declaration*/
    private char dato;
    private Nodo siguiente;

    /**Constructors & Destructors*/
    public Nodo(char dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Nodo() {
    }

    /**Setters & Getters*/
    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    /** Dev Methods*/

}
