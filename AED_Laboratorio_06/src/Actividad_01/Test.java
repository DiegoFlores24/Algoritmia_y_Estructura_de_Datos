package Actividad_01;

public class Test {
	public static void main(String[] args) {
		try {
            // Crea una pila de enteros con capacidad 5
			Stack<Integer> pila = new StackArray<>(5);
			
			pila.push(1);
			pila.push(2);
			pila.push(3);
			
            // Muestra el contenido actual de la pila (esperado: 3 2 1)
			System.out.println("La pila contiene: " + pila);
            // Muestra el elemento en el tope sin eliminarlo
            System.out.println("Elemento en el tope: " + pila.top()); 
            
            pila.pop();  // Elimina el elemento en el tope (3)
            System.out.println("Después del pop: " + pila); // Muestra la pila luego del pop (esperado: 2 1)
            
            // Agrega más elementos hasta llenarla
            pila.push(4);
            pila.push(5);
            pila.push(6);
            
            // Muestra el estado final de la pila
            System.out.println("La pilla esta llena: " + pila);
		}catch(ExceptionIsEmpty e) {
			System.out.println(e.getMessage());
		}
	}
}
