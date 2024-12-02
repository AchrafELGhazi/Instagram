/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;


public class Account {

    private String userName;
    private String password;
    private NotificationSetting notifSetting;
    private Member member;

    public Account(String userName, String password, NotificationSetting notifSetting) {
        this.userName = userName;
        this.password = password;
        this.notifSetting = notifSetting;
    }

    public Account(String userName, String password, NotificationSetting notifSetting, Member member) {
        this(userName, password, notifSetting);
        this.member = member;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NotificationSetting getNotifsetting() {
        return notifSetting;
    }

    public void setNotifsetting(NotificationSetting Notifsetting) {
        this.notifSetting = Notifsetting;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String toString() {
        return "This account's username is " + userName
                + ", and its password is " + password
                + ". Notification setting: " + notifSetting
                + ". Associated member: " + (member != null ? member.toString() : "None");
    }
}
