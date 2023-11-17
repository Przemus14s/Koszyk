package pl.gornik.model;

public class Disc extends Product {
    private String performer;

    public Disc(String title, int quantity, double price, String performer) {
        super(title, quantity, price);
        this.performer = performer;
    }

    @Override
    public void displayProduct() {
        super.displayProduct();
        System.out.print("Wykonawca to: " + performer +"\n");
    }
}
