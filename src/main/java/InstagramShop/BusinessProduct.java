/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InstagramShop;

import java.net.URL;

public class BusinessProduct {
    private String description;
    private double price;
    private URL link;

    public BusinessProduct(String description, double price, URL link) {
        this.description = description;
        this.price = price;
        this.link = link;
    }

    public BusinessProduct(String description, double price) {
        this.description = description;
        this.price = price;
        this.link = null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public URL getLink() {
        return link;
    }

    public void setLink(URL link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "BusinessProduct{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", link=" + link +
                '}';
    }
}
