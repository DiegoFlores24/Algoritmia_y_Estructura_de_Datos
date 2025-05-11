package Ejercicio_02;
import Actividad_02.Queue; // importamos Queue de la actividad 2
import Actividad_01.ExceptionIsEmpty; // importamos la excepción de la actividad 01

public class Test {
    public static void main(String[] args) {
        try {
            // Crear una cola de tipo String con capacidad 5
            Queue<String> cola = new QueueArray<>(5);

            // Insertar elementos en la cola
            cola.enqueue("A");
            cola.enqueue("B");
            cola.enqueue("C");

            // Mostrar el contenido de la cola
            System.out.println("Cola: " + cola); // A B C

            // Mostrar el elemento al frente (A)
            System.out.println("Front: " + cola.front());

            // Mostrar el último elemento insertado (C)
            System.out.println("Back: " + cola.back());

            // Eliminar el elemento al frente (A)
            cola.dequeue();
            System.out.println("Después de dequeue: " + cola); // B C

            // Insertar más elementos
            cola.enqueue("D");
            cola.enqueue("E");
            cola.enqueue("F");  // Esto llena la cola

            // Mostrar la cola completa (circularmente llena)
            System.out.println("Cola llena: " + cola); // B C D E F

            // Descomenta esta línea para ver qué pasa si la cola está llena:
            // cola.enqueue("G"); // Lanza IllegalStateException

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

