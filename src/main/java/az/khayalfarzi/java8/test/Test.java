package az.khayalfarzi.java8.test;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        getProductByNameKey("odu ")
                .forEach(System.out::println);
    }

    public static List<Product> getProductByBarcode(String barcode) {
        List<Product> productList = new ArrayList<>();
        map().forEach(
                (category, products) -> productList.addAll(products));
        return productList.stream()
                .filter(product -> product.getReference().equals(barcode))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Product> getProductByNameKey(String key) {
        List<Product> productList = new ArrayList<>();
        map().forEach(
                (category, products) -> productList.addAll(products));
        return productList.stream()
                .filter(product -> product
                        .getName()
                        .contains(key))
                .distinct()
                .collect(Collectors.toList());
    }

    private static Map<String, List<Product>> map() {
        Map<String, List<Product>> get = new HashMap<>();
        get.put("1", getAllFirst());
        get.put("2", getAllSecond());
        return get;
    }

    private static List<Product> getAllFirst() {
        return Arrays.asList(
                Product.builder()
                        .reference("11111")
                        .build(),
                Product.builder()
                        .reference("22222")
                        .build(),
                Product.builder()
                        .reference("qisa etek mavi renkli")
                        .build(),
                Product.builder()
                        .reference("2222244444")
                        .build(),
                Product.builder()
                        .reference("55555")
                        .build(),
                Product.builder()
                        .reference("6662222266")
                        .build(),
                Product.builder()
                        .reference("qirmizi shalvar")
                        .build(),
                Product.builder()
                        .reference("mavi yakali koynek")
                        .build(),
                Product.builder()
                        .reference("99999")
                        .build()
        );
    }

    private static List<Product> getAllSecond() {
        return Arrays.asList(
                Product.builder()
                        .reference("1111122")
                        .build(),
                Product.builder()
                        .reference("2222233 22 sdffds")
                        .build(),
                Product.builder()
                        .reference("333334422222")
                        .build(),
                Product.builder()
                        .reference("4444455")
                        .build(),
                Product.builder()
                        .reference("sari mavili")
                        .build(),
                Product.builder()
                        .reference("yaz getsin esas odu qirmizi shalvar sozu olsun")
                        .build(),
                Product.builder()
                        .reference("7777788")
                        .build(),
                Product.builder()
                        .reference("8888899")
                        .build(),
                Product.builder()
                        .reference("9999911")
                        .build()
        );
    }
}
