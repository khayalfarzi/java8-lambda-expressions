package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class StreamGroupingBy {

    protected static void groupByGender() {

        Map<String, List<Person>> grouping = PersonRepo.getAll()
                .stream()
                .collect(Collectors.groupingBy(Person::getGender));

        grouping.entrySet()
                .forEach(stringListEntry ->
                        System.out.println(
                                "key - " + stringListEntry.getKey() +
                                        " \nvalue - " + stringListEntry.getValue()));
    }

    protected static void groupByAge() {
        Map<String, List<Person>> map = PersonRepo.getAll()
                .stream()
                .collect(Collectors.groupingBy(
                        person -> person.getAge() > 20 ? "Old Person" : "Young Person"
                ));

        Stream.of(map).forEach(System.out::println);
    }

    protected static void twoLevelGrouping() {

        Map<String, Map<String, List<Person>>> map =
                PersonRepo.getAll()
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getGender,
                                        groupingBy(
                                                person -> person.getAge() > 30 ? "Old person" : "Young person")));

        Stream.of(map).forEach(System.out::println);
    }

    protected static void threeLevelGrouping() {

        Map<String,
                Map<Integer,
                        Map<String,
                                List<Person>>>> map =
                PersonRepo.getAll()
                        .stream()
                        .collect(Collectors.groupingBy(
                                Person::getGender,
                                groupingBy(Person::getAge,
                                        groupingBy(Person::getName))));

        Stream.of(map).forEach(System.out::println);
    }

    public static void main(String[] args) {

        groupByGender();

        groupByAge();

        twoLevelGrouping();

        threeLevelGrouping();
    }
}
