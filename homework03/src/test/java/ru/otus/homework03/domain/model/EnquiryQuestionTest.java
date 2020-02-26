package ru.otus.homework03.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class EnquiryQuestionTest {

    @Mock
    private Answer incorrectAnswer, correctAnswer;
    private EnquiryQuestion question;

    @BeforeEach
    private void prepareQuestion() {
        final List<Answer> answerList = Arrays.asList(correctAnswer, incorrectAnswer);
        question = new EnquiryQuestion("testQuestionText", answerList);
    }

    @Test
    void testQuestionTextSetting() {
        Assertions.assertThat(question.getQuestionText()).isEqualTo("testQuestionText");
    }

    @Test
    void testAnswerQuestionCorrectly() {
        Mockito.when(correctAnswer.isCorrect()).thenReturn(true);

        question.checkAnswer("1");

        Mockito.verifyNoInteractions(incorrectAnswer);
        Mockito.verify(correctAnswer).isCorrect();
        Assertions.assertThat(question.isUserAnswerCorrect()).isTrue();
    }

    @Test
    void testAnswerQuestionIncorrectly() {
        Mockito.when(incorrectAnswer.isCorrect()).thenReturn(false);

        question.checkAnswer("2");

        Mockito.verifyNoInteractions(correctAnswer);
        Mockito.verify(incorrectAnswer).isCorrect();
        Assertions.assertThat(question.isUserAnswerCorrect()).isFalse();
    }

    @Test
    void testGeneratedAnswerText() {
        Mockito.when(correctAnswer.getText()).thenReturn("correctAnswerText");
        Mockito.when(incorrectAnswer.getText()).thenReturn("incorrectAnswerText");

        Assertions.assertThat(question.getAnswersText()).isEqualTo("1.correctAnswerText\t2.incorrectAnswerText");
    }

}
