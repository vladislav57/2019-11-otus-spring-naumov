package ru.otus.homework03.application.datasource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework03.domain.application.CommunicationService;
import ru.otus.homework03.domain.model.EnquiryQuestion;
import ru.otus.homework03.domain.model.User;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
public class ConsoleCommunicationServiceImpl implements CommunicationService {

    private final Scanner scanner = new Scanner(System.in);
    private final MessageSource messageSource;
    private final Locale locale;

    public ConsoleCommunicationServiceImpl(final MessageSource messageSource,
                                           final Locale locale) {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    @Override
    public User getUserDataFromUser() {
        System.out.println(
                messageSource.getMessage("user.input.name.request", null, locale)
        );
        final String name = scanner.nextLine();
        System.out.println(
                messageSource.getMessage("user.input.surname.request", null, locale)
        );
        final String surname = scanner.nextLine();
        return new User(name, surname);
    }

    @Override
    public void sendEnquiryResultToUser(final User user,
                                        final List<EnquiryQuestion> enquiryQuestionList) {
        printResultHeader(user);
        for (EnquiryQuestion question : enquiryQuestionList) {
            printResult(question);
        }
    }

    @Override
    public void getAnswersForAllQuestionsFromUser(final List<EnquiryQuestion> enquiryQuestionList) {
        System.out.println(
                messageSource.getMessage("test.start.message", null, locale)
        );
        for (EnquiryQuestion question : enquiryQuestionList) {
            getAnswerForQuestionFromUser(question);
        }
        System.out.println(
                messageSource.getMessage("test.finish.message", null, locale)
        );
    }

    private void getAnswerForQuestionFromUser(final EnquiryQuestion question) {
        System.out.println(question.getQuestionText());
        System.out.println(question.getAnswersText());
        System.out.println(
                messageSource.getMessage("answer.input.request", null, locale)
        );
        question.checkAnswer(scanner.nextLine());
    }

    private void printResultHeader(final User user) {
        System.out.println(
                messageSource.getMessage("result.heading.message",
                        new String[] {user.getName(), user.getSurname()},
                        locale)
        );
    }

    private void printResult(final EnquiryQuestion question) {
        if (question.isUserAnswerCorrect()) {
            System.out.println(
                    messageSource.getMessage("correct.answer.message",
                            new String[] {question.getQuestionText()},
                            locale)
            );
        } else {
            System.out.println(
                    messageSource.getMessage("wrong.answer.message",
                            new String[] {question.getQuestionText()},
                            locale)
            );
        }
    }
}
