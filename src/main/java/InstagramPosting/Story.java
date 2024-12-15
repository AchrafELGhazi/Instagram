package InstagramPosting;

import java.net.URL;
import user.Account;
import InstagramShop.BusinessProduct;

public class Story extends Post {

    public static final int DURATION = 24;

    public Story(URL mediaFiles, Account poster) {
        super(mediaFiles, poster);
    }

    public Story(URL mediaFiles, String caption, String hashtags, Account poster) {
        super(mediaFiles, caption, hashtags, poster);
    }

    public Story(URL mediaFiles, String caption, String hashtags, Account poster, BusinessProduct tags) {
        super(mediaFiles, caption, hashtags, poster, tags);
    }

    public int getDuration() {
        return DURATION;
    }

    public void showStory() {
        System.out.println("Displaying story for 24 hours...");
    }

    @Override
    public String toString() {
        return super.toString() + "\nDuration: " + DURATION + " hours";
    }
}
