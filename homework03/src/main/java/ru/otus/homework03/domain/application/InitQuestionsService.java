package ru.otus.homework03.domain.application;

import ru.otus.homework03.domain.model.EnquiryQuestion;

import java.util.List;

public interface InitQuestionsService {

    List<EnquiryQuestion> getAllQuestions();
}
