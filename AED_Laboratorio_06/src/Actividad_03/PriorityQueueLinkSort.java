package Actividad_03;
import Actividad_01.ExceptionIsEmpty;
import Actividad_02.Node;

// Clase interna que representa una entrada con dato y prioridad
public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return data + "(" + priority + ")";
        }
    }

    private Node<EntryNode> first;  // Apunta al primer nodo (mayor prioridad)
    private Node<EntryNode> last;   // Apunta al último nodo insertado

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    // Inserta un nuevo elemento ordenado según su prioridad (mayor prioridad al frente)
    @Override
    public void enqueue(E x, N pr) {
        EntryNode newEntry = new EntryNode(x, pr);
        Node<EntryNode> newNode = new Node<>(newEntry);

        if (isEmpty()) {
            // Si está vacía, el nuevo nodo es el primero y el último
            first = newNode;
            last = newNode;
        } else if (pr.compareTo(first.getData().priority) > 0) {
            // Si la nueva prioridad es mayor que la del primer nodo, insertar al inicio
            newNode.setNext(first);
            first = newNode;
        } else {
            // Buscar posición adecuada manteniendo orden descendente de prioridad
            Node<EntryNode> current = first;
            Node<EntryNode> previous = null;

            // Mientras la nueva prioridad sea menor o igual, avanza
            while (current != null && pr.compareTo(current.getData().priority) <= 0) {
                previous = current;
                current = current.getNext();
            }

            // Inserta el nodo entre previous y current
            newNode.setNext(current);
            previous.setNext(newNode);

            // Si se insertó al final, actualizar last
            if (newNode.getNext() == null) {
                last = newNode;
            }
        }
    }

    // Elimina y retorna el elemento con mayor prioridad
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        E data = first.getData().data;
        first = first.getNext();
        if (first == null) last = null;
        return data;
    }

    // Retorna el primer elemento (mayor prioridad) sin eliminarlo
    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return first.getData().data;
    }

    // Retorna el último elemento insertado sin eliminarlo
    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return last.getData().data;
    }

    // Verifica si la cola está vacía
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    // Representación en texto de la cola (de mayor a menor prioridad)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<EntryNode> current = first;
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return sb.toString().trim();
    }
}

