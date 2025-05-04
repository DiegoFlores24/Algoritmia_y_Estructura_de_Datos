package EJERCICIOS;

public class CompararListas {  
	static class Nodo<T> {  
		T dato;               // Valor que almacena el nodo
		Nodo<T> siguiente;    // Referencia al siguiente nodo en la lista

		public Nodo(T dato) {  
			this.dato = dato;  
			this.siguiente = null;  
		}  
	}  

	public static <T> boolean sonIguales(Nodo<T> cabeza1, Nodo<T> cabeza2) {  
		Nodo<T> actual1 = cabeza1;  // Nodo actual de la primera lista
		Nodo<T> actual2 = cabeza2;  // Nodo actual de la segunda lista

		while (actual1 != null && actual2 != null) {       // Recorre ambas listas al mismo tiempo
			if (!actual1.dato.equals(actual2.dato)) {  
				return false;  
         }  
			actual1 = actual1.siguiente;           // Avanza al siguiente nodo en ambas listas
			actual2 = actual2.siguiente;  
		}  

		return actual1 == null && actual2 == null;       // Si ambas listas terminaron al mismo tiempo, son iguales
	}  

	public static void main(String[] args) {  
		Nodo<String> lista1 = new Nodo<>("A");  
		lista1.siguiente = new Nodo<>("B");  

		Nodo<String> lista2 = new Nodo<>("A");  
		lista2.siguiente = new Nodo<>("B");  

		Nodo<String> lista3 = new Nodo<>("A");  
		lista3.siguiente = new Nodo<>("C");  

		System.out.println("La comparación de ambas listas es: " + sonIguales(lista1, lista2));   
		System.out.println("La comparación de ambas listas es: " + sonIguales(lista1, lista3));   
	}  
}
