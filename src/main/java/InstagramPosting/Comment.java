/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InstagramPosting;

import java.time.LocalDate;
import user.Account;
import java.time.format.DateTimeFormatter;


public class Comment {

    private String text;
    private LocalDate date;
    private Account author;
    private Comment reply;

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Comment(String text, LocalDate date, Account author) {
        this.text = text;
        this.date = date;
        this.author = author;
        this.reply = null;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public Comment getReply() {
        return reply;
    }

    public void setReply(Comment reply) {
        this.reply = reply;
    }

    public String toString() {
        String formattedDate = date.format(dateFormatter);
        return "Comment{"
                + "author='" + author.getUserName() + '\''
                + ", date=" + formattedDate
                + ", text='" + text + '\''
                + ", reply=" + (reply != null ? reply.toString() : "null")
                + '}';
    }

}
