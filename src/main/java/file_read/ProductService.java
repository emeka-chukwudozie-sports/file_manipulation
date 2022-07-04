package file_read;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductService {

    private List<Product> productList = new ArrayList<>();
    private Set<Product> uniqueProducts = new HashSet<>();



    BufferedReader reader;

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public  String createProducts(String file, List<Product> products) throws IOException {
//        this.productList = products;
            try {
                reader = new BufferedReader(new FileReader(file));
                String data = "";
                while (reader.readLine() != null){
                    String value = reader.readLine();
                    String [] output =  value.split(",");
                    var productName = output[3].trim();
                    int productQuantity = Integer.parseInt(output[4].trim());
                    double productPrice = Double.parseDouble(output[5].trim());
                    Product product = new Product(productName, productQuantity, productPrice);
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

    public Set<Product> createUniqueProducts(){
//        this.getProductList().stream().collect()
        return null;
    }
}
