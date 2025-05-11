package Ejercicio_03;
import Actividad_03.PriorityQueue;
import Actividad_01.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            PriorityQueue<Integer, Integer> pq = new PriorityQueueLinked<>(4); // prioridades: 0, 1, 2, 3

            pq.enqueue(10, 0);
            pq.enqueue(26, 0);
            pq.enqueue(13, 0);
            pq.enqueue(35, 0);
            pq.enqueue(22, 2);
            pq.enqueue(3, 2);
            pq.enqueue(18, 2);
            pq.enqueue(29, 2);
            pq.enqueue(12, 2);
            pq.enqueue(34, 2);

            System.out.println(pq); // Muestra colas por prioridad

            System.out.println("Front: " + pq.front()); // primer elemento de mayor prioridad (10)
            System.out.println("Back: " + pq.back());   // último elemento de menor prioridad (34)

            pq.dequeue(); // elimina 10
            System.out.println("Después de un dequeue:\n" + pq);

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
