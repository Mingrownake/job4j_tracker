package ru.job4j.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueRunner3 {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayBlockingQueue<>(3);
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        queue.forEach(System.out::println);
    }

}
