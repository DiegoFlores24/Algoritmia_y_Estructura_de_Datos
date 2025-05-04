package ACTIVIDAD;

import java.util.List; 
import java.util.ArrayList; 
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        GestorTarea<Tarea> gestor = new GestorTarea<>(); // Crea un gestor de tareas
        Scanner sc = new Scanner(System.in); 
        int opcion;

        do {
            // Menú de opciones para el usuario
            System.out.println("\n===== Menú de Gestor de Tareas =====");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Eliminar Tarea");
            System.out.println("3. Imprimir Tareas");
            System.out.println("4. Contar Tareas");
            System.out.println("5. Buscar Tarea");
            System.out.println("6. Obtener Tarea de Mayor Prioridad");
            System.out.println("7. Invertir Lista de Tareas");
            System.out.println("8. Transferir Tarea a Completadas");
            System.out.println("9. Mostrar Tareas Completadas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1: // Agregar tarea
                    System.out.print("Ingrese el nombre de la tarea: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese la prioridad (número, menor es más urgente): ");
                    int prioridad = sc.nextInt();
                    gestor.agregarTarea(new Tarea(nombre, prioridad));
                    break;
                case 2: // Eliminar tarea
                    System.out.print("Ingrese el nombre de la tarea a eliminar: ");
                    nombre = sc.nextLine();
                    System.out.print("Ingrese su prioridad: ");
                    prioridad = sc.nextInt();
                    if (gestor.eliminarTarea(new Tarea(nombre, prioridad))) {
                        System.out.println("Tarea eliminada correctamente.");
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case 3: // Mostrar todas las tareas
                    gestor.imprimirTareas();
                    break;
                case 4: // Contar tareas
                    System.out.println("Número de tareas: " + gestor.contarTareas());
                    break;
                case 5: // Buscar tarea
                    System.out.print("Ingrese el nombre de la tarea a buscar: ");
                    nombre = sc.nextLine();
                    System.out.print("Ingrese su prioridad: ");
                    prioridad = sc.nextInt();
                    if (gestor.contieneTarea(new Tarea(nombre, prioridad))) {
                        System.out.println("La tarea existe.");
                    } else {
                        System.out.println("La tarea no existe.");
                    }
                    break;
                case 6: // Mostrar tarea con mayor prioridad
                    Tarea tareaPrioritaria = gestor.obtenerTareaMasPrioritaria();
                    if (tareaPrioritaria != null) {
                        System.out.println("Tarea más prioritaria: " + tareaPrioritaria);
                    } else {
                        System.out.println("No hay tareas.");
                    }
                    break;
                case 7: // Invertir lista de tareas
                    gestor.invertirTareas();
                    System.out.println("Lista de tareas invertida.");
                    break;
                case 8: // Marcar tarea como completada
                    System.out.print("Ingrese el nombre de la tarea a completar: ");
                    nombre = sc.nextLine();
                    System.out.print("Ingrese su prioridad: ");
                    prioridad = sc.nextInt();
                    if (gestor.transferirTareaACompletadas(new Tarea(nombre, prioridad))) {
                        System.out.println("Tarea transferida a completadas.");
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case 9: // Mostrar tareas completadas
                    gestor.mostrarTareasCompletadas();
                    break;
                case 0: // Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0); // Repite hasta que se elija salir

        sc.close(); // Cierra el escáner
    }
}

