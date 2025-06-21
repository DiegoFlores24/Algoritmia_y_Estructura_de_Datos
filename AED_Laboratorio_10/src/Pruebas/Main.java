package Pruebas;
import java.util.Scanner;
import java.io.*;

import btree.BTree;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTree<Integer> tree = new BTree<>(5); // Árbol de orden 5

        int[] iniciales = {100, 50, 20, 70, 10, 30, 80, 90, 200, 25, 15, 5, 65, 35, 60, 18, 93,94};
        System.out.println("Insertando claves iniciales...");
        for (int clave : iniciales) {
            tree.insert(clave);
        }

        int opcion;
        do {
            System.out.println("\n=== MENÚ ÁRBOL B (orden 5) ===");
            System.out.println("1. Insertar nueva clave");
            System.out.println("2. Buscar clave");
            System.out.println("3. Eliminar clave");
            System.out.println("4. Mostrar árbol");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave a insertar: ");
                    int nuevaClave = sc.nextInt();
                    tree.insert(nuevaClave);
                    System.out.println("Clave insertada.");
                    break;

                case 2:
                    System.out.print("Ingrese la clave a buscar: ");
                    int claveBuscar = sc.nextInt();
                    boolean encontrado = tree.search(claveBuscar);
                    if (!encontrado) {
                        System.out.println(claveBuscar + " no se encontró en el árbol.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la clave a eliminar: ");
                    int claveEliminar = sc.nextInt();
                    tree.remove(claveEliminar);
                    break;

                case 4:
                    System.out.println("\nContenido actual del árbol B:");
                    System.out.println(tree);
                    break;

                case 0:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
