package ru.otus.hw2testforstudents.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw2testforstudents.dao.PersonDao;
import ru.otus.hw2testforstudents.domain.Person;
import ru.otus.hw2testforstudents.model.Quiz;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;
    private final QuizLoader quizLoader;
    private final IOService ioService;


/*
    public PersonServiceImpl(PersonDao dao, QuizLoader quizLoader, IOService ioService) {
        this.dao = dao;
        this.quizLoader = quizLoader;
        this.ioService = ioService;
    }
*/
    @Override
    public Person enterPersonByName () {

 //       try {
 //           Scanner scanner = new Scanner(System.in);
 //           System.out.println("Please enter your name>");
 //           String name = scanner.nextLine();
            String name = ioService.readStringWithPrompt("Please enter your name>");
 //           System.out.println("Please enter your surname>");
 //           String surname = scanner.nextLine();
            String surname = ioService.readStringWithPrompt("Please enter your surname>");
           return new Person(name, surname, new Quiz(quizLoader));
 /*           }
        catch(Exception ex){ex.printStackTrace();
            return null;
        }

  */
    }

    @Override
    public Person getByName(String name, String surname) {
        return dao.findByName(name, surname);
    }

}
