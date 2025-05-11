package Actividad_02;
import Actividad_01.ExceptionIsEmpty; //Importamos la excepción ExceptionIsEmpty

//Interfaz genérica que define las operaciones fundamentales de una cola
public interface Queue <E>{
	void enqueue(E x);    // Inserta un elemento al final de la cola
	E dequeue() throws ExceptionIsEmpty;     // Elimina y retorna el elemento al frente de la cola
	E front() throws ExceptionIsEmpty;     // Retorna el elemento al frente sin eliminarlo
	E back() throws ExceptionIsEmpty;     // Retorna el último elemento insertado sin eliminarlo
	boolean isEmpty();    // Verifica si la cola está vacía
}
