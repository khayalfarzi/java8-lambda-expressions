package az.khayalfarzi.java8.optional;

import az.khayalfarzi.java8.locale.entity.Person;
import az.khayalfarzi.java8.locale.repository.PersonRepo;

public class OptionalMethods {

    public static void main(String[] args) {

//        Optional<String> of = Optional.of("Java8");
//        System.out.println(of.isPresent() ? of.get() : Optional.empty());
//
//        Optional<String> ofNullable = Optional.ofNullable("Java8");
//        System.out.println(ofNullable.isPresent() ? of.get() : Optional.empty());
//
//        System.out.println(Optional.empty());

        orElse();

        orElseGet();

        orElseThrow();
    }

    static void orElse() {
        System.out.println(
                PersonRepo.getPersonWithOptional()
                        .map(Person::getName)
                        .orElse("Data not founded")
        );
    }

    static void orElseGet() {
        System.out.println(
                PersonRepo.getPersonWithOptional()
                        .map(Person::getName)
                        .orElseGet(() -> {
                            //initiate any script here
                            //to send notification email
                            return "Data not founded";
                        }));
    }

    static void orElseThrow() {
        System.out.println(
                PersonRepo.getPersonWithOptional()
                        .map(Person::getName)
                        .orElseThrow(() -> new RuntimeException("No data founded")));
    }
}