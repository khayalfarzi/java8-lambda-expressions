package az.khayalfarzi.java8.predicate;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {

    static Predicate<Person> p1 = person -> person.getAge() > 50;

    static Predicate<Person> p2 = person -> person.getGender().equals("Male");

    static List<Person> getAll = PersonRepo.getAll();

    static BiConsumer<String, List<String>> hobbiesConsumer = (string, strings) -> System.out.println(string + " : " + strings);

    static Consumer<Person> personConsumer = person -> {
        if (p1.and(p2).test(person)) {
            hobbiesConsumer.accept(person.getName(), person.getHobbies());
        }
    };

    public void run() {
        /* 1 */
        getAll.stream().filter(p1).collect(Collectors.toList());
        /* 2 */
        getAll.forEach(per -> {
            if (p1.or(p2).test(per)) System.out.println(per);
        });
        /* 3 */
        getAll.forEach(per -> {
            if (p1.and(p2).test(per)) System.out.println(per);
        });
        /* 4 */
        getAll.forEach(person -> {
            personConsumer.accept(person);
        });
    }
}
