package az.khayalfarzi.java8.function;

import java.util.function.Function;

public class FunctionExample {

    static Function<String, String> f1 = String::toUpperCase;

    static Function<String, String> f2 = name -> name.toUpperCase().concat(" java");

    static Function<String, Integer> f3 = String::length;

    public static void main(String[] args) {
        System.out.println("Result 1: " + f1.apply("test"));
        System.out.println("Result 2: " + f2.apply("test"));
        System.out.println("Result 3: " + f1.andThen(f2).apply("test"));
        System.out.println("Result 4: " + f1.compose(f2).apply("test"));

        System.out.println("Result 5:"+f3.apply("test java"));
    }
}
