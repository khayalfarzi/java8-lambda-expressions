package az.khayalfarzi.java8.consumer;

import az.khayalfarzi.java8.consumer.entity.Person;
import az.khayalfarzi.java8.consumer.repository.PersonRepo;

import java.util.List;
import java.util.function.Consumer;

public class Application {
    static final Consumer<Person> p1 = System.out::println;

    static final Consumer<Person> p2 = person -> System.out.println(person.getName());

    static final Consumer<Person> p3 = person -> System.out.println(person.getAge());

    static List<Person> personList = PersonRepo.getAll();

    static Person getPerson = PersonRepo.getPerson();

    static void getAllNameAndAge() {
        personList.forEach(p2.andThen(p3));
    }

    static void getAllWithCondition() {
        personList.forEach(person -> {
            if (person.getGender().equals("Male")) {
                p2.andThen(p3).accept(person);
            }
        });
    }

    public void run() {

//        p1.accept(PersonRepo.getPerson());
//        p1.andThen(p2).accept(PersonRepo.getPerson());
//        getAllNameAndAge();
//        getAllWithCondition();
    }
}
