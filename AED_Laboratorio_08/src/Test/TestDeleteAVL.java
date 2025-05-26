package Test;

import avltree.AVLTree;
import Exceptions.ItemDuplicated;
import Exceptions.ExceptionIsEmpty;

public class TestDeleteAVL {
    public static void main(String[] args) {
        try {
            // Caso 1: RSR tras eliminar un nodo
            AVLTree<String> avl1 = new AVLTree<>();
            avl1.insert("m");
            avl1.insert("l");
            avl1.insert("n");
            avl1.insert("k"); // desequilibra a la izquierda
            avl1.insert("j");
            System.out.println("Antes de eliminar (RSR esperado):");
            avl1.inOrder();

            avl1.delete("n"); // esto debería causar RSR
            System.out.println("Después de eliminar 'n' (RSR):");
            avl1.inOrder();

            // Caso 2: RSL tras eliminar un nodo
            AVLTree<String> avl2 = new AVLTree<>();
            avl2.insert("k");
            avl2.insert("j");
            avl2.insert("m");
            avl2.insert("n");
            avl2.insert("o");
            System.out.println("\nAntes de eliminar (RSL esperado):");
            avl2.inOrder();

            avl2.delete("j"); // esto debería causar RSL
            System.out.println("Después de eliminar 'j' (RSL):");
            avl2.inOrder();

            // Caso 3: RDR tras eliminar
            AVLTree<String> avl3 = new AVLTree<>();
            avl3.insert("p");
            avl3.insert("n");
            avl3.insert("t");
            avl3.insert("r");
            avl3.insert("s");
            System.out.println("\nAntes de eliminar (RDR esperado):");
            avl3.inOrder();

            avl3.delete("t"); // esto debería causar RDR
            System.out.println("Después de eliminar 't' (RDR):");
            avl3.inOrder();

            // Caso 4: RDL tras eliminar
            AVLTree<String> avl4 = new AVLTree<>();
            avl4.insert("m");
            avl4.insert("k");
            avl4.insert("o");
            avl4.insert("n");
            avl4.insert("l");
            System.out.println("\nAntes de eliminar (RDL esperado):");
            avl4.inOrder();

            avl4.delete("k"); // esto debería causar RDL
            System.out.println("Después de eliminar 'k' (RDL):");
            avl4.inOrder();

        } catch (ItemDuplicated | ExceptionIsEmpty e) {
            System.err.println(e.getMessage());
        }
    }
}
