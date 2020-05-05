package az.khayalfarzi.java8.stream;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamFactory {

    public static void main(String[] args) {

        IntStream.rangeClosed(1, 9) //[1,9]
                .forEach(System.out::println);

        IntStream.range(1, 9)      //[1,9)
                .forEach(System.out::println);

        IntStream.range(1, 9)      //[1,9)
                .asDoubleStream()
                .forEach(System.out::println);

        LongStream.rangeClosed(1, 90)
                .forEach(System.out::println);

        LongStream.rangeClosed(1, 90)
                .asDoubleStream()
                .forEach(System.out::println);

        System.out.println(
                IntStream.rangeClosed(1, 90).min());

        System.out.println(
                LongStream.rangeClosed(1, 90).max());

        System.out.println(
                LongStream.rangeClosed(1, 90)
                        .average()
                        .getAsDouble()
        );
    }
}