/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;


public class NotificationSetting {

    private String setting;
    private NotificationType notificationType;

    public NotificationSetting(NotificationType notificationType, String setting) {
        this.notificationType = notificationType;
        this.setting = setting;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String toString() {
        return " Type = " + notificationType + ", Setting = " + setting;
    }
}
