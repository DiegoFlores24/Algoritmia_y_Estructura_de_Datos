package graph;
import ListLinked.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

public class GraphLink<E> {
    protected ListLinked<Vertex<E>> listVertex;  // Lista de vértices del grafo

    public GraphLink() {
        listVertex = new ListLinked<>();
    }

    // Agrega un nuevo vértice si no existe
    public void insertVertex(E data) {
        if (!searchVertex(data)) {
            listVertex.insertLast(new Vertex<>(data));
        }
    }

    // Agrega una arista entre dos vértices (en ambos sentidos)
    public void insertEdge(E verOri, E verDes) {
        Vertex<E> vOri = getVertex(verOri);
        Vertex<E> vDes = getVertex(verDes);
        if (vOri == null || vDes == null) return;

        Edge<E> edge1 = new Edge<>(vDes);
        Edge<E> edge2 = new Edge<>(vOri);

        if (!vOri.listAdj.search(edge1)) vOri.listAdj.insertLast(edge1);
        if (!vDes.listAdj.search(edge2)) vDes.listAdj.insertLast(edge2);
    }

    // Elimina un vértice y todas sus aristas
    public void removeVertex(E data) {
        Vertex<E> vertexToRemove = getVertex(data);
        if (vertexToRemove == null) return;

        listVertex.rewind();
        while (listVertex.hasNext()) {
            Vertex<E> v = listVertex.next();
            if (!v.equals(vertexToRemove)) {
                v.listAdj.remove(new Edge<>(vertexToRemove));
            }
        }
        listVertex.remove(vertexToRemove);
    }

    // Elimina una arista entre dos vértices
    public void removeEdge(E v, E z) {
        Vertex<E> vertexV = getVertex(v);
        Vertex<E> vertexZ = getVertex(z);
        if (vertexV == null || vertexZ == null) return;

        vertexV.listAdj.remove(new Edge<>(vertexZ));
        vertexZ.listAdj.remove(new Edge<>(vertexV));
    }

    // Verifica si un vértice existe
    public boolean searchVertex(E data) {
        return getVertex(data) != null;
    }

    // Verifica si una arista existe entre dos vértices
    public boolean searchEdge(E verOri, E verDes) {
        Vertex<E> vOri = getVertex(verOri);
        Vertex<E> vDes = getVertex(verDes);
        if (vOri == null || vDes == null) return false;

        return vOri.listAdj.search(new Edge<>(vDes));
    }

    // Método auxiliar para obtener un vértice
    private Vertex<E> getVertex(E data) {
        listVertex.rewind();
        while (listVertex.hasNext()) {
            Vertex<E> v = listVertex.next();
            if (v.getData().equals(data)) return v;
        }
        return null;
    }

    // Recorrido en profundidad (DFS)
    public void dfs(E startData) {
        Vertex<E> startVertex = getVertex(startData);
        if (startVertex == null) return;

        ListLinked<E> visited = new ListLinked<>();
        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    private void dfsRecursive(Vertex<E> current, ListLinked<E> visited) {
        System.out.print(current.getData() + " ");
        visited.insertLast(current.getData());

        current.listAdj.rewind();
        while (current.listAdj.hasNext()) {
            Edge<E> edge = current.listAdj.next();
            Vertex<E> neighbor = edge.getRefDest();

            if (!visited.search(neighbor.getData())) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
    
    public void bfs(E startData) {
        Vertex<E> startVertex = getVertex(startData);
        if (startVertex == null) return;

        ListLinked<E> visited = new ListLinked<>();     // Lista de visitados
        Queue<Vertex<E>> queue = new LinkedList<>();    // Cola para BFS

        visited.insertLast(startVertex.getData());
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            System.out.print(current.getData() + " ");

            current.listAdj.rewind();
            while (current.listAdj.hasNext()) {
                Edge<E> edge = current.listAdj.next();
                Vertex<E> neighbor = edge.getRefDest();

                if (!visited.search(neighbor.getData())) {
                    visited.insertLast(neighbor.getData());
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println(); 
    }
    
    public ArrayList<E> bfsPath(E origin, E target) {
        Vertex<E> start = getVertex(origin);
        Vertex<E> end = getVertex(target);
        if (start == null || end == null) return null;

        Map<E, E> parentMap = new HashMap<>();   // Para reconstruir el camino
        Queue<Vertex<E>> queue = new LinkedList<>();
        ListLinked<E> visited = new ListLinked<>();

        visited.insertLast(start.getData());
        queue.offer(start);
        parentMap.put(start.getData(), null);  // El nodo inicial no tiene padre

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();

            if (current.equals(end)) break; // Si llegamos al destino, detenemos

            current.listAdj.rewind();
            while (current.listAdj.hasNext()) {
                Edge<E> edge = current.listAdj.next();
                Vertex<E> neighbor = edge.getRefDest();

                if (!visited.search(neighbor.getData())) {
                    visited.insertLast(neighbor.getData());
                    parentMap.put(neighbor.getData(), current.getData()); // Guardar quién lo visitó
                    queue.offer(neighbor);
                }
            }
        }

        // Reconstruir el camino desde el destino hasta el origen
        ArrayList<E> path = new ArrayList<>();
        E step = target;
        while (step != null) {
            path.add(0, step); // Insertar al inicio
            step = parentMap.get(step);
        }

        if (!path.isEmpty() && path.get(0).equals(origin)) return path;
        return null; // No se encontró camino
    }
    
    public void insertEdgeWeight(E verOri, E verDes, int weight) {
        Vertex<E> vOri = getVertex(verOri);
        Vertex<E> vDes = getVertex(verDes);

        if (vOri == null || vDes == null) return;

        Edge<E> edge1 = new Edge<>(vDes, weight);
        Edge<E> edge2 = new Edge<>(vOri, weight);

        if (!vOri.listAdj.search(edge1)) vOri.listAdj.insertLast(edge1);
        if (!vDes.listAdj.search(edge2)) vDes.listAdj.insertLast(edge2);
    }

    public boolean isConexo() {
        if (listVertex.isEmpty()) return true;

        ListLinked<E> visited = new ListLinked<>();
        Vertex<E> first = listVertex.next();  // Tomamos el primer vértice
        dfsRecursive(first, visited);

        int count = 0;
        listVertex.rewind();
        while (listVertex.hasNext()) {
            Vertex<E> v = listVertex.next();
            if (visited.search(v.getData())) count++;
        }

        return count == getSize();  // Todos los vértices fueron visitados
    }

    
    public ArrayList<E> shortPath(E start, E end) {
        return bfsPath(start, end); // reutiliza el método ya implementado
    }

    public Stack<E> dijkstra(E start, E end) {
        Map<E, Integer> dist = new HashMap<>();
        Map<E, E> prev = new HashMap<>();
        PriorityQueue<Vertex<E>> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
        ListLinked<E> visited = new ListLinked<>();

        listVertex.rewind();
        while (listVertex.hasNext()) {
            Vertex<E> v = listVertex.next();
            dist.put(v.getData(), Integer.MAX_VALUE);
            prev.put(v.getData(), null);
        }

        Vertex<E> startV = getVertex(start);
        if (startV == null || getVertex(end) == null) return null;

        dist.put(start, 0);
        pq.offer(startV);

        while (!pq.isEmpty()) {
            Vertex<E> current = pq.poll();
            E currData = current.getData();

            if (visited.search(currData)) continue;
            visited.insertLast(currData);

            current.listAdj.rewind();
            while (current.listAdj.hasNext()) {
                Edge<E> edge = current.listAdj.next();
                Vertex<E> neighbor = edge.getRefDest();
                E neighData = neighbor.getData();
                int weight = edge.getWeight();

                if (dist.get(currData) + weight < dist.get(neighData)) {
                    dist.put(neighData, dist.get(currData) + weight);
                    prev.put(neighData, currData);
                    pq.offer(neighbor);
                }
            }
        }

        // Reconstruir ruta desde el final
        Stack<E> path = new Stack<>();
        E step = end;
        while (step != null) {
            path.push(step);
            step = prev.get(step);
        }

        if (!path.isEmpty() && path.peek().equals(end) && dist.get(end) != Integer.MAX_VALUE) {
            return path;
        }

        return null;
    }
    
    public int getSize() {
        int count = 0;
        listVertex.rewind();
        while (listVertex.hasNext()) {
            listVertex.next();
            count++;
        }
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        listVertex.rewind();
        while (listVertex.hasNext()) {
            sb.append(listVertex.next().toString());
        }
        return sb.toString();
    }
    
    public int getGrado(E data) {
        Vertex<E> v = getVertex(data);
        if (v == null) return -1;
        return v.listAdj.getSize();
    }

    public boolean esCamino() {
        listVertex.rewind();
        int count2 = 0, count1 = 0;
        while (listVertex.hasNext()) {
            Vertex<E> v = listVertex.next();
            int grado = v.listAdj.getSize();
            if (grado == 1) count1++;
            else if (grado == 2) count2++;
            else return false;
        }
        return count1 == 2 && count2 == getSize() - 2;
    }

    public boolean esCiclo() {
        listVertex.rewind();
        while (listVertex.hasNext()) {
            Vertex<E> v = listVertex.next();
            if (v.listAdj.getSize() != 2) return false;
        }
        return true;
    }

    public boolean esRueda() {
        int centro = -1;
        listVertex.rewind();
        while (listVertex.hasNext()) {
            Vertex<E> v = listVertex.next();
            int grado = v.listAdj.getSize();
            if (grado == getSize() - 1) {
                if (centro != -1) return false;
                centro = 1;
            } else if (grado != 3) return false;
        }
        return centro == 1;
    }

    public boolean esCompleto() {
        int n = getSize();
        listVertex.rewind();
        while (listVertex.hasNext()) {
            Vertex<E> v = listVertex.next();
            if (v.listAdj.getSize() != n - 1) return false;
        }
        return true;
    }
    
    public String representacionFormal() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vértices: ");
        listVertex.rewind();
        while (listVertex.hasNext()) {
            sb.append(listVertex.next().getData()).append(" ");
        }

        sb.append("\nAristas: ");
        listVertex.rewind();
        while (listVertex.hasNext()) {
            Vertex<E> v = listVertex.next();
            v.listAdj.rewind();
            while (v.listAdj.hasNext()) {
                Edge<E> e = v.listAdj.next();
                sb.append("(").append(v.getData()).append(", ").append(e.getRefDest().getData()).append(") ");
            }
        }
        return sb.toString();
    }

    public String representacionListaAdyacencia() {
        return this.toString();  
    }

    public int[][] matrizAdyacencia() {
        int n = getSize();
        int[][] matriz = new int[n][n];
        ArrayList<Vertex<E>> vertices = new ArrayList<>();
        
        listVertex.rewind();
        while (listVertex.hasNext()) vertices.add(listVertex.next());

        for (int i = 0; i < n; i++) {
            Vertex<E> v = vertices.get(i);
            v.listAdj.rewind();
            while (v.listAdj.hasNext()) {
                Vertex<E> dest = v.listAdj.next().getRefDest();
                int j = vertices.indexOf(dest);
                matriz[i][j] = 1;
            }
        }
        return matriz;
    }


}
