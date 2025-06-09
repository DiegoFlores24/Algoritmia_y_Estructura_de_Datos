package graph;
import ListLinked.*;
/**
 * Representa un vértice en el grafo.
 * Guarda un dato genérico y su lista de adyacencia.
 */
public class Vertex<E> {
    private E data;  // Información del vértice
    protected ListLinked<Edge<E>> listAdj;  // Lista de aristas (adyacencia)

    public Vertex(E data) {
        this.data = data;
        listAdj = new ListLinked<>();
    }

    public E getData() {
        return data;
    }

    public boolean equals(Object o) {
        if (o instanceof Vertex<?>) {
            Vertex<E> v = (Vertex<E>) o;
            return this.data.equals(v.data);
        }
        return false;
    }

    public String toString() {
        return this.data + " ---> " + this.listAdj.toString() + "\n";
    }
}

