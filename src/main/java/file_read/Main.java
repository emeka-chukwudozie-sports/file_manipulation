package file_read;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        String file = "src/main/resources/SampleData.csv";
        List<Product> productList = new ArrayList<>();
        try {
            productService.setProductList(productList);
            System.out.println("*********List of Products*********");
            printProductList(productService.getProductList());
            System.out.println();
            System.out.println(productService.createProducts(file, productList));
//            productService.getProductList().forEach(System.out::println);
            System.out.println("\n==========================================================");
            System.out.println("*********List as Total Unique Products*********");
            printProductList(productService.createUniqueProducts());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void printProductList(List<Product> productList){
        productList.forEach(System.out::println);
    }

}
