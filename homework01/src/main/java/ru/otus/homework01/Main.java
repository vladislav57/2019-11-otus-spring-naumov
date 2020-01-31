package ru.otus.homework01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework01.service.EnquiryService;

public class Main {

    public static void main(final String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        final EnquiryService enquiryService = context.getBean(EnquiryService.class);
        enquiryService.performEnquiryWithAllQuestions();
    }
}
