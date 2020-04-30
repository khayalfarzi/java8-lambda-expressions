package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.Collection;
import java.util.Comparator;

public class StreamMapFilterReduce {

    public static void main(String[] args) {

        System.out.println(
                PersonRepo
                        .getAll()
                        .stream()
                        .filter(person -> person.getGender().equals("Male"))
                        .filter(person -> person.getSalary() > 50.56)
                        .map(Person::getAge)
                        .reduce(0, Integer::sum)
        );

        System.out.println(
                PersonRepo
                        .getAll()
                        .stream()
                        .filter(person -> person.getGender().equals("Male"))
                        .filter(person -> person.getSalary() > 50.56)
                        .map(Person::getHobbies)
                        .flatMap(Collection::stream)
                        .distinct()
                        .sorted(Comparator.comparing(String::length))
                        .peek(System.out::println)
                        .count()
        );
    }
}
