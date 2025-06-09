package graph;

/**
 * Representa una arista que conecta a otro vértice.
 * Puede tener o no un peso.
 */
public class Edge<E> {
    private Vertex<E> refDest;  // Vértice destino
    private int weight;         // Peso de la arista (opcional)

    public Edge(Vertex<E> refDest) {
        this(refDest, -1); // -1 indica arista sin peso
    }

    public Edge(Vertex<E> refDest, int weight) {
        this.refDest = refDest;
        this.weight = weight;
    }

    public Vertex<E> getRefDest() {
        return refDest;
    }

    public int getWeight() {
        return weight;
    }

    public boolean equals(Object o) {
        if (o instanceof Edge<?>) {
            Edge<E> e = (Edge<E>) o;
            return this.refDest.equals(e.refDest);
        }
        return false;
    }

    public String toString() {
        if (this.weight > -1) return refDest.getData() + " [" + this.weight + "], ";
        else return refDest.getData() + ", ";
    }
}