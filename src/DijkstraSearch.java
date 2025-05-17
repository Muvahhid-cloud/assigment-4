import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distances = new HashMap<>();
    private final Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();

    public DijkstraSearch(Vertex<V> start, Vertex<V> end) {
        super(start, end);
        dijkstra();
    }

    private void dijkstra() {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        for (Vertex<V> vertex : start.getAdjacentVertices().keySet()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double currentDistance = distances.getOrDefault(current, Double.POSITIVE_INFINITY);

                double newDistance = currentDistance + weight;
                if (newDistance < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath() {
        List<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> at = end; at != null; at = previous.get(at)) {
            path.add(0, at);
        }
        return path.isEmpty() || !path.get(0).equals(start) ? null : path;
    }
}
