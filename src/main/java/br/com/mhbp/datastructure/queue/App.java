package br.com.mhbp.datastructure.queue;

public class App {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(10);
        queue.enqueue(100);
        queue.enqueue(1000);

        System.out.println(queue.size());
        System.out.println(queue.dequeue());

        System.out.println(queue.size());
        System.out.println(queue.dequeue());

        System.out.println(queue.size());
        System.out.println(queue.dequeue());

        System.out.println(queue.size());

        System.out.println(queue.dequeue());
    }
}
