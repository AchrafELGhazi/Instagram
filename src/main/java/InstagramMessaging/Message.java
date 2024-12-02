/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InstagramMessaging;

import java.time.LocalDate;
import user.Account;
import java.time.format.DateTimeFormatter;


public class Message {
    private String text;
    private LocalDate received;
    private boolean seen;
    private Account sender;
    private Account receiver;
    
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Message(String text, LocalDate received, boolean seen, Account sender, Account receiver) {
        this.text = text;
        this.received = received;
        this.seen = seen;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getReceived() {
        return received;
    }

    public void setReceived(LocalDate received) {
        this.received = received;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", received=" + received.format(dateFormatter) +
                ", seen=" + seen +
                ", sender=" + sender.getUserName() +
                ", receiver=" + receiver.getUserName() +
                '}';
    }
}
