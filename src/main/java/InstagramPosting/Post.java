package InstagramPosting;

import java.net.URL;
import java.time.LocalDate;
import user.Account;
import InstagramShop.BusinessProduct;
import java.io.Serializable;

public class Post implements java.io.Serializable, Comparable<Post> {

    private static final long serialVersionUID = 4L;

    private static int idCounter = 0;

    private final int id;
    private URL mediaFiles;
    private String caption;
    private String hashtags;
    private final LocalDate datePosted;
    private int likes;
    private int dislikes;
    private final Account poster;
    private Comment comment;
    private BusinessProduct tags;

    public Post(String caption) {
        this.id = generateId();
        this.caption = caption;
        this.datePosted = LocalDate.now();
        this.likes = 0;
        this.dislikes = 0;
        this.poster = null;
    }

    public Post(URL mediaFiles, Account poster) {
        this.id = generateId();
        this.mediaFiles = mediaFiles;
        this.poster = poster;
        this.datePosted = LocalDate.now();
        this.likes = 0;
        this.dislikes = 0;
    }

    public Post(URL mediaFiles, String caption, String hashtags, Account poster) {
        this.id = generateId();
        this.mediaFiles = mediaFiles;
        this.caption = caption;
        this.hashtags = hashtags;
        this.poster = poster;
        this.datePosted = LocalDate.now();
        this.likes = 0;
        this.dislikes = 0;
    }

    public Post(URL mediafile, String caption, String hashtags, Account poster, BusinessProduct tags) {
        this.id = generateId();
        this.mediaFiles = mediafile;
        this.caption = caption;
        this.hashtags = hashtags;
        this.poster = poster;
        this.tags = tags;
        this.datePosted = LocalDate.now();
        this.likes = 0;
        this.dislikes = 0;
    }

    private static int generateId() {
        return idCounter++;
    }

    public int getId() {
        return id;
    }

    public URL getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(URL mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    public Account getPoster() {
        return poster;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getHashtags() {
        return hashtags;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public BusinessProduct getTags() {
        return tags;
    }

    public void setTags(BusinessProduct tags) {
        this.tags = tags;
    }

    public void addLike() {
        this.likes++;
        System.out.println("Likes: " + likes);
    }

    public void addDislike() {
        this.dislikes++;
        System.out.println("Dislikes: " + dislikes);
    }

    public void displayFeedback() {
        System.out.println("Likes: " + likes);
        System.out.println("Dislikes: " + dislikes);
    }

    @Override
    public String toString() {
        return "Post ID: " + id
                + "\nPost Content: " + mediaFiles
                + "\nPost Caption: " + caption
                + "\nPost Hashtags: " + hashtags
                + "\nDate Posted: " + datePosted
                + "\nLike Count: " + likes
                + "\nDislike Count: " + dislikes
                + "\nPoster: " + this.getPoster();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Post)) {
            return false;
        }
        Post otherPost = (Post) obj;
        return this.id == otherPost.id
                && this.mediaFiles.equals(otherPost.mediaFiles)
                && this.caption.equals(otherPost.caption)
                && this.hashtags.equals(otherPost.hashtags)
                && this.poster.equals(otherPost.poster);
    }

    @Override
    public int compareTo(Post otherPost) {
        if (this.likes < otherPost.likes) {
            return -1;
        }
        if (this.likes > otherPost.likes) {
            return 1;
        }
        return 0;
    }
}
