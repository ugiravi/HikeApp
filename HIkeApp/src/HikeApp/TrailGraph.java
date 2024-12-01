package HikeApp;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a network of trails as a directed weighted graph.
 * Provides methods to add trails and find the shortest path between two trails.
 */
public class TrailGraph {
    private EdgeWeightedDigraph graph; // The directed weighted graph
    private Map<Integer, Trail> idToTrail; // Maps trail IDs to Trail objects
    private int vertexCounter; // Tracks the number of vertices

    /**
     * Constructs an empty TrailGraph.
     */
    public TrailGraph() {
        this.graph = new EdgeWeightedDigraph(0);
        this.idToTrail = new HashMap<>();
        this.vertexCounter = 0;
    }

    /**
     * Adds a Trail to the graph.
     * 
     * @param trail the Trail object to be added
     */
    public void addTrail(Trail trail) {
        if (!idToTrail.containsKey(trail.getId())) {
            idToTrail.put(trail.getId(), trail);
            vertexCounter++;
            graph = new EdgeWeightedDigraph(vertexCounter); // Resize graph to include the new vertex
        }
    }

    /**
     * Adds a connection (edge) between two trails with a specified weight.
     * 
     * @param trail1   the first Trail object
     * @param trail2   the second Trail object
     * @param weight   the weight of the edge (distance)
     */
    public void connectTrails(Trail trail1, Trail trail2, double weight) {
        graph.addEdge(new DirectedEdge(trail1.getId(), trail2.getId(), weight));
    }

    /**
     * Finds the shortest path between two trails.
     * 
     * @param startTrail the starting Trail object
     * @param endTrail   the destination Trail object
     * @return the shortest path as a string, or null if no path exists
     */
    public String findShortestPath(Trail startTrail, Trail endTrail) {
        int start = startTrail.getId();
        int end = endTrail.getId();

        DijkstraSP sp = new DijkstraSP(graph, start);

        if (!sp.hasPathTo(end)) {
            return null; // No path exists
        }

        StringBuilder path = new StringBuilder("Shortest path: ");
        for (DirectedEdge edge : sp.pathTo(end)) {
            path.append(idToTrail.get(edge.from()).getName()).append(" -> ");
        }
        path.append(idToTrail.get(end).getName()).append(" (Total weight: ").append(sp.distTo(end)).append(")");

        return path.toString();
    }
    public Collection<Trail> getTrails() {
        return idToTrail.values();
    }

}