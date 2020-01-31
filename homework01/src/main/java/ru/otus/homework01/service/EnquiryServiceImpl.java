package ru.otus.homework01.service;

import ru.otus.homework01.model.EnquiryQuestion;
import ru.otus.homework01.model.User;

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
        User user = communicationService.getUserDataFromUser();
        List<EnquiryQuestion> enquiryQuestionList = initQuestionsService.getAllQuestions();
        communicationService.getAnswersForAllQuestionsFromUser(enquiryQuestionList);
        communicationService.sendEnquiryResultToUser(user, enquiryQuestionList);
    }
}
