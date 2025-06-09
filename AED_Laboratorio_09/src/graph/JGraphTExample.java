package graph;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.List;

public class JGraphTExample {

	public static void main(String[] args) {
        // Crear un grafo no dirigido y ponderado
        Graph<String, DefaultWeightedEdge> mapaCiudades = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        // Añadir ciudades (vértices)
        String[] ciudades = {"Madrid", "Barcelona", "Valencia", "Sevilla", "Bilbao", "Zaragoza", "Malaga", "Granada"};
        for (String ciudad : ciudades) {
            mapaCiudades.addVertex(ciudad);
        }

        // Añadir carreteras (aristas con peso = distancia en km)
        mapaCiudades.setEdgeWeight(mapaCiudades.addEdge("Madrid", "Zaragoza"), 320);
        mapaCiudades.setEdgeWeight(mapaCiudades.addEdge("Madrid", "Valencia"), 350);
        mapaCiudades.setEdgeWeight(mapaCiudades.addEdge("Zaragoza", "Barcelona"), 300);
        mapaCiudades.setEdgeWeight(mapaCiudades.addEdge("Barcelona", "Valencia"), 360);
        mapaCiudades.setEdgeWeight(mapaCiudades.addEdge("Valencia", "Malaga"), 530);
        mapaCiudades.setEdgeWeight(mapaCiudades.addEdge("Madrid", "Sevilla"), 530);
        mapaCiudades.setEdgeWeight(mapaCiudades.addEdge("Sevilla", "Malaga"), 200);
        mapaCiudades.setEdgeWeight(mapaCiudades.addEdge("Malaga", "Granada"), 130);
        mapaCiudades.setEdgeWeight(mapaCiudades.addEdge("Bilbao", "Zaragoza"), 330);
        mapaCiudades.setEdgeWeight(mapaCiudades.addEdge("Bilbao", "Madrid"), 400);

        // Mostrar vértices y aristas
        System.out.println("Ciudades en el mapa: " + mapaCiudades.vertexSet());
        System.out.println("Carreteras (con distancias): " + mapaCiudades.edgeSet());

        // Dijkstra: encontrar el camino más corto entre dos ciudades
        String origen = "Bilbao";
        String destino = "Granada";

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra =
                new DijkstraShortestPath<>(mapaCiudades);

        List<String> camino = dijkstra.getPath(origen, destino).getVertexList();
        double distancia = dijkstra.getPathWeight(origen, destino);

        System.out.println("\n Camino más corto de " + origen + " a " + destino + ": " + camino);
        System.out.println(" Distancia total: " + distancia + " km");
    }
}

