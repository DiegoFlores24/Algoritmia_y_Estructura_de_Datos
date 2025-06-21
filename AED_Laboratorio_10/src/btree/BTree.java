package btree;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

import RegistroEstudiante.RegistroEstudiante; 

public class BTree<E extends Comparable<E>> {
	private BNode<E> root;
	private int orden;
	private boolean up;
	private BNode<E> nDes;
	
	public BTree(int orden){ 
		this.orden = orden;
		this.root = null;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void insert(E cl){ 
		up = false;
		E mediana;
		BNode<E> pnew;
		mediana = push(this.root, cl);
		if (up) {
			pnew = new BNode<E>(this.orden);
			pnew.count = 1;
			pnew.keys.set(0, mediana);
			pnew.childs.set(0, this.root);
			pnew.childs.set(1, nDes);
			this.root = pnew;
		}
	}
	
	
	private E push(BNode<E> current,E cl){
		int pos[] = new int[1];
		E mediana;
		if(current == null){
			up = true;
			nDes = null;
			return cl;
		}
		else{
			boolean fl;
			fl = current.searchNode(cl, pos);
			if(fl){
				System.out.println("Item duplicado\n");
				up = false;
				return null;
			}
			mediana = push(current.childs.get(pos[0]),cl);
			if(up){
				if(current.nodeFull(this.orden-1))
					mediana = dividedNode(current,mediana,pos[0]);
				else{
					up = false;
					putNode(current,mediana,nDes,pos[0]);
				}
			}
			return mediana;
		}
	}
	
	private void putNode(BNode<E> current,E cl,BNode<E> rd,int k){
		int i;
		for(i = current.count-1; i >= k; i--){ 
			current.keys.set(i+1,current.keys.get(i));
			current.childs.set(i+2,current.childs.get(i+1));
		}
		current.keys.set(k,cl);
		current.childs.set(k+1,rd);
		current.count++;
	}
	
	private E dividedNode(BNode<E> current,E cl,int k){ 
			BNode<E> rd = nDes;
			int i, posMdna;
			posMdna = (k <= this.orden/2) ? this.orden/2 : this.orden/2+1;
			nDes = new BNode<E>(this.orden);
			for(i = posMdna; i < this.orden-1; i++)
			{ nDes.keys.set(i-posMdna,current.keys.get(i));
			nDes.childs.set(i-posMdna+1,current.childs.get(i+1));
			}
			nDes.count = (this.orden - 1) - posMdna;
			current.count = posMdna;
			if(k <= this.orden/2)
			putNode(current,cl,rd,k);
			else
			putNode(nDes,cl,rd,k-posMdna);
			E median = current.keys.get(current.count-1);
			nDes.childs.set(0,current.childs.get(current.count));
			current.count--;
			return median;
	}
	
	public String toString(){ 
		String s = "";
		if (isEmpty())
			s += "BTree is empty...";
		else
			s = writeTree(this.root);
		return s;
	}
	
	private String writeTree(BNode<E> current){
	    StringBuilder sb = new StringBuilder();
	    if (current != null) {
	        sb.append(current.toString()).append("\n");
	        for (int i = 0; i <= current.count; i++) {
	            BNode<E> child = current.childs.get(i);
	            if (child != null) {
	                sb.append(writeTree(child));
	            }
	        }
	    }
	    return sb.toString();
	}
	
	public boolean search(E cl) {
	    return search(this.root, cl);
	}
	
	private boolean search(BNode<E> node, E cl) {
	    if (node == null) return false;

	    int i = 0;
	    // Buscar la clave dentro del nodo
	    while (i < node.count && cl.compareTo(node.keys.get(i)) > 0) {
	        i++;
	    }

	    // Si la clave está en la posición i
	    if (i < node.count && cl.compareTo(node.keys.get(i)) == 0) {
	        System.out.println(cl + " se encuentra en el nodo " + node.getIdNode() + " en la posición " + i);
	        return true;
	    }

	    // Si no hay hijos (nodo hoja), no se encuentra
	    if (node.childs.get(i) == null) {
	        return false;
	    }

	    // Buscar recursivamente en el hijo correspondiente
	    return search(node.childs.get(i), cl);
	}
	
	public void remove(E cl) {
	    if (!remove(this.root, cl)) {
	        System.out.println(cl + " no se encontró en el árbol.");
	    } else if (this.root.count == 0 && this.root.childs.get(0) != null) {
	        // Si la raíz quedó vacía, subir el subárbol
	        this.root = this.root.childs.get(0);
	    }
	}

	private boolean remove(BNode<E> node, E cl) {
	    if (node == null) return false;

	    int i = 0;
	    while (i < node.count && cl.compareTo(node.keys.get(i)) > 0) {
	        i++;
	    }

	    // Caso 1: Clave encontrada
	    if (i < node.count && cl.compareTo(node.keys.get(i)) == 0) {
	        if (node.childs.get(0) == null) {
	            // Caso 1a: Nodo hoja → eliminar directamente
	            for (int j = i; j < node.count - 1; j++) {
	                node.keys.set(j, node.keys.get(j + 1));
	            }
	            node.keys.set(node.count - 1, null);
	            node.count--;
	            return true;
	        } else {
	            // Caso 1b: Nodo interno → buscar antecesor
	            BNode<E> pred = node.childs.get(i);
	            while (pred.childs.get(pred.count) != null) {
	                pred = pred.childs.get(pred.count);
	            }
	            E predKey = pred.keys.get(pred.count - 1);
	            node.keys.set(i, predKey);
	            return remove(node.childs.get(i), predKey);
	        }
	    }

	    // Caso 2: Clave no está en este nodo
	    if (node.childs.get(i) == null) return false;

	    boolean result = remove(node.childs.get(i), cl);

	    // Verificar subárbol hijo después de eliminar
	    if (node.childs.get(i).count < (orden - 1) / 2) {
	        fix(node, i);
	    }

	    return result;
	}

	private void fix(BNode<E> parent, int i) {
	    BNode<E> left = (i > 0) ? parent.childs.get(i - 1) : null;
	    BNode<E> current = parent.childs.get(i);
	    BNode<E> right = (i < parent.count) ? parent.childs.get(i + 1) : null;

	    // Intentar redistribuir desde la izquierda
	    if (left != null && left.count > (orden - 1) / 2) {
	        for (int j = current.count; j > 0; j--) {
	            current.keys.set(j, current.keys.get(j - 1));
	            current.childs.set(j + 1, current.childs.get(j));
	        }
	        current.childs.set(1, current.childs.get(0));
	        current.keys.set(0, parent.keys.get(i - 1));
	        current.childs.set(0, left.childs.get(left.count));
	        current.count++;

	        parent.keys.set(i - 1, left.keys.get(left.count - 1));
	        left.keys.set(left.count - 1, null);
	        left.childs.set(left.count, null);
	        left.count--;
	    }
	    // Intentar redistribuir desde la derecha
	    else if (right != null && right.count > (orden - 1) / 2) {
	        current.keys.set(current.count, parent.keys.get(i));
	        current.childs.set(current.count + 1, right.childs.get(0));
	        current.count++;

	        parent.keys.set(i, right.keys.get(0));

	        for (int j = 0; j < right.count - 1; j++) {
	            right.keys.set(j, right.keys.get(j + 1));
	            right.childs.set(j, right.childs.get(j + 1));
	        }
	        right.childs.set(right.count - 1, right.childs.get(right.count));
	        right.keys.set(right.count - 1, null);
	        right.childs.set(right.count, null);
	        right.count--;
	    }
	    // Fusión
	    else {
	        if (left != null) {
	            // Fusionar con la izquierda
	            left.keys.set(left.count++, parent.keys.get(i - 1));
	            for (int j = 0; j < current.count; j++) {
	                left.keys.set(left.count++, current.keys.get(j));
	            }
	            for (int j = 0; j <= current.count; j++) {
	                left.childs.set(left.count + j, current.childs.get(j));
	            }

	            for (int j = i - 1; j < parent.count - 1; j++) {
	                parent.keys.set(j, parent.keys.get(j + 1));
	                parent.childs.set(j + 1, parent.childs.get(j + 2));
	            }
	            parent.keys.set(parent.count - 1, null);
	            parent.childs.set(parent.count, null);
	            parent.count--;
	        } else if (right != null) {
	            // Fusionar con la derecha
	            current.keys.set(current.count++, parent.keys.get(i));
	            for (int j = 0; j < right.count; j++) {
	                current.keys.set(current.count++, right.keys.get(j));
	            }
	            for (int j = 0; j <= right.count; j++) {
	                current.childs.set(current.count + j, right.childs.get(j));
	            }

	            for (int j = i; j < parent.count - 1; j++) {
	                parent.keys.set(j, parent.keys.get(j + 1));
	                parent.childs.set(j + 1, parent.childs.get(j + 2));
	            }
	            parent.keys.set(parent.count - 1, null);
	            parent.childs.set(parent.count, null);
	            parent.count--;
	        }
	    }
	}

	public static BTree<Integer> building_Btree(String path) throws Exception {
	    BufferedReader br = new BufferedReader(new FileReader(path));
	    int orden = Integer.parseInt(br.readLine().trim());
	    BTree<Integer> tree = new BTree<>(orden);

	    Map<Integer, BNode<Integer>> nodos = new HashMap<>();
	    Map<Integer, int[]> raw = new LinkedHashMap<>();
	    String linea;

	    while ((linea = br.readLine()) != null) {
	        String[] partes = linea.split(",");
	        int[] datos = new int[partes.length];
	        for (int i = 0; i < partes.length; i++) {
	            datos[i] = Integer.parseInt(partes[i].trim());
	        }
	        raw.put(datos[1], datos); // clave: idNode
	    }
	    br.close();

	    // Crear nodos
	    for (Map.Entry<Integer, int[]> entrada : raw.entrySet()) {
	        int id = entrada.getKey();
	        int[] datos = entrada.getValue();

	        BNode<Integer> nodo = new BNode<>(orden);
	        nodo.count = datos.length - 2;
	        for (int i = 2; i < datos.length; i++) {
	            nodo.keys.set(i - 2, datos[i]);
	        }
	        nodo.setIdNode(id); // Asegura que el idNode sea consistente con el archivo
	        nodos.put(id, nodo);
	    }

	    // Asignar conexiones específicas
	    nodos.get(6).childs.set(0, nodos.get(2));
	    nodos.get(6).childs.set(1, nodos.get(5));

	    nodos.get(2).childs.set(0, nodos.get(0));
	    nodos.get(2).childs.set(1, nodos.get(1));
	    nodos.get(2).childs.set(2, nodos.get(3));

	    nodos.get(5).childs.set(0, nodos.get(4));
	    nodos.get(5).childs.set(1, nodos.get(8));
	    nodos.get(5).childs.set(2, nodos.get(7));

	    tree.root = nodos.get(6);
	    return tree;
	}
	
	public String buscarNombre(int codigo) {
	    return buscarNombreRecursivo(this.root, codigo);
	}

	private String buscarNombreRecursivo(BNode<E> node, int codigo) {
	    if (node == null) return "No encontrado";

	    int i = 0;
	    while (i < node.count && codigo > ((RegistroEstudiante) node.keys.get(i)).getCodigo()) {
	        i++;
	    }

	    if (i < node.count && codigo == ((RegistroEstudiante) node.keys.get(i)).getCodigo()) {
	        return ((RegistroEstudiante) node.keys.get(i)).getNombre();
	    }

	    return buscarNombreRecursivo(node.childs.get(i), codigo);
	}
}
