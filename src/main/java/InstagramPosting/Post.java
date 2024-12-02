/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InstagramPosting;

import java.net.URL;
import java.time.LocalTime;
import user.Account;


public class Post {
    private URL mediaFiles;
    private String caption;
    private String hashtags;
    private LocalTime posted;
    private int likes;
    private int dislikes;
    private Account poster;
    private Comment comment;

    public Post(URL mediaFiles, String caption, String hashtags, LocalTime posted, int likes, int dislikes, Account poster, Comment comment) {
        this.mediaFiles = mediaFiles;
        this.caption = caption;
        this.hashtags = hashtags;
        this.posted = posted;
        this.likes = likes;
        this.dislikes = dislikes;
        this.poster = poster;
        this.comment = comment;
    }

    public URL getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(URL mediaFiles) {
        this.mediaFiles = mediaFiles;
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

    public LocalTime getPosted() {
        return posted;
    }

    public void setPosted(LocalTime posted) {
        this.posted = posted;
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

    public Account getPoster() {
        return poster;
    }

    public void setPoster(Account poster) {
        this.poster = poster;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String toString() {
        return "Post{" +
                "mediaFiles=" + mediaFiles +
                ", caption='" + caption + '\'' +
                ", hashtags='" + hashtags + '\'' +
                ", posted=" + posted +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", poster=" + (poster != null ? poster.getUserName() : "none") +
                '}';
    }
}
