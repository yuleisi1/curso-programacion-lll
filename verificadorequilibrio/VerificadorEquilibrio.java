package verificadorequilibrio;

import java.util.Stack;

public class VerificadorEquilibrio {

    public static boolean estaEquilibrado(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            }
            
            else if (c == ')' || c == '}' || c == ']') {

                if (pila.isEmpty()) {
                    return false;
                }

                char ultimo = pila.pop();

                if (!esPareja(ultimo, c)) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    public static boolean esPareja(char a, char b) {
        if (a == '(' && b == ')') return true;
        if (a == '{' && b == '}') return true;
        if (a == '[' && b == ']') return true;
        return false;
    }

    public static void main(String[] args) {

        String exp1 = "((a+b)*5) - 7";
        String exp2 = "2[(a+b)/2.5 + x - 7*y";

        if (estaEquilibrado(exp1)) {
            System.out.println("Expresión 1 equilibrada");
        } else {
            System.out.println("Expresión 1 NO equilibrada");
        }

        if (estaEquilibrado(exp2)) {
            System.out.println("Expresión 2 equilibrada");
        } else {
            System.out.println("Expresión 2 NO equilibrada");
        }
    }
}