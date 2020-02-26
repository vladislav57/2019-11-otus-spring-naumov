package ru.otus.homework03.application.datasource;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import ru.otus.homework03.domain.model.EnquiryQuestion;

import java.util.List;
import java.util.Locale;

class InitQuestionsFromFileServiceImplUnitTest {

    @Test
    void testServiceCanReadQuestionsFromValidFile() {
        final InitQuestionsFromFileServiceImpl initQuestionsService =
                new InitQuestionsFromFileServiceImpl("valid-file", Locale.US);
        final List<EnquiryQuestion> questionList = initQuestionsService.getAllQuestions();
        final SoftAssertions softly = new SoftAssertions();
        softly.assertThat(questionList)
                .withFailMessage("Failed to create EnquiryQuestion list")
                .isNotNull();
        softly.assertThat(questionList.size())
                .withFailMessage("Failed to parse all questions from file")
                .isEqualTo(5);
        softly.assertAll();
    }

    @Test
    void testServiceReturnsEmptyListForNonExistingFile() {
        final InitQuestionsFromFileServiceImpl initQuestionsService =
                new InitQuestionsFromFileServiceImpl("non-existing-file", Locale.US);
        final List<EnquiryQuestion> questionList = initQuestionsService.getAllQuestions();
        final SoftAssertions softly = new SoftAssertions();
        softly.assertThat(questionList)
                .withFailMessage("Failed to create EnquiryQuestion list")
                .isNotNull();
        softly.assertThat(questionList)
                .withFailMessage("Failed to parse all questions from file")
                .isEmpty();
        softly.assertAll();
    }
}
