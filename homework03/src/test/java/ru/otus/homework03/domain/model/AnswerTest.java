package ru.otus.homework03.domain.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class AnswerTest {

    @Test
    void testCreateCorrectAnswerWithConstructor() {
        final Answer answer = new Answer("testText", true);
        final SoftAssertions softly = new SoftAssertions();
        softly.assertThat(answer.getText()).isEqualTo("testText");
        softly.assertThat(answer.isCorrect()).isTrue();
        softly.assertAll();
    }

    @Test
    void testCreateWrongAnswerWithConstructor() {
        final Answer answer = new Answer("testText", false);
        final SoftAssertions softly = new SoftAssertions();
        softly.assertThat(answer.getText()).isEqualTo("testText");
        softly.assertThat(answer.isCorrect()).isFalse();
        softly.assertAll();
    }
}
