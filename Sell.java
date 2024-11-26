package market;
import java.util.ArrayList;
import java.util.List;

public class Sell {
    private List<sale> saleItems = new ArrayList<>();
    private double subtotal;

    public void addProduct(product product, int quantity) {
        boolean productAlreadyAdded = false;

        for (sale item : saleItems) {
            if (item.getProduct().equals(product)) {
                item.increaseQuantity(quantity);
                productAlreadyAdded = true;
                break;
            }
        }
        if (!productAlreadyAdded) {
            saleItems.add(new sale(product, quantity));
        }

        subtotal += product.getUnitPrice() * quantity;
    }

    public void removeProduct(product product) {
        sale itemToRemove = null;

        for (sale item : saleItems) {
            if (item.getProduct().equals(product)) {
                itemToRemove = item;
                subtotal -= item.calculateSubtotal();
                break;
            }
        }

        if (itemToRemove != null) {
            saleItems.remove(itemToRemove);
        }
    }

    public double calculateSubtotal() {
        return subtotal;
    }

    public void completeSale() {
        for (sale item : saleItems) {
            product product = item.getProduct();
            int quantitySold = item.getQuantity();
            product.updateStock(-quantitySold);
        }

        System.out.println("Sale Completed. Total: $" + subtotal);
    }

    public void displaySaleItems() {
        System.out.println("Items in the sale:");
        for (sale item : saleItems) {
            product product = item.getProduct();
            System.out.println("- " + product.getName() + " (Qty: " + item.getQuantity() + 
                               ", Subtotal: $" + item.calculateSubtotal() + ")");
        }
    }
}
