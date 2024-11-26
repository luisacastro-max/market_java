package market;

public class Eletric extends product {
    private int warrantyMonths;

    public Eletric(String code, String name, double unitPrice, int stockQuantity, int warrantyMonths) {
        super(code, name, unitPrice, stockQuantity);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    @Override
    public void displayDetails() {
        System.out.println("Code: " + getCode() + ", Name: " + getName() + 
                           ", Price: $" + getUnitPrice() + 
                           ", Stock: " + getStockQuantity() + 
                           ", Warranty: " + warrantyMonths + " months");
    }
}

