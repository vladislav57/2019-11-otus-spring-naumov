package ru.otus.homework01.service;

import ru.otus.homework01.model.EnquiryQuestion;
import ru.otus.homework01.model.User;

import java.util.List;

public interface CommunicationService {

    User getUserDataFromUser();

    void getAnswersForAllQuestionsFromUser(List<EnquiryQuestion> enquiryQuestionList);

    void sendEnquiryResultToUser(User user, List<EnquiryQuestion> enquiryQuestionList);
}
