package InstagramShop;

public class OrderItem {
    private int qty;
    private BusinessProduct businessProduct;

    public OrderItem(int qty, BusinessProduct businessProduct) {
        this.qty = qty;
        this.businessProduct = businessProduct;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BusinessProduct getBusinessProduct() {
        return businessProduct;
    }

    public void setBusinessProduct(BusinessProduct businessProduct) {
        this.businessProduct = businessProduct;
    }

    public void updateQuantity(int newQty) {
        this.qty = newQty;
        System.out.println("Quantity updated to: " + newQty);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "qty=" + qty +
                ", businessProduct=" + (businessProduct != null ? businessProduct.toString() : "No product") +
                '}';
    }
}
