import java.util.Random;

/******************************************************************************
 *  Compilation:  javac Maze.java
 *  Execution:    java Maze.java n
 *  Dependencies: Draw.java
 *
 *  Generates a perfect n-by-n maze using depth-first search with a stack.
 *
 *  % java Maze 62
 *
 *  % java Maze 61
 *
 *  Note: this program generalizes nicely to finding a random tree
 *        in a graph.
 *
 ******************************************************************************/

public class Maze {
    private int n;                 // dimension of maze
    private boolean[][] north;     // is there a wall to north of cell i, j
    private boolean[][] east;
    private boolean[][] south;
    private boolean[][] west;
    private boolean[][] visited;
    private boolean done = false;

    public Maze(int n) {
        this.n = n;
        Draw.setXscale(0, n+2);
        Draw.setYscale(0, n+2);
        init();
        generate();
    }

    private void init() {
        // initialize border cells as already visited
        visited = new boolean[n+2][n+2];
        for (int x = 0; x < n+2; x++) {
            visited[x][0] = true;
            visited[x][n+1] = true;
        }
        for (int y = 0; y < n+2; y++) {
            visited[0][y] = true;
            visited[n+1][y] = true;
        }


        // initialze all walls as present
        north = new boolean[n+2][n+2];
        east  = new boolean[n+2][n+2];
        south = new boolean[n+2][n+2];
        west  = new boolean[n+2][n+2];
        for (int x = 0; x < n+2; x++) {
            for (int y = 0; y < n+2; y++) {
                north[x][y] = true;
                east[x][y]  = true;
                south[x][y] = true;
                west[x][y]  = true;
            }
        }
    }


    // generate the maze
    private void generate(int x, int y) {
        visited[x][y] = true;
        Random random = new Random();

        // while there is an unvisited neighbor
        while (!visited[x][y+1] || !visited[x+1][y] || !visited[x][y-1] || !visited[x-1][y]) {

            // pick random neighbor (could use Knuth's trick instead)
            while (true) {
                double r = random.nextInt(4);
                if (r == 0 && !visited[x][y+1]) {
                    north[x][y] = false;
                    south[x][y+1] = false;
                    generate(x, y + 1);
                    break;
                }
                else if (r == 1 && !visited[x+1][y]) {
                    east[x][y] = false;
                    west[x+1][y] = false;
                    generate(x+1, y);
                    break;
                }
                else if (r == 2 && !visited[x][y-1]) {
                    south[x][y] = false;
                    north[x][y-1] = false;
                    generate(x, y-1);
                    break;
                }
                else if (r == 3 && !visited[x-1][y]) {
                    west[x][y] = false;
                    east[x-1][y] = false;
                    generate(x-1, y);
                    break;
                }
            }
        }
    }

    // generate the maze starting from lower left
    private void generate() {
        generate(1, 1);

/*
        // delete some random walls
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int x = 1 + random.nextInt(n-1);
            int y = 1 + random.nextInt(n-1);
            north[x][y] = south[x][y+1] = false;
        }

        // add some random walls
        for (int i = 0; i < 10; i++) {
            int x = n/2 + random.nextInt(n/2);
            int y = n/2 + random.nextInt(n/2);
            east[x][y] = west[x+1][y] = true;
        }
*/
     
    }



    // solve the maze using depth-first search
    private void solve(int x, int y) {
        if (x == 0 || y == 0 || x == n+1 || y == n+1) return;
        if (done || visited[x][y]) return;
        visited[x][y] = true;

        Draw.setPenColor(Draw.BLUE);
        Draw.filledCircle(x + 0.5, y + 0.5, 0.25);
        Draw.show();
        Draw.pause(30);

        // reached middle
        if (x == n/2 && y == n/2) done = true;

        if (!north[x][y]) solve(x, y + 1);
        if (!east[x][y])  solve(x + 1, y);
        if (!south[x][y]) solve(x, y - 1);
        if (!west[x][y])  solve(x - 1, y);

        if (done) return;

        Draw.setPenColor(Draw.TEMPLE_SILVER);
        Draw.filledCircle(x + 0.5, y + 0.5, 0.25);
        Draw.show();
        Draw.pause(30);
    }

    // solve the maze starting from the start state
    public void solve() {
        for (int x = 1; x <= n; x++)
            for (int y = 1; y <= n; y++)
                visited[x][y] = false;
        done = false;
        solve(1, 1);
    }

    // draw the maze
    public void draw() {
        Draw.setPenColor(Draw.TEMPLE_CHERRY);
        Draw.filledCircle(n/2.0 + 0.5, n/2.0 + 0.5, 0.375);
        Draw.filledCircle(1.5, 1.5, 0.375);

        Draw.setPenColor(Draw.BLACK);
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (south[x][y]) Draw.line(x, y, x+1, y);
                if (north[x][y]) Draw.line(x, y+1, x+1, y+1);
                if (west[x][y])  Draw.line(x, y, x, y+1);
                if (east[x][y])  Draw.line(x+1, y, x+1, y+1);
            }
        }
        Draw.show();
        Draw.pause(1000);
    }



    // a test client
    public static void main(String[] args) {
        //int n = Integer.parseInt(args[0]);
        int n = 22;
        Maze maze = new Maze(n);
        Draw.enableDoubleBuffering();
        maze.draw();
        maze.solve();
    }

}

