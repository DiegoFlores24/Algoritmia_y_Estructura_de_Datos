package Pruebas;
import btree.BTree;
import java.io.BufferedReader;
import java.io.FileReader;

public class Prueba {
    public static void main(String[] args) {
        try {
            // Cambia esta ruta por la tuya exacta
            String ruta = "C:\\Users\\gadge\\OneDrive\\Escritorio\\Santaflow\\arbolB.txt";

            // Construir el árbol desde archivo
            BTree<Integer> tree = BTree.building_Btree(ruta);

            // Mostrar árbol reconstruido
            System.out.println("Árbol B reconstruido desde arbolB.txt:");
            System.out.println(tree);

        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}