package Test;
import avltree.AVLTree;

public class TestAVLPreOrder {
    public static void main(String[] args) {
        AVLTree<String> avl = new AVLTree<>();

        try {
            // Insertar nodos para formar un AVL
            avl.insert("g");
            avl.insert("m");
            avl.insert("w");
            avl.insert("t");
            avl.insert("p");
            avl.insert("j");
            avl.insert("d");

            System.out.println("Recorrido en preorden del AVL:");
            avl.preOrder();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
