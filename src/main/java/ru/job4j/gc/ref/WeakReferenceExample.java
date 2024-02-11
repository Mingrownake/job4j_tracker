package ru.job4j.gc.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Date;

public class WeakReferenceExample {
    public static void main(String[] args) {
        Date date = new Date();
        ReferenceQueue<Date> referenceQueue = new ReferenceQueue<>();
        WeakReference<Date> weakDate = new WeakReference<>(date, referenceQueue);

        date = null;

        System.gc();
        System.out.println("Weak link : " + weakDate.get());
        System.out.println("Reference queue contains : " + referenceQueue.poll());
    }
}
