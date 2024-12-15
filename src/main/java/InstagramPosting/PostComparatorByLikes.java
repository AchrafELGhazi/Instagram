
package InstagramPosting;

import java.util.Comparator;

public class PostComparatorByLikes implements Comparator<Post> {

  @Override
  public int compare(Post post1, Post post2) {
    if (post1.getLikes() > post2.getLikes()) {
      return 1;
    } else if (post1.getLikes() < post2.getLikes()) {
      return -1;
    }
    return 0;
  }
}
