import java.util.*;

public class Dijkstra {
  private static int distance(ArrayList<Integer>[] adj,
                              ArrayList<Integer>[] cost, int s, int t) {
    PriorityQueue<Integer> minpq = new PriorityQueue<>();
    int[] dist = new int[adj.length];

    for (int v = 0; v < adj.length; v++) {
      dist[v] = Integer.MAX_VALUE;
    }
    dist[s] = 0;

    minpq.add(s);

    while (!minpq.isEmpty()) {
      int u = minpq.poll();
      for (int i = 0; i < adj[u].size(); i++) {
        int v = adj[u].get(i);
        int weight = cost[u].get(i);

        if (dist[v] >= dist[u] + weight) {
          dist[v] = dist[u] + weight;
          minpq.add(v);
        }
      }
    }

    if (dist[t] == Integer.MAX_VALUE) {
      return -1;
    }

    return dist[t];
  }

  public static void main(String[] args) {
    In in = new In("G4-2.txt");
    int n = in.readInt();
    int m = in.readInt();
    ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
    ArrayList<Integer>[] cost = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<Integer>();
      cost[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < m; i++) {
      int x, y, w;
      x = in.readInt();
      y = in.readInt();
      w = in.readInt();
      adj[x - 1].add(y - 1);
      cost[x - 1].add(w);
    }
    int x = in.readInt() - 1;
    int y = in.readInt() - 1;
    System.out.println(distance(adj, cost, x, y));
  }
}
