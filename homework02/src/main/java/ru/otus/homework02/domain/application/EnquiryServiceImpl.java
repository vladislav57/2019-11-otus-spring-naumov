package ru.otus.homework02.domain.application;

import ru.otus.homework02.domain.model.EnquiryQuestion;
import ru.otus.homework02.domain.model.User;

import java.util.List;

public class EnquiryServiceImpl implements EnquiryService {

    private final CommunicationService communicationService;
    private final InitQuestionsService initQuestionsService;

    public EnquiryServiceImpl(final CommunicationService communicationService,
                              final InitQuestionsService initQuestionsService) {
        this.communicationService = communicationService;
        this.initQuestionsService = initQuestionsService;
    }

    @Override
    public void performEnquiryWithAllQuestions() {
        final User user = communicationService.getUserDataFromUser();
        final List<EnquiryQuestion> enquiryQuestionList = initQuestionsService.getAllQuestions();
        communicationService.getAnswersForAllQuestionsFromUser(enquiryQuestionList);
        communicationService.sendEnquiryResultToUser(user, enquiryQuestionList);
    }
}
