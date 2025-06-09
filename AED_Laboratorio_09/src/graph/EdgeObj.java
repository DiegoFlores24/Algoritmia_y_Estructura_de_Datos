package graph;

/**
 * Representa una arista entre dos vértices.
 */
public class EdgeObj<V,E> {
    protected E info;                       // Información de la arista (peso u otro dato)
    protected VertexObj<V,E> endVertex1;    // Primer vértice
    protected VertexObj<V,E> endVertex2;    // Segundo vértice
    protected int position;                 // Identificador de posición en la lista

    public EdgeObj(VertexObj<V,E> vert1, VertexObj<V,E> vert2, E info, int position) {
        this.endVertex1 = vert1;
        this.endVertex2 = vert2;
        this.info = info;
        this.position = position;
    }

    public boolean equals(Object o) {
        if (o instanceof EdgeObj<?, ?>) {
            EdgeObj<?, ?> other = (EdgeObj<?, ?>) o;
            return (this.endVertex1.equals(other.endVertex1) && this.endVertex2.equals(other.endVertex2)) ||
                   (this.endVertex1.equals(other.endVertex2) && this.endVertex2.equals(other.endVertex1));
        }
        return false;
    }

    public String toString() {
        return "(" + endVertex1 + " - " + endVertex2 + ", " + info + ")";
    }
}
