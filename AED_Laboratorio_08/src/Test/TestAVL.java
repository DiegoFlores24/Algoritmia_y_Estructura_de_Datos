package Test;

import avltree.AVLTree;
import Exceptions.ItemDuplicated;

public class TestAVL {

    public static void main(String[] args) {
        AVLTree<String> avl = new AVLTree<>();

        try {
            // Caso 1: Inserción que provoca rotación Simple a la derecha (RSR)
            avl.insert("c");
            avl.insert("b");
            avl.insert("a"); // Desequilibrio a la izquierda -> RSR
            System.out.println("Después de RSR (rotación simple derecha):");
            avl.inOrder();

            // Caso 2: Inserción que provoca rotación Simple a la izquierda (RSL)
            avl.insert("e");
            avl.insert("f"); // Desequilibrio a la derecha -> RSL
            System.out.println("Después de RSL (rotación simple izquierda):");
            avl.inOrder();

            // Caso 3: Inserción que provoca rotación Doble a la derecha (RDR)
            AVLTree<String> avlRDR = new AVLTree<>();
            avlRDR.insert("e");
            avlRDR.insert("c");
            avlRDR.insert("d"); // Desequilibrio a la izquierda-derecha -> RDR
            System.out.println("Después de RDR (rotación doble derecha):");
            avlRDR.inOrder();

            // Caso 4: Inserción que provoca rotación Doble a la izquierda (RDL)
            AVLTree<String> avlRDL = new AVLTree<>();
            avlRDL.insert("c");
            avlRDL.insert("e");
            avlRDL.insert("d"); // Desequilibrio a la derecha-izquierda -> RDL
            System.out.println("Después de RDL (rotación doble izquierda):");
            avlRDL.inOrder();

         // Caso 5: Inserción continua para ver varias rotaciones acumuladas
            AVLTree<String> avl5 = new AVLTree<>();
            avl5.insert("h");
            avl5.insert("g");
            avl5.insert("f"); // RSR
            avl5.insert("e");
            avl5.insert("d"); // RSR
            avl5.insert("c"); // Nueva RSR
            System.out.println("Después de múltiples RSR:");
            avl5.inOrder();
            
         // Caso 6: Inserción balanceada, sin necesidad de rotar
            AVLTree<String> avl6 = new AVLTree<>();
            avl6.insert("m");
            avl6.insert("l");
            avl6.insert("o");
            avl6.insert("n");
            System.out.println("Inserciones sin necesidad de rotación:");
            avl6.inOrder();
            
            // Caso 7: Rotaciones en ramas profundas
            AVLTree<String> avl7 = new AVLTree<>();
            avl7.insert("m");
            avl7.insert("n");
            avl7.insert("o");
            avl7.insert("p");
            avl7.insert("q"); // Varias RSL hacia arriba
            System.out.println("Desequilibrio profundo derecho (RSL en profundidad):");
            avl7.inOrder();
            
         // Caso 8: Equilibrio perfecto sin rotaciones
            AVLTree<String> avl8 = new AVLTree<>();
            avl8.insert("m");
            avl8.insert("l");
            avl8.insert("n");
            System.out.println("Inserciones equilibradas sin rotación:");
            avl8.inOrder();
            
        } catch (ItemDuplicated e) {
            System.err.println(e.getMessage());
        }
    }
}

