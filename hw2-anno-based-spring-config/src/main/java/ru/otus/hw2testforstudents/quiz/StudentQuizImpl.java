package ru.otus.hw2testforstudents.quiz;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw2testforstudents.config.QuizConfig;
import ru.otus.hw2testforstudents.domain.Person;
import ru.otus.hw2testforstudents.service.IOService;
import ru.otus.hw2testforstudents.service.PersonService;
import ru.otus.hw2testforstudents.service.QuizPerformer;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentQuizImpl implements StudentQuiz {

    private final PersonService studentService;
    private final QuizConfig quizConfig;
    private final IOService ioService;
    private final QuizPerformer quizPerformer;

/*
    public StudentQuizImpl(PersonService studentService, QuizConfig quizConfig,
                           IOService ioService,QuizPerformer quizPerformer){
        this.studentService = studentService;
        this.quizConfig = quizConfig;
        this.ioService = ioService;
        this.quizPerformer = quizPerformer;
    }
*/
    @Override
    public void start() {

        System.out.println("start test.\nPass threshold is " + quizConfig.getPassThreshold() + ".");
        Person student = studentService.enterPersonByName();

        List<String> result = quizPerformer.performQuiz(student);
        student.enterQuizResult(result);

        int resultEvaluated = student.evaluateQuizResult();
        String isThresholdPassed = resultEvaluated < quizConfig.getPassThreshold()?
                             "You haven't passed the test. Sorry." : "You've passed the test succesfully. Congratulations!";
        ioService.outputString("Your result is "+ resultEvaluated+".\n" + isThresholdPassed);
    }
/*
    private List<String> performQuiz(Person person){
        ioService.outputString("Hi "+ person.getName() +" "+ person.getSurname()
                                    + ", please answer following questions: ");
        List<String> result = new ArrayList<>();

        for (List list : person.getQuiz().getQuizList()) {
            askQuestionFromList(list);
            result.add(receiveAnswer());
        }
        return result;
    }

    private void askQuestionFromList(List<String> list) {
 //      ioService.outputString(list.get(2));
       for (int i = 2; i < list.size(); i++) {
           ioService.outputString(list.get(i));
            }
        }

    private String receiveAnswer(){
        System.out.println("Please enter your choice: ");
            try {
                Scanner scanner = new Scanner(System.in);
                return scanner.nextLine();
             }catch(Exception ex){
                return "";
            }


        return ioService.readStringWithPromptAndValues("Please enter your choice: ",
                "A","B","C","D","E");

        }
        */

}
