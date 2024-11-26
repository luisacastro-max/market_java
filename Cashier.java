package market;

public class Cashier {

    private double initialAmount;
    private double currentAmount;
    private double totalSales;

    public void openCashRegister(double initialAmount) {
        this.initialAmount = initialAmount;
        this.currentAmount = initialAmount;
        this.totalSales = 0;
    }

    public void recordSale(double saleAmount) {
        this.currentAmount += saleAmount;
        this.totalSales += saleAmount;
    }

    public void closeCashRegister() {
        System.out.println("Initial Amount: $" + initialAmount);
        System.out.println("Total Sales: $" + totalSales);
        System.out.println("Final Amount in Register: $" + currentAmount);
    }
}


