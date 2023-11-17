package pl.gornik.model;

public class Product {
    private String title;
    private int quantity;
    private double price;

    public Product(String title, int quantity, double price) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
    public Product(Product product){
        this(product.title, product.quantity, product.price);
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayProduct(){
        System.out.print("Nazwa " + title + " ,ilosc produktu " + quantity + " ,cena " + price + "| ");
    }
    public double countPrice(){
        return quantity * price;
    }
}
