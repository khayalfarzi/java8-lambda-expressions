package az.khayalfarzi.java8.biFunction;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class Application {

    static List<Person> getAll = PersonRepo.getAll();

    static BiPredicate<Integer, String> bp = (age, gender) -> age > 30 && gender.equals("Male");

    static BiFunction<List<Person>, BiPredicate<Integer, String>, Map<String, Double>> bf =
            (list, biPredicate) -> {
                Map<String, Double> map = new HashMap<>();
                list.forEach(person -> {
                    if (bp.test(person.getAge(), person.getGender())) {
                        map.put(person.getName(), person.getSalary());
                    }
                });
                return map;
            };

    public void run() {
        System.out.println(bf.apply(getAll, bp));
    }
}