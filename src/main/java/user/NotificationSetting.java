package user;

public class NotificationSetting {

    private String setting;
    private NotificationType notificationType;

    public NotificationSetting(String notificationType, String setting) {
        setNotificationType(notificationType);
        this.setting = setting;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String setting) {
        try {
            this.notificationType = NotificationType.valueOf(setting.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            this.notificationType = NotificationType.OFF;
        }
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    @Override
    public String toString() {
        return "Type = " + (notificationType != null ? notificationType.name() : "Unknown") +
                ", Setting = " + (setting != null ? setting : "OFF");
    }
}
