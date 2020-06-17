package br.com.mhbp.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * good for webcrawler
 */
public class BreadthFirstSearch {


    LinkedList<Node> queue = new LinkedList<Node>();
    public void printSearch(Node startNode) {

        if (!startNode.visited) {
            System.out.println(startNode.value);
            startNode.visited = true;
            for (Node neighbour : startNode.neighbours) {
                if (!neighbour.visited) {
                    queue.add(neighbour);
                }
            }
        }

        if (!queue.isEmpty()) {
            printSearch(queue.remove());
        }


    }

    public static void main(String[] args) {

        Node n1 = new Node(12);
        Node n2 = new Node(31);
        Node n3 = new Node(424);
        Node n4 = new Node(123);
        Node n5 = new Node(644);
        Node n6 = new Node(4);
        Node n7 = new Node(77);

        n1.neighbours.add(n2);
        n1.neighbours.add(n6);


        n2.neighbours.add(n7);
        n2.neighbours.add(n6);
        n2.neighbours.add(n5);

        n3.neighbours.add(n1);
        n3.neighbours.add(n5);
        n3.neighbours.add(n7);

        n4.neighbours.add(n2);
        n4.neighbours.add(n3);
        n4.neighbours.add(n5);

        n5.neighbours.add(n6);

        n6.neighbours.add(n2);
        n6.neighbours.add(n4);
        n6.neighbours.add(n7);

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.printSearch(n1);
        System.out.println("oi");
    }
}

class Node {
    int value;
    Set<Node> neighbours;
    boolean visited =false;

    public Node(int value) {
        this.value = value;
        neighbours =new HashSet<Node>();
    }
}