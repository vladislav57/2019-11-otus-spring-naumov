package ru.otus.homework02.domain.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testCreateUserWithConstructor() {
        final User user = new User("testName", "testSurname");
        final SoftAssertions softly = new SoftAssertions();
        softly.assertThat(user.getName()).isEqualTo("testName");
        softly.assertThat(user.getSurname()).isEqualTo("testSurname");
        softly.assertAll();
    }
}
