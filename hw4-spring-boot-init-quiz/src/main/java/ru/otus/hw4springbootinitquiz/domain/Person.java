package ru.otus.hw4springbootinitquiz.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.otus.hw4springbootinitquiz.model.Quiz;

@RequiredArgsConstructor
@Getter
public class Person {

    private final String name;
    private final String surname;
    private final Quiz quiz;

    @Override
    public String toString() {
        return "name+surname = " + this.name+" "+ this.surname;
    }
}