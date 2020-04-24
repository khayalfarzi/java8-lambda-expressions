package az.khayalfarzi.java8.biConsumer;

import az.khayalfarzi.java8.biConsumer.entity.Person;
import az.khayalfarzi.java8.biConsumer.repository.PersonRepo;

import java.util.List;
import java.util.function.BiConsumer;

public class Application {
    static List<Person> personList = PersonRepo.getAll();

    static void getPersonDetails() {
        BiConsumer<String, List<String>> details = (string, strings) -> System.out.println(string + " : " + strings);
        personList.forEach(person -> details.accept(person.getName(), person.getHobbies()));
    }

    public void run() {
        getPersonDetails();
    }
}
