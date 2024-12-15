package InstagramPosting;

public class NoPostsMatchException extends Exception {

  public NoPostsMatchException(int id) {
    super("No posts found with the specified ID: " + id);
  }
}
