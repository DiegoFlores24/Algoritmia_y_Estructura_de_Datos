package Pruebas;
import btree.BTree;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTree<Integer> tree = new BTree<>(5);

        System.out.println("Ingrese claves para insertar (número negativo para terminar):");
        while (true) {
            System.out.print("Clave: ");
            int key = sc.nextInt();
            if (key < 0) break;

            tree.insert(key);
            System.out.println("Árbol actual:\n" + tree);
        }
        sc.close();
    }
}
