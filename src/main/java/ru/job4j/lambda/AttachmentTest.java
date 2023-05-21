package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class AttachmentTest {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        };
        Comparator<Attachment> cmpText = (att1, att2) ->
                att1.getName().compareTo(att2.getName());

        Comparator<Attachment> cmpDescSize = (att1, att2) ->
                Integer.compare(att2.getSize(), att1.getSize());
        Arrays.sort(atts, cmpText);
        System.out.println(Arrays.toString(atts));
        Arrays.sort(atts, cmpDescSize);
        System.out.println(Arrays.toString(atts));
    }
}
