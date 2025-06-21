package Pruebas;
import btree.BTree;
import RegistroEstudiante.RegistroEstudiante; 

public class Prueba2 {
    public static void main(String[] args) {
        BTree<RegistroEstudiante> tree = new BTree<>(4);  // Árbol de orden 4

        RegistroEstudiante[] estudiantes = {
            new RegistroEstudiante(103, "Ana"),
            new RegistroEstudiante(110, "Luis"),
            new RegistroEstudiante(101, "Carlos"),
            new RegistroEstudiante(120, "Lucía"),
            new RegistroEstudiante(115, "David"),
            new RegistroEstudiante(125, "Jorge"),
            new RegistroEstudiante(140, "Camila"),
            new RegistroEstudiante(108, "Rosa"),
            new RegistroEstudiante(132, "Ernesto"),
            new RegistroEstudiante(128, "Denis"),
            new RegistroEstudiante(145, "Enrique"),
            new RegistroEstudiante(122, "Karina"),
            new RegistroEstudiante(108, "Juan") // duplicado
        };

        for (RegistroEstudiante est : estudiantes) {
            tree.insert(est);
        }

        System.out.println("\nBúsqueda de 115: " + tree.buscarNombre(115)); // David
        System.out.println("Búsqueda de 132: " + tree.buscarNombre(132)); // Ernesto
        System.out.println("Búsqueda de 999: " + tree.buscarNombre(999)); // No encontrado

        System.out.println("\nEliminando estudiante con código 101");
        tree.remove(new RegistroEstudiante(101, ""));

        System.out.println("Insertando (106, Sara)");
        tree.insert(new RegistroEstudiante(106, "Sara"));

        System.out.println("Búsqueda de 106: " + tree.buscarNombre(106));

        System.out.println("\nÁrbol final:");
        System.out.println(tree);
    }
}
