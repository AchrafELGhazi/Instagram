/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InstagramShop;
import java.time.LocalDate;


public class Order {
    private int reference;
    private LocalDate placed;
    private Status status;
    private OrderItem orderItem;
    private PaymentInfo paymentInfo;
    private ShippingInfo shippingInfo;

    public Order(int reference, LocalDate placed, Status status, 
                 OrderItem orderItem, PaymentInfo paymentInfo, 
                 ShippingInfo shippingInfo) {
        this.reference = reference;
        this.placed = placed;
        this.status = status;
        this.orderItem = orderItem;
        this.paymentInfo = paymentInfo;
        this.shippingInfo = shippingInfo;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public LocalDate getPlaced() {
        return placed;
    }

    public void setPlaced(LocalDate placed) {
        this.placed = placed;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    
    public String toString() {
        return "Order{" +
                "reference=" + reference +
                ", placed=" + placed +
                ", status=" + status +
                ", orderItem=" + (orderItem != null ? orderItem.toString() : "No order items") +
                ", paymentInfo=" + (paymentInfo != null ? paymentInfo.toString() : "No payment info") +
                ", shippingInfo=" + (shippingInfo != null ? shippingInfo.toString() : "No shipping info") +
                '}';
    }
}
    
