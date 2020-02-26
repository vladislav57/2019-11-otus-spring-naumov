package ru.otus.homework03.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
@ConfigurationProperties(prefix = "app")
public class LocalizationConfig {

    private String language;
    private String country;

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Bean
    public Locale getLocale() {
        return new Locale(language, country);
    }
}
