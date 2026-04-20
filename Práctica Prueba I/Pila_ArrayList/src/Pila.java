import java.util.ArrayList;


public class Pila {
    /**Attributes Declaration*/
    private ArrayList elementos = new ArrayList<>();

    /** Constructors & Destructors*/
    public Pila(ArrayList elementos) {
        this.elementos = elementos;
    }

    public Pila() {
    }
    /**Setters & Getters*/
    public ArrayList getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList elementos) {
        this.elementos = elementos;
    }

    /**Dev Methods*/

    //Do push
    public void push(int elemento){
        elementos.add(elemento);
    }

    // Do pop
    public int pop() {
        if (elementos.isEmpty()) {
            //throw new RuntimeException("Error: Underflow. La pila está vacía.");
            System.out.println("Error: Underflow. La pila está vacía.");
            return -1; // Retorna un valor especial para indicar error
        }
        return (int) elementos.remove(elementos.size() - 1); //remove es para pilas, el index es el tamaño -1 porque el indice empieza en 0
    }

    // Do peek
    public int peek() {
        if (elementos.isEmpty()) {
            throw new RuntimeException("Error: Underflow. La pila está vacía.");
        }
        return (int) elementos.get(elementos.size() - 1); //get es para pilas, el index es el tamaño -1 porque el indice empieza en 0
    }

    // Do isEmpty
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    // Do tamaño
    public int tamaño() {
        return elementos.size();
    }


}
