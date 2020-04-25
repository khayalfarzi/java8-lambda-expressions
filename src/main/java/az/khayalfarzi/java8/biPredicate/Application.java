package az.khayalfarzi.java8.biPredicate;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class Application {

    static BiPredicate<Integer, String> p3 = (age, gender) -> age > 50 && gender.equals("Male");

    static List<Person> getAll = PersonRepo.getAll();

    static BiConsumer<String, List<String>> hobbiesConsumer = (string, strings) -> System.out.println(string + " : " + strings);

    public void run() {

        getAll.forEach(person -> {
            if (p3.test(person.getAge(), person.getGender())) {
                hobbiesConsumer.accept(person.getName(), person.getHobbies());
            }
        });
    }
}
