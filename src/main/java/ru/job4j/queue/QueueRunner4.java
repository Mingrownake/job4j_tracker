package ru.job4j.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueRunner4 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        System.out.println(queue.peek());
        System.out.println(queue.element());
    }
}
