package Prueba;
import bstreelinklistinterfgeneric.LinkedBST; 
import java.util.Scanner;
import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemNotFound;
import Exceptions.ItemDuplicated;
import bstreeInterface.BinarySearchTree;

public class Prueba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedBST<Integer> arbol = new LinkedBST<>();
        LinkedBST<Integer> otroArbol = new LinkedBST<>();

        try {
            System.out.print("¿Cuantos elementos insertaras? ");
            int n = sc.nextInt();
            System.out.println("Inserta elementos para el arbol:");
            for (int i = 0; i < n; i++) {
                int valor = sc.nextInt();
                arbol.insert(valor);
            }

            // Mostrar recorridos
            System.out.println("Recorrido In-Orden:");
            arbol.inOrder();
            System.out.println("Recorrido Pre-Orden:");
            arbol.preOrder();
            System.out.println("Recorrido Post-Orden:");
            arbol.postOrder();

            System.out.println("Minimo: " + arbol.findMin());
            System.out.println("Maximo: " + arbol.findMax());
            System.out.println("Area del arbol: " + arbol.areaBST());

            System.out.print("¿Que nivel quieres de amplitud deseas medir? ");
            int nivel = sc.nextInt();
            System.out.println("Nodos en nivel " + nivel + ": " + arbol.amplitude(nivel));

            System.out.print("Dato del nodo para calcular su altura: ");
            int nodoAltura = sc.nextInt();
            System.out.println("Altura del nodo " + nodoAltura + ": " + arbol.height(nodoAltura));

            System.out.println("Total de nodos: " + arbol.countAllNodes());
            System.out.println("Nodos no-hojas: " + arbol.countNodes());

            arbol.drawBST();
            System.out.println("\nRepresentacion con sangria y parentesis:");
            arbol.parenthesize();

            otroArbol.insert(10);
            otroArbol.insert(5);
            otroArbol.insert(15);
            System.out.println("¿Arbol y otro Arbol tienen misma area? " + arbol.sameArea(otroArbol));

            arbol.destroyNodes();
            System.out.println("Arbol destruido.");
            arbol.inOrder(); 

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
