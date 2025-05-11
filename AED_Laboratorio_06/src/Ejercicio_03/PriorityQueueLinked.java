package Ejercicio_03;
import Actividad_01.ExceptionIsEmpty;
import Actividad_02.QueueLink;
import Actividad_03.PriorityQueue;

public class PriorityQueueLinked<E> implements PriorityQueue<E, Integer> {

    private QueueLink<E>[] queues;
    private int numPriorities;

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int numPriorities) {
        this.numPriorities = numPriorities;
        this.queues = new QueueLink[numPriorities];

        for (int i = 0; i < numPriorities; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    @Override
    public void enqueue(E x, Integer pr) {
        if (pr < 0 || pr >= numPriorities) {
            throw new IllegalArgumentException("Prioridad inválida: " + pr);
        }
        queues[pr].enqueue(x);
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía");
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].front();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía");
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        for (int i = numPriorities - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].back();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía");
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Colas por prioridad:\n");
        for (int i = 0; i < numPriorities; i++) {
            sb.append("Prioridad ").append(i).append(": ").append(queues[i].toString()).append("\n");
        }
        return sb.toString();
    }
}

