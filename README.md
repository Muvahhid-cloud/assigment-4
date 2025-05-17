# Assignment 4 - Edge-Weighted Graphs using Vertex Objects

## Objective

Implement an edge-weighted graph using `Vertex` objects instead of direct `Edge` storage.  
Demonstrate how this affects graph structure and traversal using:

- **Breadth-First Search (BFS)**
- **Dijkstra’s Algorithm**

---

## Project Structure

/src
│
├── Vertex.java // Vertex representation with adjacency map
├── Edge.java // Edge object for reference and testing
├── WeightedGraph.java // Graph that uses Vertex as the primary structure
│
├── Search.java // Abstract class for search strategies
├── BreadthFirstSearch.java // BFS pathfinding (unweighted)
├── DijkstraSearch.java // Dijkstra pathfinding (weighted)
│
└── Main.java // Example usage and output

---

## How It Works

### Vertex-based Graph
Each `Vertex` maintains a map of adjacent vertices with associated edge weights:
```java
Map<Vertex<V>, Double> adjacentVertices;
  WeightedGraph
Stores a set of all vertices.

Adds edges by updating adjacency maps.

 Search Abstractions
Search<V> is an abstract class defining getPath() method.

BreadthFirstSearch explores shortest path in unweighted terms.

DijkstraSearch finds the least-cost path using weights.

Notes

This solution assumes the usage of Vertex as graph nodes and maintains all edge weights inside vertex maps.
Compatible with existing Main class structure from course GitHub.
