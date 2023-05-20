package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        };
        Comparator<Attachment> comparator = (o1, o2) -> Integer.compare(o1.getSize(), o2.getSize());
        /** Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };*/
        Arrays.sort(atts, comparator);
    }
}
