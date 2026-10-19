
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> cart = new ArrayList<>();
        int choice;
        String product;

        do {
            System.out.println("\n1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Search Product");
            System.out.println("4. Display Cart");
            System.out.println("5. Total Products");
            System.out.println("6. Clear Cart");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    product = sc.nextLine().trim();

                    if (product.isEmpty()) {
                        System.out.println("Product name cannot be empty.");
                    } else if (cart.contains(product)) {
                        System.out.println("Product already exists.");
                    } else if (cart.size() >= 10) {
                        System.out.println("Cart is full.");
                    } else {
                        cart.add(product);
                        System.out.println("Product added.");
                    }
                    break;

                case 2:
                    System.out.print("Enter product to remove: ");
                    product = sc.nextLine().trim();

                    if (cart.contains(product)) {
                        cart.remove(product);
                        System.out.println("Product removed.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter product to search: ");
                    product = sc.nextLine().trim();

                    if (cart.contains(product)) {
                        System.out.println("Product is present.");
                    } else {
                        System.out.println("Product is not present.");
                    }
                    break;

                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        System.out.println("Products in cart: " + cart);
                    }
                    break;

                case 5:
                    System.out.println("Total products: " + cart.size());
                    break;

                case 6:
                    cart.clear();
                    System.out.println("Cart cleared.");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        sc.close();
    }
}
