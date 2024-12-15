package user;

import java.net.URL;

public class Profile {

    private String name;
    private String bio;
    private String email;
    private URL picture;

    public Profile(String name, String bio, String email) {
        this.name = name;
        this.bio = bio;
        this.email = email;
    }

    public Profile(String name, String bio, String email, URL picture) {
        this(name, bio, email);
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public URL getPicture(){
        return picture;
    }

    public void setPicture(URL picture) {
        this.picture = picture;
    }

    public void updateBio(String newBio) {
        this.bio = newBio;
        System.out.println("Bio updated successfully.");
    }

    @Override
    public String toString() {
        return "Profile: Name = " + name + ", Bio = " + bio + ", Email = " + email + ", Picture = " + picture;
    }
}
