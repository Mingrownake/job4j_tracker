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
        int evenElementsSize = evenElements.size() / 2;
           for (int i = 0; i < evenElementsSize; i++) {
            str.append(evenElements.pollFirst());
            evenElements.pollFirst();
        }
        return str.toString();

    }

    private String getDescendingElements() {
        StringBuilder str = new StringBuilder();
        int descendingElementsSize = descendingElements.size();
        for (int i = 0; i < descendingElementsSize; i++) {
            str.append(descendingElements.pollLast());
        }
        return str.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
