package file_read;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        String file = "/home/emeka/IdeaProjects/Java_Algorithm/FileManipulation/src/main/resources/SampleData.csv";
        List<Product> productList = new ArrayList<>();
        try {
            productService.setProductList(productList);
            System.out.println(productService.createProducts(file, productList));
            productService.getProductList().forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
