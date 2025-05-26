package Test;

import avltree.AVLTree;
import Exceptions.ItemDuplicated;

public class TestAVLLevelOrder {
    public static void main(String[] args) {
        try {
            AVLTree<String> avl = new AVLTree<>();

            // Insertamos algunos elementos
            avl.insert("g");
            avl.insert("m");
            avl.insert("a");
            avl.insert("t");
            avl.insert("w");
            avl.insert("d");
            avl.insert("j");

            System.out.println("Recorrido por niveles (recursivo) del AVLTree:");
            avl.levelOrderRecursive();

        } catch (ItemDuplicated e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}
