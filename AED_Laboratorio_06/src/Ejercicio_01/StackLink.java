package Ejercicio_01;
import Actividad_01.ExceptionIsEmpty;//Importamos la excepción de la actividad 1
import Actividad_02.Node;//Importamos la clase Node la actividad 2
import Actividad_01.Stack;// Importados la interface Stack de la actividad 1

public class StackLink<E> implements Stack<E> {
    private Node<E> top; // Nodo que representa el tope de la pila

    public StackLink() {
        this.top = null;
    }

    // Inserta un elemento en el tope de la pila
    @Override
    public void push(E x) {
        Node<E> newNode = new Node<>(x); // Crear nuevo nodo con el dato
        newNode.setNext(top);            // El nuevo nodo apunta al antiguo tope
        top = newNode;                   // El nuevo nodo se convierte en el tope
    }

    // Elimina y retorna el elemento en el tope de la pila
    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        E data = top.getData();        // Obtener el dato del tope
        top = top.getNext();           // Mover el tope al siguiente nodo
        return data;
    }

    // Retorna el dato en el tope sin eliminarlo
    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        return top.getData();
    }

    // Verifica si la pila está vacía
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    // Muestra los elementos de la pila desde el tope hacia el fondo
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = top;
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return sb.toString().trim();
    }
}
