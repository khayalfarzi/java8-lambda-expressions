package az.khayalfarzi.java8.biFunction;

import java.util.function.BiFunction;

public class BiFunctionExample {

    static BiFunction<Integer, Integer, Integer> f1 = Integer::sum;

    static BiFunction<Integer, Integer, Integer> f2 = Integer::max;

    public static void main(String[] args) {
        System.out.println("Result 1:"+f1.apply(5,7));
        System.out.println("Result 2:"+f2.apply(6,5));
    }
}
