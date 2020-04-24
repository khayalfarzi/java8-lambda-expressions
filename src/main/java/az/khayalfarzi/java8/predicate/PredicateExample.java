package az.khayalfarzi.java8.predicate;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        Predicate<Integer> negative = integer -> integer < 0;
        Predicate<Integer> positive = integer -> integer > 0;
        Predicate<Integer> zero = integer -> integer == 0;

        boolean result = negative.and(positive).and(zero).test(0);
        System.out.println(result);
    }
}
