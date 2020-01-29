package ru.otus.homework01.service.integration;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework01.model.EnquiryQuestion;
import ru.otus.homework01.service.CommunicationService;
import ru.otus.homework01.service.EnquiryService;
import ru.otus.homework01.model.User;
import ru.otus.homework01.service.InitQuestionsService;

import java.util.List;

public class EnquiryServiceImplTest {

    private static ClassPathXmlApplicationContext context;

    @BeforeClass
    public static void setUp() {
        context = new ClassPathXmlApplicationContext("/spring-test-context.xml");
    }

    @Mock
    private List<EnquiryQuestion> enquiryQuestionList;

    @Test
    public void testPerformEnquiryWithAllQuestions() {
        final User user = Mockito.mock(User.class);
        final CommunicationService communicationService = context.getBean(CommunicationService.class);
        Mockito.when(communicationService.getUserDataFromUser()).thenReturn(user);

        final InitQuestionsService initQuestionsService = context.getBean(InitQuestionsService.class);
        Mockito.when(initQuestionsService.getAllQuestions()).thenReturn(enquiryQuestionList);

        final EnquiryService enquiryService = context.getBean(EnquiryService.class);
        enquiryService.performEnquiryWithAllQuestions();

        Mockito.verify(communicationService).getUserDataFromUser();
        Mockito.verify(initQuestionsService).getAllQuestions();
        Mockito.verify(communicationService).getAnswersForAllQuestionsFromUser(enquiryQuestionList);
        Mockito.verify(communicationService).sendEnquiryResultToUser(user, enquiryQuestionList);
    }

}
