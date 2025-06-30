package hash;

import java.util.LinkedList;

public class Hash0 {
	private LinkedList<Register>[] table;
	private int size;
	
	public Hash0(int size) {
		this.size = size;
		this.table = new LinkedList[size];
		// TODO: Inicializar cada posición con una nueva lista enlazada vacía 
		for (int i = 0; i < size; i++) {
			table[i] = new LinkedList<>();
		}
	}
	
	private int hash(int key) {
		// TODO: Calcular el índice hash cuando key % size
		return key % size;
	}
	
	public void insert(Register reg) {
		// TODO: Insertar el registro en la tabla correspondiente
		int pos =hash(reg.getKey());
		table[pos].add(reg);
	}
	
	public Register search(int key) {
		// TODO: Buscar el registro en la lista correspondiente
		int pos = hash(key);
		for(Register reg: table[pos]) {
			if(reg.getKey() == key) {
				return reg;
			}
		}
		return null;
	}
	
	public void delete(int key) {
		// TODO: Buscar y eliminar el registro de la lista correspondiente
		int pos = hash(key);
		table[pos].removeIf(reg->reg.getKey() == key);
	}
	
	public void printTable() {
		// TODO: Implementar cada lista de la tabla con sus registros
		for (int i = 0; i < size; i++) {
			System.out.print("[" + i + "]: ");
			if (table[i].isEmpty()) {
				System.out.println("vacío");
			} else {
				for (Register reg : table[i]) {
					System.out.print(reg + " -> ");
				}
				System.out.println("null");
			}
		}
	}
}
