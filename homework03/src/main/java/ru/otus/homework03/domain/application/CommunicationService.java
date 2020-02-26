package ru.otus.homework03.domain.application;

import ru.otus.homework03.domain.model.EnquiryQuestion;
import ru.otus.homework03.domain.model.User;

import java.util.List;

public interface CommunicationService {

    User getUserDataFromUser();

    void getAnswersForAllQuestionsFromUser(List<EnquiryQuestion> enquiryQuestionList);

    void sendEnquiryResultToUser(User user, List<EnquiryQuestion> enquiryQuestionList);
}
