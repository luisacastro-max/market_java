package service;
import market.FoodUtensils;
import market.product;
import java.util.List;

public class Reportmanager {

    public void generateExpirationReport(List<product> products, int days) {
        System.out.println("Products expiring in up to " + days + " days:");
        for (product product : products) {
            if (product instanceof FoodUtensils) {
                FoodUtensils food = (FoodUtensils) product;
                if (food.getValidity() <= days) {
                    food.displayDetails();
                }
            }
        }
    }

    public void generateLowStockReport(List<product> products, int quantityLimit) {
        System.out.println("Products with low stock (<= " + quantityLimit + " units):");
        for (product product : products) {
            if (product.getStockQuantity() <= quantityLimit) {
                product.displayDetails();
            }
        }
    }
}

