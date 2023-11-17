package pl.gornik;

import pl.gornik.model.Book;
import pl.gornik.model.Disc;
import pl.gornik.model.Product;
import pl.gornik.model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Koszyk {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        InitializedShop(products);
        List<Product> basket  = new ArrayList<>();

        double shopMoney = 0;
        for (Product element : products){
            shopMoney = shopMoney + element.countPrice();
            element.displayProduct();
        }
        System.out.println("Wartość sklepu: " + (int)shopMoney + "zł");
        Scanner scanner = new Scanner(System.in);
        String name;
        int quantity;
        String choice = "T";
        boolean isFind = false;
        while (choice.equalsIgnoreCase("T") || choice.equalsIgnoreCase("Tak") ||
                choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("Y")) {
            System.out.println("Wybierz produkt do koszyka. Wpisz nazwę.");
            name = scanner.nextLine();
            System.out.println("Wpisz ilość sztuk.");
            quantity = scanner.nextInt();
            scanner.nextLine();

            for (Product product : products) {
                if (product.getTitle().equalsIgnoreCase(name)) {
                    Product prod = new Product(product);
                    if (product.getQuantity() > quantity) {
                        prod.setQuantity(quantity);
                        basket.add(prod);
                        product.setQuantity(product.getQuantity() - quantity);
                        isFind = true;
                    } else if (product.getQuantity() == quantity) {
                        prod.setQuantity(quantity);
                        basket.add(prod);
                        products.remove(product);
                        break;
                    } else {
                        System.out.printf("Nie ma %d %s produktu w sklepie. Do koszyka dodano %d\n", quantity,
                                name, product.getQuantity());
                        basket.add(product);
                        isFind = true;
                        products.remove(product);
                        break;
                    }
                }
            }
            if (!isFind) System.out.println("Tego produktu w sklepie nie ma");

            System.out.println("Czy dodać kolejny produkt. Wpisz Tak (T/Yes/Y) jeśli tak");
            choice = scanner.nextLine();

        }

        if (isFind) System.out.println("W sklepie nie ma tego produktu");
        isFind = false;

        double basketMoney = 0;
        System.out.println("Twój koszyk:");
        for (Product prod : basket) {
            prod.displayProduct();
            basketMoney += prod.countPrice();
        }
        System.out.println("---------------------------------------");
        System.out.printf("Wartość koszyka to %.2f zł\n ", basketMoney);
        System.out.println("---------------------------------------");

        shopMoney = 0;
        System.out.println("Twój sklep:");
        for(Product product : products){
            product.displayProduct();
            shopMoney += product.countPrice();
        }
        System.out.println("---------------------------------------");
        System.out.printf("Wartość sklepu to %.2f zł\n ", shopMoney);
        System.out.println("---------------------------------------");
    }
    public static void InitializedShop(List<Product> products){
        Book book1 = new Book("Pan Tadeusz", 5, 20.99, "Adam Mieckiweicz");
        Book book2 = new Book("Balladyna", 7, 14.99, "Jann Nurburgring");
        Book book3 = new Book("Zemsta", 2, 25.99, "Zbigniew Stonoga");
        Book book4 = new Book("Kamienie na szaniec", 3, 23.99, "Aleksander Kamiński");

        Disc disc1 = new Disc("Płyta Pierwsza", 2, 9.99, "Joahim Lelenir");
        Disc disc2 = new Disc("Płyta Druga", 7, 6.99, "Zygmunt Terraria");
        Disc disc3 = new Disc("Płyta Trzecia", 10, 3.99, "Jakub Klasyk");
        Disc disc4 = new Disc("Płyta Czwarta", 10, 3.99, "Kacper Radzim");

        Toy toy1 = new Toy("Pajacyk", 2, 20.99, 2);
        Toy toy2 = new Toy("Lego", 9, 50.99, 9);
        Toy toy3 = new Toy("Piłka", 20, 15.99, 5);
        Toy toy4 = new Toy("Ukulele", 1, 99.99, 12);

        products.add(book1);
        products.add(book2);
        products.add(book3);
        products.add(book4);

        products.add(disc1);
        products.add(disc2);
        products.add(disc3);
        products.add(disc4);

        products.add(toy1);
        products.add(toy2);
        products.add(toy3);
        products.add(toy4);

    }
}
