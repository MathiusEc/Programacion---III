public class Busqueda {
    /** Declaración de Atributos */
    private int[] array;
    private int pasos;

    /**
     * Constructores & Destructores
     */
    public Busqueda(int[] array) {
        this.array = array;
        this.pasos = 0;
    }

    /** Setters & Getters*/
    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    /**Métodos del Programador*/

    // Busqueda Lineal: recorre el array secuencialmente
    public static int[] busquedaLineal(int[] array, int numero) {
        int pasos = 0;
        for (int i = 0; i < array.length; i++) {
            pasos++;
            if (array[i] == numero) {
                return new int[]{i, pasos};
            }
        }
        return new int[]{-1, pasos}; // No encontrado
    }



    // Busqueda Binaria: requiere array ordenado, divide el array en mitades
    public int[] busquedaBinaria(int numero) {
        pasos = 0;
        int izquierda = 0;
        int derecha = array.length - 1;

        while (izquierda <= derecha) {
            pasos++;
            int medio = izquierda + (derecha - izquierda) / 2;

            if (array[medio] == numero) {
                return new int[]{medio, pasos};
            } else if (array[medio] < numero) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return new int[]{-1, pasos}; // No encontrado
    }

    // Getter para obtener el número de pasos realizados en la última búsqueda
    public int getPasos() {
        return pasos;
    }
}
