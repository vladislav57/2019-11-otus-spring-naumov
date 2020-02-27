package ru.otus.homework03.application.datasource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.homework03.domain.model.EnquiryQuestion;

import java.util.List;
import java.util.Locale;

class InitQuestionsFromFileServiceImplUnitTest {

    @Test
    void testServiceCanReadAllQuestionsFromValidFile() {
        final InitQuestionsFromFileServiceImpl initQuestionsService =
                new InitQuestionsFromFileServiceImpl("valid-file", Locale.US);
        final List<EnquiryQuestion> questionList = initQuestionsService.getAllQuestions();
        Assertions.assertThat(questionList).isNotNull().hasSize(5);
    }

    @Test
    void testServiceReturnsEmptyListForNonExistingFile() {
        final InitQuestionsFromFileServiceImpl initQuestionsService =
                new InitQuestionsFromFileServiceImpl("non-existing-file", Locale.US);
        final List<EnquiryQuestion> questionList = initQuestionsService.getAllQuestions();
        Assertions.assertThat(questionList).isNotNull().isEmpty();
    }
}
