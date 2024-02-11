package ru.job4j.gc.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        List<Object> objectList = createArrayListOfObj();
        ReferenceQueue<List<Object>> objectReferenceQueue = new ReferenceQueue<>();
        SoftReference<List<Object>> listSoftReference = new SoftReference<>(objectList,
                objectReferenceQueue);

        objectList = null;

        System.gc();

        System.out.println("Soft link contains : " + listSoftReference.get());
        System.out.println("Queue contains : " + objectReferenceQueue.poll());
    }

      private static List<Object> createArrayListOfObj() {
          List<Object> objectList = new ArrayList<>();
          for (int i = 0; i <= 10_000; i++) {
            objectList.add(new Object());
          }
          return objectList;
      }
}
