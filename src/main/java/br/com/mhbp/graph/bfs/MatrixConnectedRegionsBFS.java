package br.com.mhbp.graph.bfs;

import java.util.*;

public class MatrixConnectedRegionsBFS {
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

    static void flipColor(int x, int y, List<List<Boolean>> matrix) {
        Boolean color = matrix.get(x).get(y);
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.addLast(new Coordinate(x, y));
        matrix.get(x).set(y, !matrix.get(x).get(y));//flip, so we not come back


        while (!queue.isEmpty()) {
            queue.element();
            Coordinate c = queue.element();


            ArrayList<Coordinate> tries = new ArrayList<>();
            tries.add(new Coordinate(x + 1, y));
            tries.add(new Coordinate(x - 1, y));
            tries.add(new Coordinate(x, y + 1));
            tries.add(new Coordinate(x, y - 1));

            for (Coordinate newC : tries) {

                if ( newC.x >= 0 && newC.x < matrix.size() && newC.y >= 0 && newC.y < matrix.size() && matrix.get(newC.x).get(newC.y) == color) {
                    matrix.get(x).set(y, !color);
                    queue.add(newC);
                }
            }
            queue.remove();
        }
    }
}
