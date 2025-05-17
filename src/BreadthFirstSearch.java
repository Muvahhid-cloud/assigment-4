import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {

    private Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private Set<Vertex<V>> visited = new HashSet<>();

    public BreadthFirstSearch(Vertex<V> start, Vertex<V> end) {
        super(start, end);
        bfs(start);
    }

    private void bfs(Vertex<V> current) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.add(current);
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex<V> vertex = queue.poll();
            for (Vertex<V> v : vertex.getAdjacentVertices().keySet()) {
                if (!visited.contains(v)) {
                    edgeTo.put(v, vertex);
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath() {
        if (!visited.contains(end)) return null;

        List<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = end; x != start; x = edgeTo.get(x)) {
            path.add(0, x);
        }
        path.add(0, start);
        return path;
    }
}
