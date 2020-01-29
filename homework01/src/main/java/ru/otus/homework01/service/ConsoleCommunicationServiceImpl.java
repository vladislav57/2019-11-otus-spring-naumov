package ru.otus.homework01.service;

import ru.otus.homework01.model.EnquiryQuestion;
import ru.otus.homework01.model.User;

import java.util.List;
import java.util.Scanner;

public class ConsoleCommunicationServiceImpl implements CommunicationService {

    private final static String INVITATION_TO_INPUT_ANSWER = "Please, input answer option (number/letter):";
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public User getUserDataFromUser() {
        System.out.println("Please, input your name:");
        final String name = scanner.nextLine();
        System.out.println("Please, input your surname:");
        final String surname = scanner.nextLine();
        return new User(name, surname);
    }

    @Override
    public void sendEnquiryResultToUser(final User user, final List<EnquiryQuestion> enquiryQuestionList) {
        printResultHeader(user);
        for (EnquiryQuestion question : enquiryQuestionList) {
            printResult(question);
        }
    }

    @Override
    public void getAnswersForAllQuestionsFromUser(final List<EnquiryQuestion> enquiryQuestionList) {
        System.out.println("\r\nLet's start the test.\r\n");
        for (EnquiryQuestion question : enquiryQuestionList) {
            getAnswerForQuestionFromUser(question);
        }
        System.out.println("\r\nThe test is finished.\r\n");
    }

    private void getAnswerForQuestionFromUser(final EnquiryQuestion question) {
        System.out.println(question.getQuestionText());
        System.out.println(question.getAnswersText());
        System.out.println(INVITATION_TO_INPUT_ANSWER);
        question.checkAnswer(scanner.nextLine());
    }

    private void printResultHeader(final User user) {
        System.out.println(String.format("%s %s, thank you for passing the test",
                user.getName(), user.getSurname()));
        System.out.println("Your answer / Question");
    }

    private void printResult(final EnquiryQuestion question) {
        if (question.isUserAnswerCorrect()) {
            System.out.println(String.format("correct     / %s", question.getQuestionText()));
        } else {
            System.out.println(String.format("wrong       / %s", question.getQuestionText()));
        }
    }


}
