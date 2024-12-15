package InstagramPosting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Comparator;

public class PostCollection {

  private static final String path = "data/instagram.ser";

  private List<Post> posts;

  public PostCollection() {
    posts = new ArrayList<>();
  }

  public ListIterator<Post> getPosts() {
    return posts.listIterator();
  }

  public List<Post> getAllPosts() {
    return posts;
  }

  public boolean addPost(Post post) {
    if (!posts.contains(post)) {
      posts.add(post);
      return true;
    }
    return false;
  }

  public boolean removePost(int id) {
    ListIterator<Post> iterator = posts.listIterator();
    while (iterator.hasNext()) {
      if (iterator.next().getId() == id) {
        iterator.remove();
        return true;
      }
    }
    return false;
  }

  public boolean editPost(int id, Post newPost) {
    ListIterator<Post> iterator = posts.listIterator();
    while (iterator.hasNext()) {
      Post currentPost = iterator.next();
      if (currentPost.getId() == id) {
        Post updatedPost = new Post(
            newPost.getMediaFiles(),
            newPost.getCaption(),
            newPost.getHashtags(),
            currentPost.getPoster(),
            currentPost.getTags());
        updatedPost.setLikes(currentPost.getLikes());
        updatedPost.setDislikes(currentPost.getDislikes());

        iterator.set(updatedPost);
        return true;
      }
    }
    return false;
  }

  public Post searchPostsById(int id) throws NoPostsMatchException {
    for (Post post : posts) {
      if (post.getId() == id) {
        return post;
      }
    }
    throw new NoPostsMatchException(id);
  }

  public void sortPosts(Comparator<Post> comp) {
    Collections.sort(posts, comp);
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    ListIterator<Post> iter = posts.listIterator();
    while (iter.hasNext()) {
      Post post = iter.next();
      str.append(post.toString());
      str.append("\n");
    }
    return str.length() == 0 ? "No posts available." : str.toString();
  }

  public void save() throws FileNotFoundException, IOException, ClassNotFoundException {
    FileOutputStream fos = new FileOutputStream(path, true);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(posts);
    oos.close();
    fos.close();

  }

  public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream(path);
    ObjectInputStream ois = new ObjectInputStream(fis);
    posts = (List<Post>) ois.readObject();
    fis.close();
    ois.close();

  }

}
