package br.com.mhbp.datastructure.disjointset;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DisjointSet {

    static class Node {
        int rank;
        Node parent;

        Node(Node parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    HashMap<DisjointSet.Node, DisjointSet.Node> objectsToNodes = new HashMap();

    //find set of node
    public void removeSet(DisjointSet.Node set) {//rootSet
        DisjointSet.Node rootSet = findSet(set);
        if (rootSet != null) {
            for (Iterator it = objectsToNodes.keySet().iterator(); it.hasNext();) {
                DisjointSet.Node next = (DisjointSet.Node) it.next();
                //remove the rootSet representative last, otherwise findSet will fail
                if (next != rootSet && findSet(next) == rootSet)
                    it.remove();
            }
            objectsToNodes.remove(rootSet);
        }
    }

    public void toList(List list) {
        list.addAll(objectsToNodes.keySet());
    }

    public DisjointSet.Node findSet(DisjointSet.Node o) {
        DisjointSet.Node node =  objectsToNodes.get(o);
        if (node == null) //node does not belong to any set.
            return null;
        if (o != node.parent) //node's parent is not the root set yet, so keep looking for recursively
            node.parent = findSet(node.parent);
        return node.parent;
    }

    public void union(DisjointSet.Node x, DisjointSet.Node y) {
        DisjointSet.Node setX = findSet(x);
        DisjointSet.Node setY = findSet(y);
        if (setX == null || setY == null || setX == setY)
            return;
        DisjointSet.Node nodeX = objectsToNodes.get(setX);
        DisjointSet.Node nodeY = objectsToNodes.get(setY);
        //join the two sets by pointing the root of one at the root of the other
        if (nodeX.rank > nodeY.rank) {
            nodeY.parent = x;
        } else {
            nodeX.parent = y;
            if (nodeX.rank == nodeY.rank)
                nodeY.rank++;
        }
    }
}
