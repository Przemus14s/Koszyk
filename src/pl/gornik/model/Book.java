package pl.gornik.model;

public class Book extends Product{
    private String author;

    public Book(String title, int quantity, double price, String author) {
        super(title, quantity, price);
        this.author = author;
    }

    @Override
    public void displayProduct() {
        super.displayProduct();
        System.out.print("Autor produktu to: " + author + "\n");
    }
}
