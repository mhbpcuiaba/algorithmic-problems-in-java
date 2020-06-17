package br.com.mhbp.graph.bfs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class MatrixEnclosedRegionsBFS {
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

    static void fillSurroundedRegions(List<List<Character>> matrix) {

        //first and last cols
        for (int i = 0; i < matrix.size(); i++) {
            markBoundaryRegion(i, 0, matrix);
            markBoundaryRegion(i, matrix.get(i).size() - 1, matrix);
        }

        //first and last rows
        for (int i = 0; i < matrix.size(); i++) {
            markBoundaryRegion(0, i, matrix);
            markBoundaryRegion(matrix.size() - 1, i, matrix);
        }

        for (int i = 0; i < matrix.size(); i++) {
            for (int k = 0; k < matrix.get(i).size(); k++) {
                char c = matrix.get(i).get(k) != 'T' ? 'B' : 'W';
                matrix.get(i).set(k, c);
            }
        }
    }
    static void markBoundaryRegion(int x, int y, List<List<Character>> matrix) {

        Queue<Coordinate> q = new ArrayDeque<>();
        q.add(new Coordinate(x, y));

        while (!q.isEmpty()) {
            Coordinate c = q.poll();

            //current coordinate is valid? so add its neighbours!!!
            if (c.x >= 0 && c.x < matrix.size() && c.y >= 0 && c.y < matrix.get(x).size() && matrix.get(x).get(y) == 'W') {
                matrix.get(x).set(y, 'T');

                q.add(new Coordinate(c.x + 1, c.y));
                q.add(new Coordinate(c.x - 1, c.y));
                q.add(new Coordinate(c.x, c.y + 1));
                q.add(new Coordinate(c.x, c.y - 1));
            }
        }
    }
}
