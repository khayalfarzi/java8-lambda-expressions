package az.khayalfarzi.java8.supplier;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    static Supplier<Person> personSupplier = PersonRepo::getPerson;

    static Supplier<List<Person>> listSupplier = PersonRepo::getAll;

    public static void main(String[] args) {
        System.out.println(personSupplier.get());
        System.out.println(listSupplier.get());
    }
}
