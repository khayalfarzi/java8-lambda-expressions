package az.khayalfarzi.java8.biConsumer.repository;

import az.khayalfarzi.java8.biConsumer.entity.Person;

import java.util.Arrays;
import java.util.List;

public class PersonRepo {

    public static List<Person> getAll() {
        return Arrays.asList(
                Person.builder().id(1).name("aaa").age(11).gender("Male").salary(111.11).hobbies(Arrays.asList("a", "b", "c", "d")).build(),
                Person.builder().id(2).name("bbb").age(22).gender("Female").salary(222.22).hobbies(Arrays.asList("d", "b", "c", "d")).build(),
                Person.builder().id(3).name("ccc").age(33).gender("Male").salary(333.33).hobbies(Arrays.asList("c", "b", "c", "d")).build(),
                Person.builder().id(4).name("ddd").age(44).gender("Male").salary(444.44).hobbies(Arrays.asList("q", "b", "c", "d")).build(),
                Person.builder().id(5).name("eee").age(55).gender("Male").salary(555.55).hobbies(Arrays.asList("w", "b", "c", "d")).build(),
                Person.builder().id(6).name("fff").age(66).gender("Female").salary(666.66).hobbies(Arrays.asList("l", "b", "c", "d")).build(),
                Person.builder().id(7).name("kkk").age(77).gender("Female").salary(777.77).hobbies(Arrays.asList("a", "h", "c", "d")).build(),
                Person.builder().id(8).name("lll").age(88).gender("Male").salary(888.88).hobbies(Arrays.asList("k", "t", "c", "d")).build()
        );
    }

    public static Person getPerson() {
        return Person.builder().id(1).name("aaa").age(11).gender("Male").salary(111.11).build();
    }
}
