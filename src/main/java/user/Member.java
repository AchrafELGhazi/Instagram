/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import InstagramPosting.*;
import InstagramShop.*;
import InstagramMessaging.*;



public class Member {

    private Profile profile;
    private Account account;
    private Message message;
    private Order order;
    private SavedCollection savedCollection;
    private Post post;

    public Member(Profile profile, Account account, Message message, Order order,
                  SavedCollection savedCollection, Post post) {
        this.profile = profile;
        this.account = account;
        this.message = message;
        this.order = order;
        this.savedCollection = savedCollection;
        this.post = post;
        
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public SavedCollection getSavedCollection() {
        return savedCollection;
    }

    public void setSavedCollection(SavedCollection savedCollection) {
        this.savedCollection = savedCollection;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    


    public String toString() {
        return "Member Profile: " + profile.toString() + "\n"
                + "Account: " + account.toString() + "\n"
                + "Message: " + (message != null ? message.toString() : "No messages") + "\n"
                + "Order: " + (order != null ? order.toString() : "No orders") + "\n"
                + "Saved Collection: " + (savedCollection != null ? savedCollection.toString() : "No saved collections") + "\n"
                + "Post: " + (post != null ? post.toString() : "No posts") + "\n";
                
    }
}

