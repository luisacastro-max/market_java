package market;

public class FoodUtensils extends product {
    private int validity; 

    public FoodUtensils(String code, String name, double unitPrice, int stockQuantity, int validity) {
        super(code, name, unitPrice, stockQuantity);
        this.validity = validity;
    }

    public int getValidity() {
        return validity;
    }

    @Override
    public void displayDetails() {
        System.out.println("Code: " + getCode() + ", Name: " + getName() + 
                           ", Price: $" + getUnitPrice() + 
                           ", Stock: " + getStockQuantity() + 
                           ", Validity: " + validity + " days");
    }
}



