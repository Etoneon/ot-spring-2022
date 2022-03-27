package hw1testforstudents.service;

import hw1testforstudents.dao.PersonDao;
import hw1testforstudents.dao.PersonDaoImpl;
import hw1testforstudents.domain.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void shouldCorrectlyEnterPersonByName() {
        PersonDao testDao = new PersonDaoImpl();
        PersonService service = new PersonServiceImpl(testDao);
        String data = "Hello\nWorld\n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));

            Person testStudent = service.enterPersonByName();
            System.out.println (testStudent);

            assertEquals("Hello", testStudent.getName());
            assertEquals("World", testStudent.getSurname());

         System.setIn(stdin);
    }
}