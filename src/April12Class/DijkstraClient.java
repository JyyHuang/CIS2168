public class DijkstraClient {
<<<<<<< Updated upstream
  public static void main(String[] args) {
    In in = new In("1000EWG.txt");
    WeightedDiGraph G = new WeightedDiGraph(in);
    int s = 0;

    // compute the shortest paths
    Dijkstra sp = new Dijkstra(G, s);
    System.out.println(sp.distTo(6));

    // print shortest paths
    for (int t = 0; t < G.V(); t++) {
      if (sp.hasPathTo(t)) {
        System.out.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
        for (DirectedEdge e : sp.pathTo(t))
          System.out.print(e + "   ");
        System.out.println();
      } else
        System.out.printf("%d to %d         no path\n", s, t);
    }
  }
=======
   public static void main(String[] args) {
      In in = new In("1000EWG.txt");
      WeightedDiGraph G = new WeightedDiGraph(in);
      int s = 21;

      // compute the shortest paths
      Dijkstra sp = new Dijkstra(G, s);
      System.out.println(sp.distTo(68));

      // print shortest paths
      for (int t = 68; t <= 68; t++) {
         if (sp.hasPathTo(t)) {
            System.out.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
            for (DirectedEdge e : sp.pathTo(t))
               System.out.print(e + "   ");
            System.out.println();
         }
         else System.out.printf("%d to %d         no path\n", s, t);
      }
   }
>>>>>>> Stashed changes
}
