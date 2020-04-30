package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamFactoryMethod {

    static UnaryOperator<Integer> unaryOperator = integer -> integer * 2;

    public static void main(String[] args) {

        Stream.iterate(2, unaryOperator)
                .limit(5)
                .forEach(System.out::println);

        Stream.generate(new Random()::nextInt)
                .limit(15)
                .forEach(System.out::println);

        Stream.of(PersonRepo.getAll())
                .forEach(System.out::println);
    }
}