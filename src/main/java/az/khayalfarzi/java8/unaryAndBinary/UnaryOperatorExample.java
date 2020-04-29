package az.khayalfarzi.java8.unaryAndBinary;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    static UnaryOperator<Integer> unaryOperator = number -> number * 5;

    public static void main(String[] args) {
        System.out.println(unaryOperator.apply(8));
    }
}
