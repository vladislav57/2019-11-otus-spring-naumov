package ru.otus.homework02.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.homework02.domain.application.CommunicationService;
import ru.otus.homework02.domain.application.EnquiryService;
import ru.otus.homework02.domain.application.EnquiryServiceImpl;
import ru.otus.homework02.domain.application.InitQuestionsService;

@Configuration
public class DatasourceConfig {

    @Bean
    public EnquiryService enquiryService(final CommunicationService communicationService,
                                         final InitQuestionsService questionsService) {
        return new EnquiryServiceImpl(communicationService, questionsService);
    }
}
