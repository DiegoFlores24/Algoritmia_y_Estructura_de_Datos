package Actividad_03;
import Actividad_01.ExceptionIsEmpty;

//Interfaz genérica para una cola de prioridad
public interface PriorityQueue<E, N> {  
	 void enqueue(E x, N pr);      // Inserta un elemento con una prioridad asociada
	 E dequeue() throws ExceptionIsEmpty;     // Elimina y retorna el elemento con mayor prioridad
	 E front() throws ExceptionIsEmpty;     // Retorna el primer elemento (mayor prioridad) sin eliminarlo
	 E back() throws ExceptionIsEmpty;     // Retorna el último elemento insertado sin eliminarlo
	 boolean isEmpty();     // Verifica si la cola está vacía
}  