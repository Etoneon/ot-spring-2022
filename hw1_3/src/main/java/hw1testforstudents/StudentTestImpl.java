package hw1testforstudents;

import hw1testforstudents.domain.Person;
import hw1testforstudents.service.PersonService;
import hw1testforstudents.test.Test;


public class StudentTestImpl implements StudentTest {

    private final PersonService studentService;
    private final Test test;

    public StudentTestImpl(PersonService studentService,Test test){
        this.studentService = studentService;
        this.test = test;
          }

    @Override
    public void start() {
        System.out.println("start test");
        Person student = studentService.enterPersonByName();
        test.performTest(student);

    }

}
