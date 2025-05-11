package Actividad_02;
import Actividad_01.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {  
    private Node<E> first; // Apunta al primer elemento (frente de la cola)
    private Node<E> last;  // Apunta al último elemento insertado
	   
	public QueueLink(){ 
	   this.first = null; 
	   this.last = null; 
	}
	
    // Inserta un elemento al final de la cola
	@Override
    public void enqueue(E x) {
        Node<E> newNode = new Node<>(x); // Crear nuevo nodo con el dato
        if (isEmpty()) {
            first = newNode; // Si está vacía, el nuevo nodo es el primero
        } else {
            last.setNext(newNode); // Si no, enlaza al final de la cola
        }
        last = newNode; // El nuevo nodo siempre es el último
    }
	
    // Elimina y retorna el elemento del frente
	 @Override
	 public E dequeue() throws ExceptionIsEmpty {
		 if (isEmpty()) {
			 throw new ExceptionIsEmpty("La cola está vacía");
		 }
	        E data = first.getData(); // Obtener el dato del frente
	        first = first.getNext();  // Avanzar el frente
		 if (first == null) {
	            last = null; // Si quedó vacía, también actualizar last
		 }
		 return data;
	 }
	
	// Retorna el elemento en el frente sin eliminarlo
	@Override
	public E front() throws ExceptionIsEmpty {
	    if (isEmpty()) {
	        throw new ExceptionIsEmpty("La cola está vacía");
	    }
	    return first.getData();
	}
	  
    // Retorna el último elemento insertado
	@Override
	public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return last.getData();
    } 
	
    // Verifica si la cola está vacía
	@Override
	public boolean isEmpty() {
		return first == null;
	}
	
    // Devuelve una representación en texto de la cola desde el frente hasta el último
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = first;
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return sb.toString().trim();
    }
		   
}
