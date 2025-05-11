package Actividad_01;

//Interfaz genérica que define las operaciones de una pila
public interface Stack<E> {

 void push(E x); // Inserta un elemento en el tope de la pila

 E pop() throws ExceptionIsEmpty; // Elimina y retorna el elemento del tope de la pila

 E top() throws ExceptionIsEmpty; // Retorna el elemento en el tope sin eliminarlo

 boolean isEmpty(); // Verifica si la pila está vacía
}

