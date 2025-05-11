package Ejercicio_02;
import Actividad_02.Queue;
import Actividad_01.ExceptionIsEmpty;

public class QueueArray<E> implements Queue<E> {
    private E[] array;        // Arreglo que almacena los elementos de la cola
    private int first;        // Índice del primer elemento (frente)
    private int last;         // Índice del último elemento insertado
    private int size;         // Número de elementos actuales en la cola
    private int capacity;     // Tamaño máximo de la cola

    @SuppressWarnings("unchecked")
    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];  // Creación del arreglo genérico
        this.first = 0;
        this.last = -1;
        this.size = 0;
    }

    // Inserta un elemento al final de la cola
    @Override
    public void enqueue(E x) {
        if (isFull()) {
            throw new IllegalStateException("La cola está llena");
        }
        last = (last + 1) % capacity;  // Aritmética circular
        array[last] = x;
        size++;
    }

    // Elimina y retorna el elemento al frente de la cola
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        E data = array[first];
        array[first] = null;  // Limpieza (opcional)
        first = (first + 1) % capacity;  
        size--;
        return data;
    }

    // Retorna el elemento al frente sin eliminarlo
    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return array[first];
    }

    // Retorna el último elemento insertado sin eliminarlo
    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return array[last];
    }

    // Verifica si la cola está vacía
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Verifica si la cola alcanzó su capacidad máxima
    public boolean isFull() {
        return size == capacity;
    }

    // Muestra los elementos de la cola desde el frente hasta el final
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[(first + i) % capacity]).append(" ");
        }
        return sb.toString().trim();
    }
}

