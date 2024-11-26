package market;
import service.Reportmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<product> products = new ArrayList<>();
        Cashier register = new Cashier();
        Reportmanager reports = new Reportmanager();

        // Adding some initial products
        products.add(new FoodUtensils("001", "Rice", 5.50, 100, 30));
        products.add(new Eletric("002", "Iron", 120.00, 10, 24));

        boolean systemActive = true;

        System.out.println("=== MARKET MANAGEMENT SYSTEM ===");
        System.out.print("Enter the initial register amount: $ ");
        double initialAmount = scanner.nextDouble();
        register.openCashRegister(initialAmount);

        while (systemActive) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Register Sale");
            System.out.println("2. List Products");
            System.out.println("3. Change Product Price");
            System.out.println("4. Generate Reports");
            System.out.println("5. Register Product");
            System.out.println("6. Close Cash Register");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    registerSale(scanner, products, register);
                    break;

                case 2:
                    listProducts(products);
                    break;

                case 3:
                    changeProductPrice(scanner, products);
                    break;

                case 4:
                    generateReports(scanner, products, reports);
                    break;

                case 5:
                    registerProduct(scanner, products);
                    break;

                case 6:
                    register.closeCashRegister();
                    systemActive = false;
                    break;

                case 7:
                    System.out.println("Shutting down the system...");
                    systemActive = false;
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }

        scanner.close();
    }

    private static void registerProduct(Scanner scanner, List<product> products) {
        System.out.println("\n=== REGISTER PRODUCT ===");
        System.out.print("Enter the product code: ");
        String code = scanner.next();

        System.out.print("Enter the product name: ");
        String name = scanner.next();

        System.out.print("Enter the product price: $ ");
        double price = scanner.nextDouble();

        System.out.print("Enter the stock quantity: ");
        int stockQuantity = scanner.nextInt();

        System.out.println("Enter the product type:");
        System.out.println("1. Food Utensils");
        System.out.println("2. Electronics");
        System.out.print("Choose an option: ");
        int productType = scanner.nextInt();

        product newProduct = null;

        switch (productType) {
            case 1:
                System.out.print("Enter the expiration days: ");
                int expirationDays = scanner.nextInt();
                newProduct = new FoodUtensils(code, name, price, stockQuantity, expirationDays);
                break;

            case 2:
                System.out.print("Enter the warranty period in months: ");
                int warrantyMonths = scanner.nextInt();
                newProduct = new Eletric(code, name, price, stockQuantity, warrantyMonths);
                break;

            default:
                System.out.println("Invalid product type!");
                return;
        }

        products.add(newProduct);
        System.out.println("Product successfully registered!");
    }

    private static void registerSale(Scanner scanner, List<product> products, Cashier register) {
        Sell sale = new Sell();
        boolean continueSale = true;

        while (continueSale) {
            System.out.println("\n=== REGISTER SALE ===");
            listProducts(products);
            System.out.print("Enter the product code (or 'end' to finish): ");
            String productCode = scanner.next();

            if (productCode.equalsIgnoreCase("end")) {
                continueSale = false;
                continue;
            }

            product chosenProduct = null;
            for (product p : products) {
                if (p.getCode().equals(productCode)) {
                    chosenProduct = p;
                    break;
                }
            }

            if (chosenProduct == null) {
                System.out.println("Product not found!");
                continue;
            }

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();

            if (quantity > chosenProduct.getStockQuantity()) {
                System.out.println("Insufficient stock!");
            } else {
                sale.addProduct(chosenProduct, quantity);
                System.out.println("Product added!");
                System.out.println("Current subtotal: $ " + sale.calculateSubtotal());
            }
        }

        sale.completeSale();
        register.recordSale(sale.calculateSubtotal());
    }

    private static void listProducts(List<product> products) {
        System.out.println("\n=== PRODUCT LIST ===");
        for (product p : products) {
            p.displayDetails();
        }
    }

    private static void changeProductPrice(Scanner scanner, List<product> products) {
        listProducts(products);
        System.out.print("Enter the product code to change the price: ");
        String productCode = scanner.next();

        product chosenProduct = null;
        for (product p : products) {
            if (p.getCode().equals(productCode)) {
                chosenProduct = p;
                break;
            }
        }

        if (chosenProduct == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter the new price: $ ");
        double newPrice = scanner.nextDouble();
        chosenProduct.changePrice(newPrice);
        System.out.println("Price successfully changed!");
    }

    private static void generateReports(Scanner scanner, List<product> products, Reportmanager reports) {
        System.out.println("\n=== REPORT MENU ===");
        System.out.println("1. Expiring Products");
        System.out.println("2. Products with Low Stock");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.print("Enter the number of days or months to check expiration: ");
                int days = scanner.nextInt();
                reports.generateExpirationReport(products, days);
                break;

            case 2:
                System.out.print("Enter the minimum quantity for the report: ");
                int minimumQuantity = scanner.nextInt();
                reports.generateLowStockReport(products, minimumQuantity);
                break;

            default:
                System.out.println("Invalid option!");
                break;
        }
    }
}

