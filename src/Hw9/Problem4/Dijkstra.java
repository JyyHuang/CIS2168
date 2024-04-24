import java.util.*;

public class Dijkstra {
  private static double distance(ArrayList<Integer>[] adj,
                              ArrayList<Integer>[] cost, int s, int t) {
    Set<Integer> Q = new HashSet<>(); // vertices not on the shortest path
    double[] dist = new double[adj.length];

    for (int v = 0; v < adj.length; v++) {
      dist[v] = Double.POSITIVE_INFINITY;
      Q.add(v);
    }
    dist[s] = 0;

    while (!Q.isEmpty()) {
      double minDist = Double.POSITIVE_INFINITY;
      int u = -1;
      for (int x : Q)
        if (dist[x] <= minDist) {
          minDist = dist[x];
          u = x;
        }


      Q.remove(u);
      for (int i = 0; i < adj[u].size(); i++) {
        int v = adj[u].get(i);
        int weight = cost[u].get(i);

        if (dist[v] >= dist[u] + weight) {
          dist[v] = dist[u] + weight;
        }
      }
    }

    if (dist[t] == Double.POSITIVE_INFINITY) {
      return -1;
    }

    return dist[t];
  }

  public static void main(String[] args) {
    In in = new In("G4-1.txt");
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
