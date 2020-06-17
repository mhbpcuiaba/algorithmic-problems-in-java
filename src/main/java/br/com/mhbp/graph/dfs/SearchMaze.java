package br.com.mhbp.graph.dfs;

import java.util.List;
import java.util.Objects;

public class SearchMaze {

    //WHITE == 0, black == 1
    static class Coordinate {
        int x,y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static boolean searchMaze(List<List<Integer>> matrix, Coordinate currentPosition, Coordinate targetPosition, List<Coordinate> path) {

        if ( currentPosition.x <0 || currentPosition.x > matrix.size() || currentPosition.y < 0 || currentPosition.y > matrix.get(currentPosition.x).size() || matrix.get(currentPosition.x).get(currentPosition.y) == 1)
            return false;


        path.add(currentPosition);
        matrix.get(currentPosition.x).set(currentPosition.y, 1);
        if (currentPosition.equals(targetPosition)) return true;


        if (searchMaze(matrix, new Coordinate(currentPosition.x + 1, currentPosition.y), targetPosition, path)) return true;
        if (searchMaze(matrix, new Coordinate(currentPosition.x, currentPosition.y + 1), targetPosition, path)) return true;
        if (searchMaze(matrix, new Coordinate(currentPosition.x - 1, currentPosition.y), targetPosition, path)) return true;
        if (searchMaze(matrix, new Coordinate(currentPosition.x, currentPosition.y - 1 ), targetPosition, path)) return true;

        path.remove(path.size() - 1);
        return false;
    }
}
