package hash;

import java.util.Scanner;

public class TestHashO {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el tamaño de la tabla hash: ");
		int size = scanner.nextInt();
		scanner.nextLine(); 
		Hash0 tabla = new Hash0(size);

		while (true) {
			System.out.println("\nOpciones:");
			System.out.println("1. Insertar registro");
			System.out.println("2. Buscar registro");
			System.out.println("3. Eliminar registro");
			System.out.println("4. Mostrar tabla");
			System.out.println("5. Salir");
			System.out.print("Seleccione una opción: ");
			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
				case 1:
					System.out.print("Ingrese la clave (entero): ");
					int key = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Ingrese el nombre: ");
					String name = scanner.nextLine();
					tabla.insert(new Register(key, name));
					break;
				case 2:
					System.out.print("Ingrese la clave a buscar: ");
					int searchKey = scanner.nextInt();
					Register result = tabla.search(searchKey);
					System.out.println(result != null ? "Encontrado: " + result : "No encontrado");
					break;
				case 3:
					System.out.print("Ingrese la clave a eliminar: ");
					int deleteKey = scanner.nextInt();
					tabla.delete(deleteKey);
					System.out.println("Registro eliminado.\n");
					break;
				case 4:
					tabla.printTable();
					break;
				case 5:
					scanner.close();
					System.out.println("Programa finalizado.");
					return;
				default:
					System.out.println("Opción no válida. Intente de nuevo.");
			}
		}
	}
}
