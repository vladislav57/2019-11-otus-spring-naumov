package ru.otus.homework02.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.homework02.domain.application.EnquiryService;

@ComponentScan
public class SpringApp {

    public static void main(final String[] args) {
        final AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringApp.class);
        final EnquiryService enquiryService = context.getBean(EnquiryService.class);
        enquiryService.performEnquiryWithAllQuestions();
    }
}
