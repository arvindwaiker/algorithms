package io.awklabs.datastructures.graph.dijkstra;

public class DijkstraShortestPath {

  public int[] dijkstra(int[][] graph, int src) {
    int n = graph.length;

    int[] dist = new int[n];
    boolean[] sptSet = new boolean[n]; // Shortest Path Tree Set

    // Set the Defaults
    for (int i = 0; i < n; i++) {
      dist[i] = Integer.MAX_VALUE;
      sptSet[i] = false;
    }

    dist[src] = 0;

    for (int i = 0; i < n - 1; i++) {

      int min_index = minimumDistanceVertex(dist, sptSet);

      sptSet[min_index] = true;

      for (int j = 0; j < n; j++) {
        if (!sptSet[j]
            && graph[min_index][j] != 0
            && dist[min_index] != Integer.MAX_VALUE
            && dist[min_index] + graph[min_index][j] < dist[j]) {
          dist[j] = dist[min_index] + graph[min_index][j];
        }
      }
    }
    return dist;
  }

  private int minimumDistanceVertex(int[] dist, boolean[] sptSet) {

    int min = Integer.MAX_VALUE;
    int min_index = -1;

    int n = dist.length;

    for (int i = 0; i < n; i++) {
      if (!sptSet[i] && dist[i] <= min) {
        min = dist[i];
        min_index = i;
      }
    }

    return min_index;
  }
}
