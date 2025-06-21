package btree;
import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
	protected ArrayList<E> keys;
	protected ArrayList<BNode<E>> childs;
	protected int count;
	private int idNode; 
	private static int nextId = 0;
	
	public BNode(int n) {
		this.idNode =nextId++;
		this.keys = new ArrayList<E>(n);
		this.childs = new ArrayList<BNode<E>>(n);
		this.count = 0;
		for(int i=0; i < n; i++) {
			this.keys.add(null);
			this.childs.add(null);
		}
	}
	
	// Retorna true si el nodo está lleno (count == max claves posibles)
    public boolean nodeFull(int maxKeys) {
        return count == maxKeys;
    }
	
    // Retorna true si el nodo está vacío (sin claves)
    public boolean nodeEmpty() {
        return count == 0;
    }
	
    /**
     * Busca la clave en el nodo actual. Si la encuentra retorna true y la posición de la clave.
     * Si no, retorna false y la posición del hijo donde debe continuar la búsqueda.
     */
    public boolean searchNode(E key, int[] pos) {
        int i = 0;
        while (i < count && key.compareTo(keys.get(i)) > 0) {
            i++;
        }
        pos[0] = i;
        if (i < count && key.compareTo(keys.get(i)) == 0) {
            return true;
        }
        return false;
    }

 // Devuelve una representación en cadena del nodo: id y claves
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nodo ").append(idNode).append(": ");
        for (int i = 0; i < count; i++) {
            sb.append(keys.get(i)).append(" ");
        }
        return sb.toString().trim();
    }

    public int getIdNode() {
        return idNode;
    }
    
    public void setIdNode(int id) {
        try {
            java.lang.reflect.Field f = this.getClass().getDeclaredField("idNode");
            f.setAccessible(true);
            f.setInt(this, id);
        } catch (Exception e) {
            System.out.println("No se pudo establecer idNode manualmente: " + e.getMessage());
        }
    }

}
