package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1, 3, 6, 2, 7, 9, 6);
        integerStream.forEach(System.out::println);

        Predicate<Person> personPredicate = person -> person.getGender().equals("Female") && person.getAge() > 20;
        Map<String, List<String>> map =
                PersonRepo
                        .getAll()
                        .stream()
                        .filter(personPredicate)
                        .collect(Collectors.toMap(Person::getName, Person::getHobbies));
        System.out.println(map);

        List<String> personNames =
                PersonRepo
                        .getAll()
                        .stream()
                        .map(Person::getName)
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println(personNames);

        List<String> personHobbies =
                PersonRepo
                        .getAll()
                        .stream()
                        .map(Person::getHobbies)
                        .flatMap(Collection::stream)
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println(personHobbies);
    }
}
