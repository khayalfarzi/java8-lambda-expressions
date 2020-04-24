package az.khayalfarzi.java8.consumer.entity;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Integer id;

    private String name;

    private int age;

    private String gender;

    private double salary;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                '}';
    }
}