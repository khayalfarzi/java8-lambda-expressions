package az.khayalfarzi.java8.biConsumer;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {

        BiConsumer<Integer, Integer> addConsumer = (a, b) -> System.out.println("Add: " + (a + b));
        BiConsumer<Integer, Integer> subConsumer = (a, b) -> System.out.println("Sub: " + (a - b));
        BiConsumer<Integer, Integer> mulConsumer = (a, b) -> System.out.println("Mul: " + (a * b));

        addConsumer.accept(8, 9);
        subConsumer.accept(8, 9);
        mulConsumer.accept(8, 9);
        // OR
        addConsumer.andThen(subConsumer).andThen(mulConsumer).accept(8, 9);
    }
}
