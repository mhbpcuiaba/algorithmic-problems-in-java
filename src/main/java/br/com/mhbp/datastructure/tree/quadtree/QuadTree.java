package br.com.mhbp.datastructure.tree.quadtree;

/*
* specialize DS for spatial queries
* =>> https://jimkang.com/quadtreevis/
*
* Quadtrees are a way of partitioning space so that it's easy to traverse and search. Some possible uses of that include:
quadtrees can help out any time you have sparse data that you need to search.
* Just use quadtrees to map out the cells with the interesting data.
 - Hit detection
 - Finding the nearest neighbor
 *
 */

import java.util.ArrayList;
import java.util.List;

//https://gist.github.com/AbhijeetMajumdar/c7b4f10df1b87f974ef4
public class QuadTree {

    final int MAX_CAPACITY =4;
    int level = 0;
    List<Node> nodes;
    QuadTree northWest = null;
    QuadTree northEast = null;
    QuadTree southWest = null;
    QuadTree southEast = null;
    Boundary boundary;

    QuadTree(int level, Boundary boundary) {
        this.level = level;
        nodes = new ArrayList<Node>();
        this.boundary = boundary;
    }

    void dfs(QuadTree tree) {

    }

    void split() {

    }

    void insert(int x, int y, int value) {

    }
}

class Node {
    int x, y, value;

    Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value; /* some data*/
    }
}

class Boundary {

    int xMin, yMin, xMax, yMax;

    public Boundary(int xMin, int yMin, int xMax, int yMax) {
        super();
        /*
         *  Storing two diagonal points
         */
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public boolean inRange(int x, int y) {
        return (x >= this.getxMin() && x <= this.getxMax()
                && y >= this.getyMin() && y <= this.getyMax());
    }

    public int getxMin() {
        return xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }
}
