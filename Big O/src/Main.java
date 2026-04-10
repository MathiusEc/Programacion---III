import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Declaración de Objetos*/
        Scanner sc = new Scanner(System.in);

        /** Declaración de Variables */
        int num1;
        int acum = 0;

        /** Ingresar Datos*/
        System.out.println("Welcome to the algorithm of Big O(n^3)");
        System.out.println("Choose the numbers to ilustrate the problem");
        num1 = sc.nextInt();

        // Outer loop: Level 1
        for (int i = 0; i <= num1; i++) {
            //Middle Loop: Level 2
            for (int j = 0; j <=i ; j++) {
                //Inner Loop: Level 3
                for (int k = 0; k <= j; k++) {
                    acum++;
                    System.out.println("Iterations");
                    System.out.println("i = "+i+" ;j ="+j);

                }

            }

        }
        // Output
        System.out.println("To reach the "+num1+ " number the algorith reach "+acum+ " operations");
    }
}