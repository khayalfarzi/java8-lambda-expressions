package az.khayalfarzi.java8.optional;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.Optional;

public class SimpleOptional {

    public static void main(String[] args) {

        String s = "Khayal";
        System.out.println(getName(s));

        Optional<String> name = Optional.ofNullable(getName(s));

        System.out.println(name);

        System.out.println(name.isPresent() ? name.get() : "No data founded");

        System.out.println(name.orElse("No data founded"));

        System.out.println(
                getPersonName(PersonRepo.getPerson()));

        System.out.println(
                getPersonNameWithOptional(PersonRepo.getPersonWithOptional()));
    }

    static String getName(String name) {
        return name;
    }

    static String getPersonName(Person person) {
        if (person != null) {
            return person.getName();
        }
        return null;
    }

    static Optional<String> getPersonNameWithOptional(Optional<Person> person) {

        if (person.isPresent()) {
            return Optional.of(person.map(Person::getName).get());
        } else
            return Optional.empty();
    }
}
