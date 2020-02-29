package ru.otus.homework03.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.homework03.domain.application.EnquiryService;

@SpringBootApplication
public class SpringApp {

    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringApp.class, args);
        final EnquiryService enquiryService = context.getBean(EnquiryService.class);
        enquiryService.performEnquiryWithAllQuestions();
    }

}
