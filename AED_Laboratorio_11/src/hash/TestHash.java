package hash;

public class TestHash {
	public static void main(String[] args) {
		HashC tabla = new HashC(10);

		// Insertar registros
		tabla.insert(new Register(34, "Luis"));
		tabla.insert(new Register(3, "Ana"));
		tabla.insert(new Register(7, "Carlos"));
		tabla.insert(new Register(30, "Elena"));
		tabla.insert(new Register(11, "María"));
		tabla.insert(new Register(8, "Pedro"));
		tabla.insert(new Register(7, "Carlos2")); // Clave duplicada
		tabla.insert(new Register(23, "Lucía"));
		tabla.insert(new Register(41, "Diego"));
		tabla.insert(new Register(16, "Sara"));
		tabla.insert(new Register(34, "Luis2")); // Clave duplicada

		System.out.println("\nTabla hash después de inserciones:");
		tabla.printTable();

		// Eliminar clave 30
		tabla.delete(30);
		System.out.println("\nTabla hash después de eliminar la clave 30:");
		tabla.printTable();

		// Buscar clave 23
		Register resultado = tabla.search(23);
		System.out.println("\nResultado de la búsqueda de la clave 23:");
		System.out.println(resultado != null ? resultado : "No encontrado");
	}
}