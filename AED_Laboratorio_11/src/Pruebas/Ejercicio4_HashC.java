package Pruebas;
import hash.HashC;
import hash.Register;

public class Ejercicio4_HashC {
	public static void main(String[] args) {
		HashC tabla = new HashC(7);

		System.out.println("--- Inserción inicial ---");
		tabla.insert(new Register(5, "A"));
		tabla.insert(new Register(12, "B"));
		tabla.insert(new Register(19, "C"));
		tabla.printTable();

		System.out.println("\n--- Eliminando clave 12 ---");
		tabla.delete(12);
		tabla.printTable();

		System.out.println("\n--- Búsqueda de clave 19 ---");
		Register r = tabla.search(19);
		System.out.println(r != null ? "Encontrado: " + r : "No encontrado");

		System.out.println("\n--- Explicación ---");
		System.out.println("La eliminación es lógica, por lo que la celda de la clave 12 se marca como disponible.");
		System.out.println("Esto permite que la búsqueda de claves que fueron desplazadas (como 19) siga funcionando correctamente.");
		System.out.println("\nDiferencia entre eliminación lógica y física:");
		System.out.println("- Lógica: marca la posición como disponible sin remover físicamente el objeto (se puede seguir sondeando).");
		System.out.println("- Física: borra completamente el objeto, lo que puede romper el recorrido por sondeo.");
	}
}
