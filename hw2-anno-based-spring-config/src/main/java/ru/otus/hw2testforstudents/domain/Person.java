package ru.otus.hw2testforstudents.domain;

import lombok.Getter;
import ru.otus.hw2testforstudents.model.Quiz;

import java.util.List;

@Getter
public class Person {

    private final String name;
    private final String surname;
    private final Quiz quiz;

    public Person (String name, String surname, Quiz quiz){
        this.name = name;
        this.surname = surname;
        this.quiz = quiz;
    }

    public void enterQuizResult (List<String> result ){
        quiz.enterResults(result);
    }

    public int evaluateQuizResult (){
        return quiz.evaluateQuizResult ();
    }

    @Override
    public String toString() {
        return "name+surname = " + this.name+" "+ this.surname;
    }
}
