package ru.otus.homework02.domain.application;

import ru.otus.homework02.domain.model.EnquiryQuestion;

import java.util.List;

public interface InitQuestionsService {

    List<EnquiryQuestion> getAllQuestions();
}
