package bstreelinklistinterfgeneric;

//importaciones de las excepciones y la interface
import Exceptions.ExceptionIsEmpty; 
import Exceptions.ItemNotFound;
import Exceptions.ItemDuplicated;
import bstreeInterface.BinarySearchTree;

//Clase genérica que implementa un Árbol Binario de Búsqueda 
public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    public class Node {
        public E data;
        public Node left;
        public Node rigth;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node rigth) {
            this.data = data;
            this.left = left;
            this.rigth = rigth;
        }
    }

    protected Node root;
    public LinkedBST() {
        root = null;
    }
	
	//metodo insert
	public void insert(E data) throws ItemDuplicated {
        root = insert(root, data); // Llama al método privado recursivo
    }
	
	private Node insert(Node node, E data) throws ItemDuplicated { // método privado recursivo para insertar un dato en el lugar correcto
        if (node == null)
            return new Node(data);

        int cmp = data.compareTo(node.data);

        if (cmp < 0)
            node.left = insert(node.left, data);  // Insertar a la izquierda
        else if (cmp > 0)
            node.rigth = insert(node.rigth, data);
        else
            throw new ItemDuplicated("El dato ya existe: " + data); // Insertar a la derecha

        return node;
    }
	
	//metodo search
	public E search(E data) throws ItemNotFound {
        Node result = search(root, data);
        if (result == null)
            throw new ItemNotFound("Elemento no encontrado: " + data);
        return result.data;
    }
	
	private Node search(Node node, E data) { // método privado recursivo para buscar
        if (node == null)
            return null;

        int cmp = data.compareTo(node.data);

        if (cmp < 0)
            return search(node.left, data);
        else if (cmp > 0)
            return search(node.rigth, data);
        else
            return node;
    }
	
	//metodo delete
	public void delete(E data) throws ExceptionIsEmpty {
        if (root == null)
            throw new ExceptionIsEmpty("El árbol está vacío.");
        root = delete(root, data);
    }
	
	private Node delete(Node node, E data) { // Método privado recursivo para eliminar un nodo
        if (node == null)
            return null;

        int cmp = data.compareTo(node.data);

        if (cmp < 0)
            node.left = delete(node.left, data);
        else if (cmp > 0)
            node.rigth = delete(node.rigth, data);
        else {
            if (node.left == null && node.rigth == null) // Caso 1: sin hijos
                return null;
            if (node.left == null)             // Caso 2: un hijo
                return node.rigth;
            if (node.rigth == null)
                return node.left;
            // Caso 3: dos hijos - reemplazar con el menor del subárbol derecho
            Node min = findMin(node.rigth); // Buscar sucesor inOrder
            node.data = min.data; // Reemplazar
            node.rigth = delete(node.rigth, min.data); // Eliminar duplicado
        }

        return node;
    }
	
	// Busca el nodo con el valor mínimo (más a la izquierda)
	private Node findMin(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // Devuelve los datos en recorrido In-Orden como String
	public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.toString();
    }

    // Recorrido In-Orden privado
	private void toString(Node node, StringBuilder sb) {
        if (node != null) {
            toString(node.left, sb);
            sb.append(node.data).append(" ");
            toString(node.rigth, sb);
        }
    }
	
    // Verifica si el árbol está vacío
	@Override
	 public boolean isEmpty() {
	        return root == null;
	 }
	
	//metodo inOrder (izquierda, raíz, derecha)
	private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.rigth);
        }
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    //metodo preOrder (raíz, izquierda, derecha)
    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.rigth);
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    //metodo postOrder (izquierda, derecha, raíz)
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.rigth);
            System.out.print(node.data + " ");
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    //metodos findMinNode y findMaxNode
    private Node findMinNode(Node node) throws ItemNotFound {
        if (node == null)
            throw new ItemNotFound("Subárbol vacío");

        while (node.left != null)
            node = node.left;

        search(node.data); 
        return node;
    }
    
    private Node findMaxNode(Node node) throws ItemNotFound {
        if (node == null)
            throw new ItemNotFound("Subárbol vacío");

        while (node.rigth != null)
            node = node.rigth;

        search(node.data); 
        return node;
    }
    
    public E findMin() throws ItemNotFound {
        return findMinNode(root).data;
    }

    public E findMax() throws ItemNotFound {
        return findMaxNode(root).data;
    }
    
    //metodo destroy
    public void destroyNodes() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("El árbol ya está vacío.");
        root = null;
    }
    
    //metodo countallnodes
    public int countAllNodes() {
    	return countAllNodes(root);
    }
    
    private int countAllNodes(Node node) {
        if (node == null) return 0;
        return 1 + countAllNodes(node.left) + countAllNodes(node.rigth);
    }
    
    //metodo countnodes
    public int countNodes() {
        return countNonLeafNodes(root);
    }

    private int countNonLeafNodes(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.rigth == null) return 0;
        return 1 + countNonLeafNodes(node.left) + countNonLeafNodes(node.rigth);
    }
   
    //metodo heigt
    public int height(E x) {
        Node nodo = search(root, x);
        if (nodo == null) 
        	return -1;

        return heightIterative(nodo);
    }

    private int heightIterative(Node node) {
        if (node == null) 
        	return -1;

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(node);
        int height = -1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            height++;
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.rigth != null) queue.add(current.rigth);
            }
        }
        return height;
    }

    //metodo amplitude
    public int amplitude(int nivel) {
        if (nivel < 0 || root == null) return 0;

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentLevel == nivel) {
                return size;
            }

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.rigth != null) queue.add(current.rigth);
            }
            currentLevel++;
        }

        return 0;
    }
    
    
    //metodo areabst
    public int areaBST() {
        int hojas = countLeafNodesIterative();
        int altura = heightIterative(root);
        return hojas * altura;
    }
    
    private int countLeafNodesIterative() {
        if (root == null) return 0;

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        int count = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left == null && current.rigth == null)
                count++;
            if (current.left != null) queue.add(current.left);
            if (current.rigth != null) queue.add(current.rigth);
        }

        return count;
    }
    
    //metodo drarBst
    public void drawBST() {
        System.out.println("Dibujo (inOrder):");
        inOrder();
    }

    public boolean sameArea(LinkedBST<E> other) {
        if (other == null) return false;
        return this.areaBST() == other.areaBST();
    }
    
    //metodo parenthesize
    public void parenthesize() {
        parenthesize(root, 0);
    }

    private void parenthesize(Node node, int level) {
        if (node == null) return;

        for (int i = 0; i < level; i++) System.out.print("  ");
        System.out.println(node.data);

        if (node.left != null || node.rigth != null) {
            if (node.left != null) {
                for (int i = 0; i < level + 1; i++) System.out.print("  ");
                System.out.print("(");
                System.out.println();
                parenthesize(node.left, level + 2);
                for (int i = 0; i < level + 1; i++) System.out.print("  ");
                System.out.println(")");
            }

            if (node.rigth != null) {
                for (int i = 0; i < level + 1; i++) System.out.print("  ");
                System.out.print("(");
                System.out.println();
                parenthesize(node.rigth, level + 2);
                for (int i = 0; i < level + 1; i++) System.out.print("  ");
                System.out.println(")");
            }
        }
    }

}
