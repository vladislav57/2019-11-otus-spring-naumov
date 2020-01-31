package ru.otus.homework01.model;

public class Answer {

    private final String text;
    private final boolean isCorrect;

    public Answer(final String text, final boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    String getText() {
        return text;
    }

    boolean isCorrect() {
        return isCorrect;
    }
}
