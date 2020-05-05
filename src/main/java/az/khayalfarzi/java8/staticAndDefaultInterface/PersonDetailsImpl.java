package az.khayalfarzi.java8.staticAndDefaultInterface;

import az.khayalfarzi.java8.locale.entity.Person;

import java.util.List;

public class PersonDetailsImpl implements PersonDetails {

    @Override
    public double getTotalSalary(List<Person> list) {
        return list.stream()
                .mapToDouble(Person::getSalary)
                .sum();
    }
}
