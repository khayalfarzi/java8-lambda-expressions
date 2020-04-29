package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.Comparator;

public class StreamCustomSort {

    public static void main(String[] args) {

        System.out.println("Sort by name");
        PersonRepo.getAll()
                .stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

        System.out.println("Sort by age");
        PersonRepo.getAll()
                .stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);

        System.out.println("Reverse sort by name");
        PersonRepo.getAll()
                .stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .forEach(System.out::println);

    }
}
