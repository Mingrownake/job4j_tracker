package ru.job4j.lambda;

import java.util.Comparator;

public class StringsCompare {
    Comparator<String> cmpText = (left, right) ->
            left.compareTo(right);

    Comparator<String> cmpDescSize = (left, right) ->
            Integer.compare(right.length(), left.length());
}
