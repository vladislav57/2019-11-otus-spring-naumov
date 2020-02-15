package ru.otus.homework02.domain.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnquiryQuestion {

    private final String text;
    private final Map<String, Answer> answerMap;
    private boolean isUserAnswerCorrect = false;

    public EnquiryQuestion(final String text, final List<Answer> answerList) {
        this.text = text;
        this.answerMap = createAnswerMapFromList(answerList);
    }

    private Map<String, Answer> createAnswerMapFromList(final List<Answer> answerList) {
        Map<String, Answer> answerMap = new HashMap<>();
        for (int i = 0; i < answerList.size(); i++) {
            answerMap.put(String.valueOf(i + 1), answerList.get(i));
        }
        return answerMap;
    }

    public String getQuestionText() {
        return text;
    }

    public String getAnswersText() {
        return answerMap.entrySet().stream()
                .map(e -> e.getKey() + "." + e.getValue().getText())
                .collect(Collectors.joining("\t"));
    }

    public boolean isUserAnswerCorrect() {
        return this.isUserAnswerCorrect;
    }

    public void checkAnswer(final String option) {
        if (answerMap.containsKey(option)) {
            this.isUserAnswerCorrect = answerMap
                    .get(option)
                    .isCorrect();
        }
    }
}
