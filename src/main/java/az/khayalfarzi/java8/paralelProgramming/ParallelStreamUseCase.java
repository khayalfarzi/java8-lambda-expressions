package az.khayalfarzi.java8.paralelProgramming;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamUseCase {

    static List<String> usingSequentialStream() {
        long start = System.currentTimeMillis();
        List<String> hobbies = PersonRepo.getAll()
                .stream()
                .map(Person::getHobbies)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("Sequential process : " + (end - start));
        return hobbies;
    }

    public static void main(String[] args) {

        usingSequentialStream();

        usingParallelStream();
    }

    static List<String> usingParallelStream() {
        long start = System.currentTimeMillis();
        List<String> hobbies = PersonRepo.getAll()
                .parallelStream()
                .map(Person::getHobbies)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("Parallel process : " + (end - start));
        return hobbies;
    }
}
