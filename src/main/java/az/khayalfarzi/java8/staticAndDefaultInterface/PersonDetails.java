package az.khayalfarzi.java8.staticAndDefaultInterface;

import az.khayalfarzi.java8.locale.entity.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface PersonDetails {

    static Map<String, List<String>> getAllPersonsWithTheirHobbiesFilterByParameter(List<Person> list) {
        return list
                .stream()
                .filter(
                        person -> person.getAge() > 20
                )
                .filter(person ->
                        person.getSalary() > 200 ||
                                person.getGender().equalsIgnoreCase("Male")
                )
                .collect(
                        Collectors
                                .toMap(Person::getName, Person::getHobbies));
    }

    double getTotalSalary(List<Person> list);

    default int getMinAge(List<Person> list) {
        return list.stream()
                .min(Comparator.comparing(Person::getAge))
                .get().getAge();
    }
}