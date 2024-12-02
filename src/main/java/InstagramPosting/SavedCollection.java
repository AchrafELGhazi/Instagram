/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InstagramPosting;


public class SavedCollection {
    private String name;
    private Post post;

    public SavedCollection(String name, Post post) {
        this.name = name;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String toString() {
        return "SavedCollection{" +
                "name='" + name + '\'' +
                ", post=" + (post != null ? post.toString() : "none") +
                '}';
    }
}