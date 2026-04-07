import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        /*
         * Goal: receive a text string from the console and return it reversed
         * using a stack (java.util.Stack).
         *
         * */

        // Create a stack that will store elements of type String.
        // Note: we store Strings so it matches the parameterized type Stack<String>.
        Stack<String> cadena = new Stack<>();
        Scanner sc = new Scanner(System.in);

        // StringBuilder used to efficiently concatenate the reversed characters.
        StringBuilder invertida = new StringBuilder();

        System.out.println("Tell me something: ");
        String nombre = sc.nextLine();

        // Iterate over the original string character by character and push them onto the stack.
        // Convert each char to String because the stack stores Strings.
        // Here we use String.valueOf(char) but you could also use "" + nombre.charAt(i).
        for (int i = 0; i < nombre.length(); i++) {
            cadena.push(String.valueOf(nombre.charAt(i)));
        }

        // Now pop all elements. The stack returns the last inserted element first (LIFO),
        // so by popping we build the reversed string.
        while (!cadena.isEmpty()){
            invertida.append(cadena.pop());
        }

        // Print the reversed string. If the input was empty, the result will be empty.
        // Spaces and special characters are preserved in their relative reversed positions.
        System.out.println("Now is inverted....\n" + invertida);

        // Close the Scanner to free resources. Not strictly necessary in very short programs,
        // but it's good practice.
        sc.close();
    }
}