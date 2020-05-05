package az.khayalfarzi.java8.paralelProgramming;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelWhenNotToUseCase {

    static int sumSequential(List<Integer> list) {
        long start = System.currentTimeMillis();
        int total = list.stream()
                .reduce(0, Integer::sum);
        long end = System.currentTimeMillis();
        System.out.println("Sequential process : " + (end - start));
        return total;
    }

    public static void main(String[] args) {

        List<Integer> list =
                IntStream
                        .rangeClosed(0, 10000)
                        .boxed()
                        .collect(Collectors.toList());

        sumSequential(list);

        sumParallel(list);
    }

    static int sumParallel(List<Integer> list) {
        long start = System.currentTimeMillis();
        int total = list.parallelStream()
                .reduce(0, Integer::sum);
        long end = System.currentTimeMillis();
        System.out.println("Parallel process : " + (end - start));
        return total;
    }
}