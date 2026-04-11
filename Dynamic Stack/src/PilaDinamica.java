public class PilaDinamica {
    /** Attribute declaration */
    private Nodo top;

    // Constructor with parameter
    public PilaDinamica(Nodo top) {
        this.top = null;
    }

    // Default constructor
    public PilaDinamica() {
    }

    /** Dev Methods */

    /**
     * Checks if the stack is empty by verifying if the top node is null
     * @return true if the stack is empty, false otherwise
     */
    public boolean estaVacia(){
        return top == null;
    }

    /**
     * Adds a new element to the top of the stack (push operation)
     * Creates a new node with the given data and places it at the top
     * @param dato the value to be inserted into the stack
     */
    public void push(int dato){
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = top;
        top = nuevo;
    }

    /**
     * Removes and returns the top element from the stack (pop operation)
     * Throws an exception if the stack is empty (underflow)
     * @return the value of the removed top element
     * @throws RuntimeException if the stack is empty
     */
    public int pop(){
        if (estaVacia()){
            throw new RuntimeException("UnderFlow: the stack is empty");
        }
        int valor = top.dato;
        top = top.siguiente;
        return valor;
    }

    /**
     * Returns the top element from the stack without removing it (peek operation)
     * Throws an exception if the stack is empty (underflow)
     * @return the value of the top element
     * @throws RuntimeException if the stack is empty
     */
    public int peek(){
        if (estaVacia()){
            throw new RuntimeException("UnderFlow: the stack is empty");
        }
        return top.dato;
    }
}
