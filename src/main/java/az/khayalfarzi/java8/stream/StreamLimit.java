package az.khayalfarzi.java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamLimit {

    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Kiwi", "Pineapple");

        fruits.stream()
                .limit(3)
                .forEach(System.out::println);

        List<Integer> integers = Arrays.asList(1, 5, 9, 7, 6, 4, 3, 5, 2);

        //[1,5]
        integers.stream()
                .limit(2)
                .forEach(System.out::print);

        //[4,3,5,2]
        integers.stream()
                .skip(5)
                .forEach(System.out::print);

        //[5,9,7,6,4,3,5]
        integers.stream()
                .limit(8)
                .skip(1)
                .forEach(System.out::print);

        System.out.println("Limit operation : " +
                integers.stream()
                        .limit(2)
                        .reduce(Integer::sum)
        );

        System.out.println("Skip operation : " +
                integers.stream()
                        .skip(8)
                        .reduce(Integer::sum)
        );

        System.out.println("Both of two operation : " +
                integers.stream()
                        .limit(8)
                        .skip(2)
                        .reduce(Integer::sum)
        );
    }
}
