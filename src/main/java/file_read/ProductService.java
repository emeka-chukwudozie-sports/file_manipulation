package file_read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductService {

    private List<Product> productList = new ArrayList<>();
    private Set<Product> uniqueProducts = new HashSet<>();



    BufferedReader reader;

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public  String createProducts(String file, List<Product> products) throws IOException {
            try {
                reader = new BufferedReader(new FileReader(file));
                String data = "";
                while ((data = reader.readLine()) != null){
                    if (data.startsWith("Order")){
                        continue;
                    }
                    String [] output =  data.split(",");
                    var productName = output[3].trim();
                    int productQuantity = Integer.parseInt(output[4].trim());
                    double productPrice = Double.parseDouble(output[5].trim());
                    Product product = new Product(productName, productQuantity, productPrice);
                    System.out.println(product);
                    products.add(product);
                }

            } catch (IOException e) {
                System.err.println("File Not Read");
                e.printStackTrace();
            } finally {
                reader.close();
            }
        return "Products successfully created";
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Set<Product> getUniqueProducts() {
        return uniqueProducts;
    }

    public void setUniqueProducts(Set<Product> uniqueProducts) {
        this.uniqueProducts = uniqueProducts;
    }

    public List<Product> createUniqueProducts(){
        final Map<String, Integer> stringIntegerMap = this.getProductList().stream()
                .collect(Collectors.groupingBy(Product::getProductName, Collectors.summingInt(Product::getProductQuantity)));
        final Stream<Product> productStream = stringIntegerMap.entrySet().stream().map(
                entry -> new Product(entry.getKey(), entry.getValue(), sumPrice(entry.getKey()))
        );
        return productStream.toList();
    }

    private double sumPrice(final String key) {
        return productList.stream().filter(product -> product.getProductName().equals(key))
                .mapToDouble(product1 -> product1.getProductPrice() * product1.getProductQuantity()).sum();
    }
}
