package br.com.mhbp.backtracking.maze;

public class MazeSolver {

    int[][] maze;
    int N = 8;

    public static void main(String[] args) {
        MazeSolver mazeSolver = new MazeSolver();

        mazeSolver.setMap("basic");
        mazeSolver.solve(0, 0);
    }

    private void setMap(String basic) {

    }

    public MazeSolver() {
        this.maze = new int[N][N];
        //fill it up with the map
    }
    public void solve(int x, int y) {

        if(isThereSolution(x, y)) {

        } else {
            System.out.println("there is no solution");
        }

    }

    private boolean isThereSolution(int x, int y) {

        if (x == N && y == N) return true;


        if (maze[x + 1][y] == 0) { //can go down
            maze[x + 1][y] = -1;
            if (isThereSolution(x + 1, y)) {
                return true;
            }
            maze[x + 1][y] = 0;

        } else if (maze[x][y + 1] == 0) {// can go right
            maze[x][y + 1] = -1;
            if (isThereSolution(x, y + 1)) {
                return true;
            }
            maze[x][y + 1] = 0;

        }

        return false;
    }
}
