package az.khayalfarzi.java8.paralelProgramming;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SequentialVsParalel {

    static void printStream(Stream<String> stream) {

        stream.forEach(
                s -> {
                    System.out.println(LocalTime.now() + " value :" + s + " thread :" + Thread.currentThread().getName());

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    static int sumMethodUsingSequential() {
        return IntStream.rangeClosed(0, 10000000).sum();
    }

    static int sumMethodUsingParallel() {
        return IntStream.rangeClosed(0, 10000000).parallel().sum();
    }

    static long checkPerformance(Supplier<Integer> sum, int numOfTime) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < numOfTime; i++) {
            sum.get();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) {

        String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("=====> Sequential process <=====");
        printStream(Arrays.stream(arr).sequential());
        System.out.println("=====> Parallel process <=====");
        printStream(Arrays.stream(arr).parallel());

        System.out.println("Sum from Sequential : "
                + checkPerformance(SequentialVsParalel::sumMethodUsingSequential, 25));
        System.out.println("Sum from Parallel : "
                + checkPerformance(SequentialVsParalel::sumMethodUsingParallel, 25));
    }
}
