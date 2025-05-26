package Test;

import bstreelinklistinterfgeneric.LinkedBST;
import avltree.AVLTree;
import Exceptions.ItemDuplicated;

public class TestComparacion {

    public static void main(String[] args) {
        LinkedBST<String> bst = new LinkedBST<>();
        AVLTree<String> avl = new AVLTree<>();

        String[] elementos = {"a", "b", "c", "d", "e", "f", "g"};

        try {
            // Insertar elementos en el BST simple
            for (String e : elementos) {
                bst.insert(e);
            }

            // Insertar los mismos elementos en el AVL
            for (String e : elementos) {
                avl.insert(e);
            }

            // Mostrar recorrido InOrder para ambos (debería ser igual)
            System.out.println("Recorrido InOrder BST:");
            bst.inOrder();

            System.out.println("Recorrido InOrder AVL:");
            avl.inOrder();

            // Mostrar altura de un nodo, por ejemplo la raíz
            System.out.println("\nAltura del árbol BST (raíz 'd'): " + bst.height("d"));
            System.out.println("Altura del árbol AVL (raíz 'd'): " + avl.height("d"));

            // Mostrar área BST (hojas * altura), para evidenciar diferencias en estructura
            System.out.println("\nÁrea BST (árbol simple): " + bst.areaBST());
            System.out.println("Área AVL (árbol balanceado): " + avl.areaBST());

        } catch (ItemDuplicated e) {
            System.err.println(e.getMessage());
        }
    }
}
