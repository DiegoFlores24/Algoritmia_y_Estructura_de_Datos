package Actividad_02;
import Actividad_01.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            Queue<String> cola = new QueueLink<>();             // Crear una cola de tipo String

            cola.enqueue("A");
            cola.enqueue("B");
            cola.enqueue("C");

            System.out.println("Contenido de la cola: " + cola);   // Mostrar los elementos actuales de la cola (FIFO: A B C)
            System.out.println("Frente: " + cola.front());  // Mostrar el primer elemento (sin eliminarlo)
            System.out.println("Último: " + cola.back());   // Mostrar el último elemento insertado

            // Eliminar el primer elemento (A)
            cola.dequeue();
            System.out.println("Después de un dequeue: " + cola); 

            cola.enqueue("D");
            cola.enqueue("E");

            // Mostrar la cola final
            System.out.println("Cola final: " + cola); 

        } catch (ExceptionIsEmpty e) {
            // Captura y muestra el mensaje de error si se opera sobre cola vacía
            System.out.println(e.getMessage());
        }
    }
}

