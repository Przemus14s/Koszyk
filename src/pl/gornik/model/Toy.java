package pl.gornik.model;

public class Toy extends Product {
    private int minAge;

    public Toy(String title, int quantity, double price, int minAge) {
        super(title, quantity, price);
        this.minAge = minAge;
    }

    @Override
    public void displayProduct() {
        super.displayProduct();
        System.out.print("Minimalny wiek to: " + minAge + "\n");
    }
}
