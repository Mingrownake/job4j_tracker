package ru.job4j.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueRunner {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("first");
        queue.add("second");
        queue.add("thrid");
        System.out.println("Queue state before removing");
        queue.forEach(System.out::println);
        System.out.println();
        queue.remove(); /* удалется first */
        System.out.println("Queue state after removing");
        queue.forEach(System.out::println);
        System.out.println();
        queue.poll();
        queue.poll();
        System.out.println("Queue state after  total removing");
        queue.forEach(System.out::println);
        /* queue.poll(); = null */
        queue.remove();
    }
}
