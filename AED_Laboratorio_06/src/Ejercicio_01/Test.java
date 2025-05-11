package Ejercicio_01;
import Actividad_01.ExceptionIsEmpty;
import Actividad_01.Stack;
import Actividad_02.Node;

public class Test {
    public static void main(String[] args) {
        try {
            // Crear una pila de enteros con implementación StackLink
            Stack<Integer> pila = new StackLink<>();

            // Insertar elementos en la pila
            pila.push(10);
            pila.push(20);
            pila.push(30);

            System.out.println("Contenido de la pila: " + pila);  // Mostrar el contenido de la pila (LIFO: 30 20 10)

            System.out.println("Elemento en el tope: " + pila.top()); // Mostrar el elemento en el tope sin quitarlo

            pila.pop(); // Quitar el elemento en el tope

            // Mostrar la pila después del pop (debería ser 20 10)
            System.out.println("Después de un pop: " + pila);

            // Verificar si la pila está vacía
            System.out.println("¿Está vacía?: " + pila.isEmpty()); // false

        } catch (ExceptionIsEmpty e) {
            // Manejar error si se intenta operar sobre una pila vacía
            System.out.println("Error: " + e.getMessage());
        }
    }
}
