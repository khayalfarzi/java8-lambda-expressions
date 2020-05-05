package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJoining {

    static String nameJoining() {
        return PersonRepo.getAll()
                .stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static void main(String[] args) {

        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};

        String join = Stream.of(chars)
                .map(String::new)
                .collect(Collectors.joining(", ","[","]"));
        System.out.println(join);

        System.out.println(nameJoining());
    }
}
