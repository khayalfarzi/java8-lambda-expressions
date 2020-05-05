package az.khayalfarzi.java8.locale.repository;

import az.khayalfarzi.java8.locale.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonRepo {

    public static List<Person> getAll() {
        return Arrays.asList(
                Person.builder().id(1).name("Jim").age(11).gender("Male").salary(212.11).hobbies(Arrays.asList("Football", "Swimming", "Chess", "Tennis")).build(),
                Person.builder().id(2).name("John").age(22).gender("Female").salary(1221.22).hobbies(Arrays.asList("Volleyball", "Football", "Tennis", "Bowling")).build(),
                Person.builder().id(3).name("Max").age(33).gender("Male").salary(664.33).hobbies(Arrays.asList("Football", "Tennis", "Volleyball", "Swimming")).build(),
                Person.builder().id(4).name("Alan").age(44).gender("Male").salary(444.44).hobbies(Arrays.asList("Bowling", "Tennis", "Football", "Fishing")).build(),
                Person.builder().id(5).name("Adam").age(55).gender("Male").salary(999.55).hobbies(Arrays.asList("Fishing", "Bowling", "Tennis", "Chess")).build(),
                Person.builder().id(6).name("Alexei").age(66).gender("Female").salary(666.66).hobbies(Arrays.asList("Football", "Tennis", "Fishing", "Swimming")).build(),
                Person.builder().id(7).name("Sun").age(77).gender("Female").salary(777.77).hobbies(Arrays.asList("Volleyball", "Bowling", "Football", "Chess")).build(),
                Person.builder().id(8).name("Daniel").age(88).gender("Male").salary(888.88).hobbies(Arrays.asList("Fishing", "Swimming", "Volleyball", "Tennis")).build(),
                Person.builder().id(9).name("Angel").age(88).gender("Female").salary(888.88).hobbies(Arrays.asList("Fishing", "Swimming", "Volleyball", "Tennis")).build()
        );
    }

    public static Person getPerson() {
        return Person.builder().id(1).name("Jim").age(11).gender("Male").salary(111.11).build();
    }

    public static Optional<Person> getPersonWithOptional() {
        return Optional.of(getPerson());
    }
}
