package InstagramShop;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class PaymentInfo {
    private int card_number;
    private String holder;
    private YearMonth expires;

    public PaymentInfo(int card_number, String holder, String expires) {
        this.card_number = card_number;
        this.holder = holder;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        this.expires = YearMonth.parse(expires, formatter);
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

    public YearMonth getExpires() {
        return expires;
    }

    public void setExpires(YearMonth expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "card_number=" + card_number +
                ", holder='" + holder + '\'' +
                ", expires=" + expires +
                '}';
    }
}
