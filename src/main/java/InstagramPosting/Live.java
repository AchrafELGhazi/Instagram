/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InstagramPosting;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import user.Account;


public class Live {
    private LocalTime startTime;
    private Account watcher;
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Live(LocalTime startTime, Account watcher) {
        this.startTime = startTime;
        this.watcher = watcher; 
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Account getWatcher() {
        return watcher;
    }

    public void setWatcher(Account watcher) {
        this.watcher = watcher;
    }

    public String toString() {
        return "Live{" +
                "startTime='" + startTime.format(timeFormatter) + '\'' +
                ", watcher=" + (watcher != null ? watcher.getUserName() : "none") + // Displays the username or "none"
                '}';
    }
}