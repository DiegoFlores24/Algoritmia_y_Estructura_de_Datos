package Actividad_03;
import Actividad_01.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            PriorityQueue<String, Integer> pq = new PriorityQueueLinkSort<>(); // Crear una cola de prioridad donde la prioridad es Integer

            pq.enqueue("Tarea 1", 2);
            pq.enqueue("Tarea 2", 5);
            pq.enqueue("Tarea 3", 1);
            pq.enqueue("Tarea 4", 3);
            pq.enqueue("Tarea 5", 5); // Igual prioridad que Tarea 2

            System.out.println("Cola de prioridad:\n" + pq);// Mostrar el contenido ordenado por prioridad (mayor a menor)

            // Mostrar el primer y último elemento
            System.out.println("Frente: " + pq.front()); 
            System.out.println("Último: " + pq.back()); 

            // Eliminar el de mayor prioridad (Tarea 2)
            pq.dequeue();
            System.out.println("Después de un dequeue:\n" + pq);     // Mostrar la cola después de un dequeue

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage()); // Manejo de excepción si la cola está vacía
        }
    }
}
