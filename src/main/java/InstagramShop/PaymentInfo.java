/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InstagramShop;

import java.time.LocalDate;


public class PaymentInfo {
    private int card_number;
    private String holder;
    private LocalDate expires;

    public PaymentInfo(int card_number, String holder, LocalDate expires) {
        this.card_number = card_number;
        this.holder = holder;
        this.expires = expires;
    }

    public int getCardNumber() {
        return card_number;
    }

    public void setCardNumber(int card_number) {
        this.card_number = card_number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public void setExpires(LocalDate expires) {
        this.expires = expires;
    }

    public String toString() {
        return "PaymentInfo{" +
                "card_number=" + card_number +
                ", holder='" + holder + '\'' +
                ", expires=" + expires +
                '}';
    }
}
