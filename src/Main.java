public class Main {
    public static void main(String[] args) {
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(a, b, 1);
        graph.addEdge(b, c, 3);
        graph.addEdge(a, d, 4);
        graph.addEdge(d, c, 1);

        Search<String> bfs = new BreadthFirstSearch<>(a, c);
        System.out.println("BFS Path: " + bfs.getPath());

        Search<String> dijkstra = new DijkstraSearch<>(a, c);
        System.out.println("Dijkstra Path: " + dijkstra.getPath());
    }
}
