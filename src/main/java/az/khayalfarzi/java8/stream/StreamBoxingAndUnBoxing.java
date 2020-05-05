package az.khayalfarzi.java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamBoxingAndUnBoxing {

    static List<Integer> boxingMethod() {
        return IntStream.rangeClosed(1, 50)    //primitive int type
                .boxed()                       //converting to wrapper Integer
                .collect(Collectors.toList()); // collect to List
    }

    static int unBoxingMethod(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue) //converting to primitive type
                .sum();                      //do sum operation
    }

    public static void main(String[] args) {

        boxingMethod().forEach(System.out::println);

        System.out.println(
                unBoxingMethod(
                        boxingMethod()
                ));
    }
}
