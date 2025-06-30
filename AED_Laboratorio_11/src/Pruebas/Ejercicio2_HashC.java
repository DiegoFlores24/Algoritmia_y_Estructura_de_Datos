package Pruebas;
import hash.HashC;
import hash.Register;

public class Ejercicio2_HashC {
	public static void main(String[] args) {
		HashC tabla = new HashC(6);

		int[] valores = {12, 18, 24, 30};
		String[] nombres = {"A", "B", "C", "D"};

		System.out.println("--- Inserción paso a paso ---");
		for (int i = 0; i < valores.length; i++) {
			System.out.println("Insertando: " + valores[i] + " (" + nombres[i] + ")");
			tabla.insert(new Register(valores[i], nombres[i]));
			tabla.printTable();
			System.out.println();
		}

		System.out.println("\n--- Explicación ---");
		System.out.println("La función hash es h(x) = x % 6. Todos los valores tienen h(x) = 0.");
		System.out.println("Se produce una colisión en la posición 0 y el sondeo lineal busca la siguiente posición libre.");
		System.out.println("Los valores terminan en posiciones 0, 1, 2 y 3.");
	}
}
