package Pruebas;
import hash.Register;
import hash.HashC;

public class TestHash {
	public static void main(String[] args) {
		HashC tabla = new HashC(7);

		// Insertar registros
		tabla.insert(new Register(3, "Luis"));
		tabla.insert(new Register(10, "Ana"));
		tabla.insert(new Register(17, "Carlos"));
		tabla.insert(new Register(24, "Elena"));



		System.out.println("\nTabla hash después de inserciones:");
		tabla.printTable();

	}
}
