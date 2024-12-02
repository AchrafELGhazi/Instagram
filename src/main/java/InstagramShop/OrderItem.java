/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public String toString() {
        return "OrderItem{" +
                "qty=" + qty +
                ", businessProduct=" + (businessProduct != null ? businessProduct.toString() : "No product") +
                '}';
    }
}
