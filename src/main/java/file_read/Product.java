package file_read;

import java.util.Objects;

public class Product implements Comparable<Product>{

    private String productName;
    private int productQuantity;
    private double productPrice;

    public Product(String productName, int productQuantity, double productPrice) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public Product(String productName){
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public int compareTo(Product o) {
        if(o.getProductName().equals(this.getProductName()) ){
            return 0;
        } else {
            return o.getProductName().compareTo(this.productName);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }

    @Override
    public String toString() {
        return "\nProduct: {" +
                "\n'productName': '" + productName + "'," +
                "\n'productQuantity': " + productQuantity + "," +
                "\n'productPrice': " + productPrice +
                "\n}";
    }
}
