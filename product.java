package market;

public abstract class product {
    private String code;
    private String name;
    private double unitPrice;
    private int stockQuantity;

    public product(String code, String name, double unitPrice, int stockQuantity) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void updateStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void changePrice(double newPrice) {
        this.unitPrice = newPrice;
    }

    public abstract void displayDetails();
}
