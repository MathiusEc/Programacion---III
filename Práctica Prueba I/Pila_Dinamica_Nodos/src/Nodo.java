public class Nodo {
    /** Attribute Declaration*/
    private int dato;
    private Nodo siguiente;

    /**Constructors & Destructors*/
    public Nodo(int dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Nodo() {
    }

    /**Setters & Getters*/
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
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
