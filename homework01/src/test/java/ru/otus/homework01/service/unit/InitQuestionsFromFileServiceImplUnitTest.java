package ru.otus.homework01.service.unit;

import org.junit.Assert;
import org.junit.Test;
import ru.otus.homework01.model.EnquiryQuestion;
import ru.otus.homework01.service.InitQuestionsFromFileServiceImpl;

import java.util.List;

public class InitQuestionsFromFileServiceImplUnitTest {

    @Test
    public void testServiceCanReadQuestionsFromValidFile() {
        final InitQuestionsFromFileServiceImpl initQuestionsService =
                new InitQuestionsFromFileServiceImpl("valid-file.csv");
        final List<EnquiryQuestion> questionList = initQuestionsService.getAllQuestions();
        Assert.assertNotNull("Failed to create EnquiryQuestion list", questionList);
        Assert.assertEquals("Failed to parse all questions from file", 5, questionList.size());
    }

    @Test
    public void testServiceReturnsEmptyListForNonExistingFile() {
        final InitQuestionsFromFileServiceImpl initQuestionsService =
                new InitQuestionsFromFileServiceImpl("non-existing-file.csv");
        final List<EnquiryQuestion> questionList = initQuestionsService.getAllQuestions();
        Assert.assertNotNull("Failed to create EnquiryQuestion list", questionList);
        Assert.assertTrue("For non existing file generated questions list should be empty", questionList.isEmpty());
    }
}
