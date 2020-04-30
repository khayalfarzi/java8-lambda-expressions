package az.khayalfarzi.java8.stream;

import az.khayalfarzi.java8.locale.repository.PersonRepo;

public class StreamFindAnyAndFindFirst {

    public static void main(String[] args) {

        System.out.println(
                PersonRepo
                .getAll()
                .stream()
                .findAny()
                .get()
        );

        System.out.println(
                PersonRepo
                        .getAll()
                        .stream()
                        .findFirst()
        );

    }
}
