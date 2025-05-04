package ACTIVIDAD;

class Nodo<T> {			//Clase genérica que representa un nodo de una lista enlazada simple
	T dato;               // Valor almacenado en el nodo
	Nodo<T> siguiente;    // Referencia al siguiente nodo en la lista

	public Nodo(T dato) {
		this.dato = dato;
		this.siguiente = null;
	}
}
