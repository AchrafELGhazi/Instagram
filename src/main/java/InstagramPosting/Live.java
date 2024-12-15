package InstagramPosting;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import user.Account;

public class Live extends Post {

    private final LocalTime startTime;
    private Account watcher;
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Live(URL mediaFiles, Account poster) {
        super(mediaFiles, poster);
        this.startTime = LocalTime.now().withNano(0);
    }

    public Live(URL mediaFiles, String caption, String hashtags, Account poster) {
        super(mediaFiles, caption, hashtags, poster);
        this.startTime = LocalTime.now().withNano(0);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public Account getWatcher() {
        return watcher;
    }

    public void setWatcher(Account watcher) {
        this.watcher = watcher;
    }

    public void startStreaming() {
        System.out.println("Starting live streaming...");
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nLive start time: " + startTime.format(timeFormatter)
                + "\nWatcher: " + (watcher != null ? watcher.getUserName() : "none");
    }
}
