package EJERCICIOS;

public class ConcatenarListas {

	static class Nodo<T> {
		T dato;               // Valor almacenado en el nodo
		Nodo<T> siguiente;    // Referencia al siguiente nodo en la lista

		public Nodo(T dato) {
			this.dato = dato;
			this.siguiente = null;
		}
	}

	public static <T> Nodo<T> concatenarListas(Nodo<T> cabeza1, Nodo<T> cabeza2) {
		if (cabeza1 == null) {      // Si la primera lista está vacía, se retorna la segunda
			return cabeza2;
		}

		Nodo<T> actual = cabeza1;     // Se recorre la primera lista hasta llegar al último nodo
		while (actual.siguiente != null) {
			actual = actual.siguiente;
		}

		actual.siguiente = cabeza2;  // Se enlaza el último nodo de la primera lista con la cabeza de la segunda

		return cabeza1;     // Se retorna la cabeza de la lista resultante (que es la primera)
	}

	public static void main(String[] args) {
		Nodo<String> listaA = new Nodo<>("X");
		listaA.siguiente = new Nodo<>("Y");

		Nodo<String> listaB = new Nodo<>("Z");
		Nodo<String> listaConcatenada = concatenarListas(listaA, listaB);

		Nodo<String> actual = listaConcatenada;
		while (actual != null) {
			System.out.print(actual.dato + " -> ");
			actual = actual.siguiente;
		}
		System.out.println("null");
	}
}
