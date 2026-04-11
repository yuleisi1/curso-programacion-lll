package cincopilas;

import java.util.Scanner;
import java.util.Stack;

public class CincoPilas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;

        Stack<Integer>[] pilas = new Stack[n];

        for (int k = 0; k < n; k++) {
            pilas[k] = new Stack<>();
        }

        int i, j;

        System.out.println("Ingrese pares (i, j). i=0 para terminar:");

        while (true) {
            System.out.print("i: ");
            i = sc.nextInt();

            if (i == 0) {
                break;
            }

            System.out.print("j: ");
            j = sc.nextInt();

            int indice = Math.abs(i) - 1;

            if (indice >= 0 && indice < n) {

                if (i > 0) {
                    
                    pilas[indice].push(j);
                    System.out.println("Insertado " + j + " en P" + (indice + 1));
                } else {
                   
                    if (!pilas[indice].isEmpty()) {
                        int eliminado = pilas[indice].pop();
                        System.out.println("Eliminado " + eliminado + " de P" + (indice + 1));
                    } else {
                        System.out.println("P" + (indice + 1) + " está vacía");
                    }
                }

            } else {
                System.out.println("Índice de pila inválido");
            }
        }

      
        System.out.println("\nContenido final de las pilas:");

        for (int k = 0; k < n; k++) {
            System.out.println("P" + (k + 1) + ": " + pilas[k]);
        }

        sc.close();
    }
}