package az.khayalfarzi.java8.function;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Application {

    static List<Person> getAll = PersonRepo.getAll();

    static BiPredicate<Integer, String> p1 = (age, gender) -> age > 50 && gender.equals("Male");

    static Function<List<Person>, Map<String, Double>> f1 = people -> {
        Map<String, Double> map = new HashMap<>();
        people.forEach(person -> {
            map.put(person.getName(), person.getSalary());
        });
        return map;
    };

    static Function<List<Person>, Map<String, Double>> f2 = people -> {
        Map<String, Double> map = new HashMap<>();
        people.forEach(person -> {
            if (p1.test(person.getAge(), person.getGender())) {
                map.put(person.getName(), person.getSalary());
            }
        });
        return map;
    };

    public void run() {
        System.out.println(f1.apply(getAll));
        System.out.println(f2.apply(getAll));
    }
}
