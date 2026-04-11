import java.util.Stack;

public class VerificadorEquilibrio {

    public static boolean estaEquilibrado(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            } else if (c == ')' || c == '}' || c == ']') {

                if (pila.isEmpty()) {
                    return false;
                }

                char ultimo = pila.pop();

                if ((c == ')' && ultimo != '(') ||
                    (c == '}' && ultimo != '{') ||
                    (c == ']' && ultimo != '[')) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    public static void main(String[] args) {
        String exp1 = "((a+b)*5) - 7";
        String exp2 = "2[(a+b)/2.5 + x - 7*y";

        System.out.println(estaEquilibrado(exp1));
        System.out.println(estaEquilibrado(exp2));
    }
}