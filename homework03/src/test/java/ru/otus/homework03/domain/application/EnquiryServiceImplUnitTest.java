package ru.otus.homework03.domain.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework03.domain.model.EnquiryQuestion;
import ru.otus.homework03.domain.model.User;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class EnquiryServiceImplUnitTest {

    @Mock
    private List<EnquiryQuestion> enquiryQuestionList;
    @Mock
    private User user;
    @Mock
    private InitQuestionsService initQuestionsService;
    @Mock
    private CommunicationService communicationService;
    @InjectMocks
    private EnquiryServiceImpl enquiryService;

    @Test
    void testPerformInquiryWithAllQuestions() {
        Mockito.when(initQuestionsService.getAllQuestions()).thenReturn(enquiryQuestionList);
        Mockito.when(communicationService.getUserDataFromUser()).thenReturn(user);

        enquiryService.performEnquiryWithAllQuestions();

        Mockito.verify(initQuestionsService).getAllQuestions();
        Mockito.verify(communicationService).getUserDataFromUser();
        Mockito.verify(communicationService).getAnswersForAllQuestionsFromUser(enquiryQuestionList);
        Mockito.verify(communicationService).sendEnquiryResultToUser(user, enquiryQuestionList);
    }
}
