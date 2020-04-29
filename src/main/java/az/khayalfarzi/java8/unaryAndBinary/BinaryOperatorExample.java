package az.khayalfarzi.java8.unaryAndBinary;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    //first way
    static BinaryOperator<Integer> binaryOperator = BinaryOperator
            .minBy((a, b) -> a > b ? 1 : (a.equals(b)) ? 0 : -1);

    //second way
    static Comparator<Integer> comparator = Comparator.naturalOrder();
    static BinaryOperator<Integer> binaryOperator1 = BinaryOperator.minBy(comparator);

    public static void main(String[] args) {
        System.out.println(binaryOperator.apply(4, 7));
        System.out.println(binaryOperator1.apply(4, 7));
    }
}