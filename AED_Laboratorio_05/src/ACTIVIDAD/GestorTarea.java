package ACTIVIDAD;
import java.util.List;
import java.util.ArrayList;

class GestorTarea<T extends Comparable<T>> {
    private Nodo<T> cabeza; // Nodo inicial de la lista enlazada de tareas pendientes
    private List<T> tareasCompletadas; // Lista auxiliar para almacenar tareas completadas

    public GestorTarea() {
        this.cabeza = null;
        this.tareasCompletadas = new ArrayList<>();
    }

    public void agregarTarea(T tarea) {    // Agrega una tarea al final de la lista enlazada
        Nodo<T> nuevoNodo = new Nodo<>(tarea);
        if (cabeza == null) {
            cabeza = nuevoNodo; // Si la lista está vacía, el nuevo nodo es la cabeza
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo; // Se enlaza al final
        }
    }

    public boolean eliminarTarea(T tarea) {    // Elimina una tarea específica de la lista
        if (cabeza == null) return false; // Lista vacía

        if (cabeza.dato.equals(tarea)) {
            cabeza = cabeza.siguiente; // Eliminar la cabeza
            return true;
        }

        Nodo<T> actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato.equals(tarea)) {
                actual.siguiente = actual.siguiente.siguiente; // Se salta el nodo a eliminar
                return true;
            }
            actual = actual.siguiente;
        }
        return false; // No se encontró la tarea
    }

    public boolean contieneTarea(T tarea) {    // Verifica si una tarea está en la lista
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(tarea)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void imprimirTareas() {    // Imprime todas las tareas pendientes
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
        if (cabeza == null) {
            System.out.println("No hay tareas.");
        }
    }

    public int contarTareas() {    // Devuelve la cantidad de tareas pendientes
        int contador = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    public T obtenerTareaMasPrioritaria() {    // Retorna la tarea con mayor prioridad (menor número si menor = más prioritario)
        if (cabeza == null) return null;

        T masPrioritaria = cabeza.dato;
        Nodo<T> actual = cabeza.siguiente;

        while (actual != null) {
            if (actual.dato.compareTo(masPrioritaria) < 0) {
                masPrioritaria = actual.dato;
            }
            actual = actual.siguiente;
        }
        return masPrioritaria;
    }

    public void invertirTareas() {    // Invierte el orden de la lista enlazada de tareas
        Nodo<T> anterior = null;
        Nodo<T> actual = cabeza;
        Nodo<T> siguiente;

        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        cabeza = anterior; // Se actualiza la cabeza al nuevo inicio
    }

    public boolean transferirTareaACompletadas(T tarea) {    // Mueve una tarea de la lista de pendientes a la lista de completadas
        if (eliminarTarea(tarea)) {
            tareasCompletadas.add(tarea); // Se agrega a la lista de completadas
            return true;
        }
        return false; // No se pudo eliminar por lo tanto no se transfiere
    }

    public void mostrarTareasCompletadas() {    // Muestra las tareas que ya han sido completadas
        if (tareasCompletadas.isEmpty()) {
            System.out.println("No hay tareas completadas.");
        } else {
            for (T tarea : tareasCompletadas) {
                System.out.println(tarea);
            }
        }
    }
}
