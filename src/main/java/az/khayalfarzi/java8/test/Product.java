package az.khayalfarzi.java8.test;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String name;

    private String price;

    private String color;

    private String reference;

    private List<String> imgs;

    private String details;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", color='" + color + '\'' +
                ", reference='" + reference + '\'' +
                ", imgs='" + imgs + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
