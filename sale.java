package market;

public class sale {

    private product product;
    private int quantity;

    public sale(product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double calculateSubtotal() {
        return product.getUnitPrice() * quantity;
    }
}


