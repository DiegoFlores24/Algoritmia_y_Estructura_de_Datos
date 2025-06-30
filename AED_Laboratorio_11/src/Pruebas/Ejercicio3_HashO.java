package Pruebas;
import hash.Register;
import hash.Hash0;


public class Ejercicio3_HashO {
	public static void main(String[] args) {
		Hash0 tabla = new Hash0(5);

		tabla.insert(new Register(10, "Juan"));
		tabla.insert(new Register(15, "Ana"));
		tabla.insert(new Register(20, "Luis"));
		tabla.insert(new Register(25, "Rosa"));

		System.out.println("--- Estado de la tabla hash (encadenamiento) ---");
		tabla.printTable();

		System.out.println("\n--- Búsqueda de clave 20 ---");
		Register resultado1 = tabla.search(20);
		System.out.println(resultado1 != null ? "Encontrado: " + resultado1 : "No encontrado");

		System.out.println("\n--- Búsqueda de clave 30 ---");
		Register resultado2 = tabla.search(30);
		System.out.println(resultado2 != null ? "Encontrado: " + resultado2 : "No encontrado");
	}
}

