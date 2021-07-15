package br.com.mhbp.datastructure.disjointset;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DisjointUnionSets {

    int[] rank, parent;
    int n;

    public boolean sameComponent(int x, int y) {
        return find(x) == find(y);
    }
    
    public DisjointUnionSets(int n) {
        this.n = n;
        rank = new int[n];
        parent = IntStream.range(0, n -1).toArray();
    }

    void printParents() {
        Arrays.stream(parent).forEach(System.out::println);
    }

    int find(int x) {
        //if x is not parent of itself Then x is not the representative of his set
        if (parent[x] != x) {
            // so we recursively call Find on its parent and move i's node directly under the representative of this set
            //It means x is not the root of a set, so we should find recursively and also update the whole chain
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Unites the set that includes x and the set that includes x
    void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot != yRoot) {

            if (rank[xRoot] < rank[yRoot]) {
                //then move x under y so that the depth of the tree remains less as possible
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                //then move y under x so that the depth of the tree remains less as possible
                parent[yRoot] = xRoot;
            } else {

                //in this case does not matter which one we pick, I picked y to move under x
                parent[yRoot] = xRoot;
                //and then increment the root since it has grown by 1
                rank[xRoot]++;
            }
        }
    }

    public static void main(String[] args) {
        // Let there be 5 persons with ids as
        // 0, 1, 2, 3 and 4
        int n = 5;
        DisjointUnionSets dus =
                new DisjointUnionSets(n);

        // 0 is a friend of 2
        dus.union(0, 2);

        // 4 is a friend of 2
        dus.union(4, 2);

        // 3 is a friend of 1
        dus.union(3, 1);

        // Check if 4 is a friend of 0
        if (dus.find(4) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Check if 1 is a friend of 0
        if (dus.find(1) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
