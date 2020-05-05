package az.khayalfarzi.java8.paralelProgramming;

import java.util.stream.IntStream;

public class ParallelWhenNotToUseCase2 {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        IntStream
                .rangeClosed(0, 1000)
                .forEach(calculator::calculate);
        System.out.println("Sequential sum : " + calculator.getTotal());

        IntStream
                .rangeClosed(0, 1000)
                .parallel()
                .forEach(calculator::calculate);
        System.out.println("Parallel sum : " + calculator.getTotal());
    }
}

class Calculator {

    private int total;

    public int getTotal() {
        return total;
    }

    protected int calculate(int in) {
        return total += in;
    }
}