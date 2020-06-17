package br.com.mhbp.graph.dfs;

import br.com.mhbp.graph.bfs.MatrixConnectedRegionsBFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MatrixConnectedRegionsDFS {
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

    static void flip(int x, int y, List<List<Boolean>> matrix) {
        Boolean color = matrix.get(x).get(y);

        matrix.get(x).get(y);//flip, it is like mark as visited

        ArrayList<Coordinate> tries = new ArrayList<>();
        tries.add(new Coordinate(x + 1, y));
        tries.add(new Coordinate(x - 1, y));
        tries.add(new Coordinate(x, y + 1));
        tries.add(new Coordinate(x, y - 1));

        for (Coordinate newC : tries) {
            if ( newC.x >= 0 && newC.x < matrix.size() && newC.y >= 0 && newC.y < matrix.size() && matrix.get(newC.x).get(newC.y) == color) {
                flip(newC.x, newC.y, matrix);
            }
        }
    }
}
