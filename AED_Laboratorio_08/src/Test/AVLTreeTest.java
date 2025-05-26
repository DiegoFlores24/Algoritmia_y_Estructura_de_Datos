package Test;

import avltree.AVLTree;
import Exceptions.ItemDuplicated;
import Exceptions.ExceptionIsEmpty;

public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree<String> avl = new AVLTree<>();

        try {
            System.out.println("Insertando nodos con posibles rotaciones:");
            avl.insert("m");
            avl.insert("b");
            avl.insert("a"); // RSR esperada
            System.out.println("Después de insertar 'a' (RSR esperada):");
            avl.parenthesize();

            avl.insert("c"); // RDR esperada
            System.out.println("Después de insertar 'c' (RDR esperada):");
            avl.parenthesize();

            avl.insert("z");
            avl.insert("x"); // RDL esperada
            System.out.println("Después de insertar 'x' (RDL esperada):");
            avl.parenthesize();

            avl.insert("y"); // RSL esperada
            System.out.println("Después de insertar 'y' (RSL esperada):");
            avl.parenthesize();

            System.out.println("\nEliminando nodos con posibles reequilibrios:");
            avl.delete("a");
            System.out.println("Después de eliminar 'a':");
            avl.parenthesize();

            avl.delete("z");
            System.out.println("Después de eliminar 'z':");
            avl.parenthesize();

        } catch (ItemDuplicated e) {
            System.err.println("Duplicado: " + e.getMessage());
        } catch (ExceptionIsEmpty e) {
            System.err.println("Árbol vacío: " + e.getMessage());
        }
    }
}


