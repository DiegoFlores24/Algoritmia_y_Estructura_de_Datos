package graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementación del TAD Grafo usando lista de estructuras de aristas.
 * Usa listas para representar vértices y aristas.
 */
public class GraphListEdge<V, E> {
    ArrayList<VertexObj<V, E>> secVertex; // Lista de vértices
    ArrayList<EdgeObj<V, E>> secEdge;     // Lista de aristas

    public GraphListEdge() {
        this.secVertex = new ArrayList<>();
        this.secEdge = new ArrayList<>();
    }

    /**
     * Inserta un vértice si no existe previamente.
     */
    public void insertVertex(V v) {
        if (!searchVertex(v)) {
            secVertex.add(new VertexObj<>(v, secVertex.size()));
        }
    }

    /**
     * Inserta una arista no dirigida entre dos vértices existentes.
     */
    public void insertEdge(V v1, V v2) {
        VertexObj<V, E> vert1 = getVertex(v1);
        VertexObj<V, E> vert2 = getVertex(v2);
        if (vert1 == null || vert2 == null) return;

        EdgeObj<V, E> edge = new EdgeObj<>(vert1, vert2, null, secEdge.size());
        if (!secEdge.contains(edge)) {
            secEdge.add(edge);
        }
    }

    /**
     * Verifica si un vértice con valor 'v' existe en el grafo.
     */
    public boolean searchVertex(V v) {
        return getVertex(v) != null;
    }

    /**
     * Verifica si una arista existe entre dos vértices dados.
     */
    public boolean searchEdge(V v1, V v2) {
        VertexObj<V, E> vert1 = getVertex(v1);
        VertexObj<V, E> vert2 = getVertex(v2);
        if (vert1 == null || vert2 == null) return false;

        EdgeObj<V, E> edge = new EdgeObj<>(vert1, vert2, null, -1);
        return secEdge.contains(edge);
    }

    /**
     * Recorrido en anchura (BFS) desde un vértice de inicio.
     */
    public void bfs(V start) {
        VertexObj<V, E> startVertex = getVertex(start);
        if (startVertex == null) return;

        Set<V> visited = new HashSet<>();
        Queue<VertexObj<V, E>> queue = new LinkedList<>();

        visited.add(startVertex.getInfo());
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            VertexObj<V, E> current = queue.poll();
            System.out.print(current.getInfo() + " ");

            for (EdgeObj<V, E> edge : secEdge) {
                VertexObj<V, E> neighbor = null;

                if (edge.endVertex1.equals(current) && !visited.contains(edge.endVertex2.getInfo())) {
                    neighbor = edge.endVertex2;
                } else if (edge.endVertex2.equals(current) && !visited.contains(edge.endVertex1.getInfo())) {
                    neighbor = edge.endVertex1;
                }

                if (neighbor != null) {
                    visited.add(neighbor.getInfo());
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println(); // Salto de línea final
    }

    /**
     * Método auxiliar: retorna el objeto VertexObj que contiene el valor dado.
     */
    private VertexObj<V, E> getVertex(V v) {
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getInfo().equals(v)) {
                return vertex;
            }
        }
        return null;
    }
}