package az.khayalfarzi.java8.staticAndDefaultInterface;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.List;

public class Application {

    public void run() {

        List<Person> personList = PersonRepo.getAll();
        PersonDetailsImpl details = new PersonDetailsImpl();

        System.out.println(
                details.getTotalSalary(personList)
        );

        System.out.println(
                details.getMinAge(personList)
        );

        System.out.println(
                PersonDetails.getAllPersonsWithTheirHobbiesFilterByParameter(personList)
        );
    }
}
