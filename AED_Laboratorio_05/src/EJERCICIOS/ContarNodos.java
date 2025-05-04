package EJERCICIOS;

public class ContarNodos {  
	static class Nodo<T> {  
		T dato;               // Valor almacenado en el nodo
		Nodo<T> siguiente;    // Referencia al siguiente nodo en la lista

		public Nodo(T dato) {  
			this.dato = dato;  
			this.siguiente = null;  
		}  
	}  

	public static <T> int contarNodos(Nodo<T> cabeza) {  
		int contador = 0;               // Variable para llevar la cuenta de nodos
		Nodo<T> actual = cabeza;        // Nodo actual para recorrer la lista

		while (actual != null) {       // Recorre la lista mientras el nodo actual no sea null
			contador++;                 // Incrementa el contador por cada nodo encontrado
			actual = actual.siguiente;  // Avanza al siguiente nodo
		}  

		return contador;       // Devuelve el número total de nodos encontrados
	}  

	public static void main(String[] args) {  
		Nodo<String> cabeza = new Nodo<>("A");  
		cabeza.siguiente = new Nodo<>("B");  
		cabeza.siguiente.siguiente = new Nodo<>("C");  

		System.out.println("Cantidad de nodos que hay en la lista enlazada es: " + contarNodos(cabeza) + " nodos ");  
	}  
}

