package Ejercicio_04;
import Actividad_01.Stack;
import Ejercicio_01.StackLink;
import Actividad_01.ExceptionIsEmpty;

public class Application {

    public static boolean symbolBalancing(String s) {
        Stack<Character> stack = new StackLink<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);  // Apila corchetes de apertura
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;  // No hay con qué cerrar
                }

                try {
                    char top = stack.pop();  // Desapila y verifica emparejamiento

                    if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                        return false;  // No hay coincidencia
                    }
                } catch (ExceptionIsEmpty e) {
                    return false;
                }
            }
        }

        return stack.isEmpty();  // Si hay algo en la pila al final, está mal
    }
}

