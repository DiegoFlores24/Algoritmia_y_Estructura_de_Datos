package hash;

public class HashC {
	private static class Element {
		Register register;
		boolean isAvailable;

		public Element() {
			this.register = null;
			this.isAvailable = true;
		}
	}
	
	private Element[] table;
	private int size;
	
	public HashC(int size) {
		// TODO: Inicializar el arreglo table con objetos Element vacíos 
		this.size = size;
		table = new Element[size];
		for (int i = 0; i < size; i++) {
			table[i] = new Element();
		}
	}
	
	private int hash(int key) {
		// TODO: Devolver el índice hash para la clave dada
		return key % size;
	}
	
	public void insert(Register reg) {
		// TODO: Implementar inserción de sondeo lineal 
		int pos = hash(reg.getKey());
		int startPos = pos;
		do {
			if (table[pos].register == null || table[pos].isAvailable) {
				table[pos].register = reg;
				table[pos].isAvailable = false;
				return;
			}
			pos = (pos + 1) % size;
		} while (pos != startPos);
		System.out.println("No hay espacio disponible en la tabla.");
 	}
	
	public Register search(int key) {
		// TODO: Implementar búsqueda de sondeo lineal
		int pos = hash(key);
		int startPos = pos;
		do {
			if (table[pos].register != null && !table[pos].isAvailable && table[pos].register.getKey() == key) {
				return table[pos].register;
			}
			if (table[pos].register == null && table[pos].isAvailable) {
				return null;
			}
			pos = (pos + 1) % size;
		} while (pos != startPos);
		return null;
	}
	
	public void delete(int key) {
		// TODO: Implementar eliminación lógica usando sondeo lineal
		int pos = hash(key);
		int startPos = pos;
		do {
			if (table[pos].register != null && !table[pos].isAvailable && table[pos].register.getKey() == key) {
				table[pos].isAvailable = true;
				table[pos].register = null;
				return;
			}
			pos = (pos + 1) % size;
		} while (pos != startPos);
	}
	
	public void printTable() {
		// TODO: Implementar impresión del contenido actual de la tabla
		for (int i = 0; i < size; i++) {
			if (table[i].register != null && !table[i].isAvailable) {
				System.out.println("[" + i + "]: " + table[i].register);
			} else {
				System.out.println("[" + i + "]: vacío");
			}
		}
	}
}
