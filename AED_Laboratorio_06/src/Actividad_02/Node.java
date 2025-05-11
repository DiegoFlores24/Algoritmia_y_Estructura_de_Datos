package Actividad_02;

public class Node<E> {  // Clase genérica que representa un nodo en una lista enlazada
    private E data; // Dato que almacena el nodo
    private Node<E> next;// Referencia al siguiente nodo

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
    
    // Retorna el dato almacenado en el nodo
    public E getData() {
        return data;
    }

    // Retorna el nodo siguiente
    public Node<E> getNext() {
        return next;
    }

    // Establece el nodo siguiente
    public void setNext(Node<E> next) {
        this.next = next;
    }
}
