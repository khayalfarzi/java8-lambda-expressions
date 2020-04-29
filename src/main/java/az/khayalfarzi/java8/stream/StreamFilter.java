package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Sun", "Sam", "Alex", "Pietro", "Daniel", "Lido");
        names.stream()
                .filter(name -> name.length() > 3)
                .sorted(Comparator
                        .comparing(String::length)
                        .reversed())
                .forEach(System.out::println);

        PersonRepo.getAll()
                .stream()
                .filter(person -> person.getAge() > 20)
                .filter(person -> person.getGender().equals("Female"))
                .filter(person -> person.getSalary() > 20)
                .sorted(Comparator
                        .comparing(Person::getName)
                        .reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Or we can use one filter and bitwise operations
        PersonRepo.getAll()
                .stream()
                .filter(person -> person.getAge() > 20 &&
                        person.getGender().equals("Female") &&
                        person.getSalary() > 20)
                .sorted(Comparator
                        .comparing(Person::getName)
                        .reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}