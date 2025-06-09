package graph;

/**
 * Representa un vértice en un grafo usando lista de aristas.
 */
public class VertexObj<V,E> {
    protected V info;          // Información del vértice
    protected int position;    // Identificador numérico (opcional)

    public VertexObj(V info, int position) {
        this.info = info;
        this.position = position;
    }

    public V getInfo() {
        return info;
    }

    public boolean equals(Object o) {
        if (o instanceof VertexObj<?, ?>) {
            VertexObj<?, ?> other = (VertexObj<?, ?>) o;
            return this.info.equals(other.info);
        }
        return false;
    }

    public String toString() {
        return info.toString();
    }
}
