package az.khayalfarzi.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStream {

    static int calculateSum(List<Integer> list) {
        return list.stream()
                .reduce(0, Integer::sum);
    }

    static int calculateSumWithStream(IntStream intStream) {
        return intStream.sum();
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6,7);

        System.out.println(calculateSum(list));

        System.out.println(calculateSumWithStream(IntStream.rangeClosed(1, 7)));
    }
}
