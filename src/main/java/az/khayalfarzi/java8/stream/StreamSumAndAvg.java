package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.stream.Collectors;

public class StreamSumAndAvg {

    static double getTotalSalary() {
        return PersonRepo.getAll()
                .stream()
                .collect(Collectors.summingDouble(Person::getSalary));
    }

    static double orGetTotalSalary() {
        return PersonRepo.getAll()
                .stream()
                .mapToDouble(Person::getSalary)
                .sum();
    }

    static double getAverageAge() {
        return PersonRepo.getAll()
                .stream()
                .collect(Collectors.averagingInt(Person::getAge));
    }

    static double orGetAverageAge() {
        return PersonRepo.getAll()
                .stream()
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
    }

    public static void main(String[] args) {

        System.out.println("Summing with summing: " + getTotalSalary());

        System.out.println("Summing with map: " + orGetTotalSalary());

        System.out.println("Averaging with averaging : " + getAverageAge());

        System.out.println("Averaging with map: " + orGetAverageAge());
    }
}