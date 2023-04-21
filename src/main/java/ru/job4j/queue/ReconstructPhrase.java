package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder str = new StringBuilder();
        int elementsSize = evenElements.size();
           for (int i = 0; i < elementsSize - i; i++) {
            str.append(evenElements.pollFirst());
            evenElements.pollFirst();
        }
        return str.toString();

    }

    private String getDescendingElements() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < descendingElements.size() + i; i++) {
            str.append(descendingElements.pollLast());
        }
        return str.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
