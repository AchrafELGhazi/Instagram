package InstagramMain;

import user.*;
import InstagramPosting.*;
import InstagramShop.*;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class InstagramApp {

  public static PostCollection postCollection;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // User Account Creation
    System.out.println("---------------------------Create a new account--------------------------------");
    System.out.print("Username: ");
    String username = scanner.nextLine();
    System.out.print("Password: ");
    String password = scanner.nextLine();

    System.out.println("Select notification type (OFF, FOLLOWED, EVERYONE): ");
    String notificationType = scanner.nextLine().toUpperCase();

    System.out.println("Notification setting (ON/OFF): ");
    String notificationSetting = scanner.next().toUpperCase();

    NotificationSetting notification = new NotificationSetting(notificationType, notificationSetting);
    Account userAccount = new Account(username, password, notification);

    System.out.println("\nAccount Information:");
    System.out.println(userAccount.toString());
    System.out.println("-----------------------------------\n");

    // Profile Creation
    System.out.println("-----------------------------Profile Information---------------------------");
    URL profileUrl = null;
    try {
      profileUrl = new URL("https://www.google.com");
    } catch (MalformedURLException e) {
    }
    Profile userProfile = new Profile("AYA EL GOURGI", "Passionate coder and traveler", "aya.grj@gmail.com",
        profileUrl);
    System.out.println(userProfile.toString());
    System.out.println("--------------------------------------------------------------------\n");

    // Post Creation
    System.out.println("    Post Information:");
    Post post = new Post(profileUrl, "Learning Java is so much fun!", "#coding #java", userAccount);
    post.setLikes(100);
    post.setDislikes(10);
    System.out.println(post.toString());
    System.out.println("--------------------------------------------------------------------\n");

    // Live Post Creation
    System.out.println("    Live Post Information:");
    BusinessProduct businessProduct = new BusinessProduct("A live coding session with Oracle support", 50, profileUrl);
    Post livePost = new Live(profileUrl, "Live coding with Java and Oracle!", "#java #oracle", userAccount);
    System.out.println(livePost.toString());
    System.out.println("--------------------------------------------------------------------\n");

    // Story Post Creation
    System.out.println("    Story Post Information:");
    Post storyPost = new Story(profileUrl, "Vacation in paris, so relaxing!", "#vacation #Bali", userAccount);
    System.out.println(storyPost.toString());
    System.out.println("--------------------------------------------------------------------\n");

    // Saved Collection Information
    System.out.println("    Saved Collection Information:");
    SavedCollection savedCollection = new SavedCollection("Java Learning Series", post);
    System.out.println(savedCollection.toString());
    System.out.println("--------------------------------------------------------------------\n");

    // Payment Information
    PaymentInfo paymentInfo = new PaymentInfo(12345, "Achraf EL Ghazi", "12/25");

    // Shipping Information
    ShippingInfo shippingInfo = new ShippingInfo("TOTO", "somewhere", "0622347233");

    // Order Item Information
    OrderItem orderItem = new OrderItem(1, businessProduct);

    // Order Information
    System.out.println("    Order Information:");
    Order order = new Order(97354, "2024-12-14", Status.SHIPPED, orderItem, paymentInfo, shippingInfo);
    System.out.println(order.toString());
    System.out.println("--------------------------------------------------------------------\n");

    // Post Collection Operations
    postCollection = new PostCollection();

    try {
      postCollection.load();
      System.out.println("\nData loaded successfully");
      System.out.println("\nCollection: " + postCollection.toString());

    } catch (FileNotFoundException ex) {
      System.err.println("\nFile not found");
    } catch (Exception ex) {
      System.err.println("\nUnable to load file");
      ex.printStackTrace();

    }

    postCollection.addPost(post);
    postCollection.addPost(livePost);
    postCollection.addPost(storyPost);

    System.out.println("\n   ================================  Menu  ================================");
    System.out.println("   Please select an operation by entering the corresponding number:");
    System.out.println("   1 - Add a new post");
    System.out.println("   2 - Remove an existing post");
    System.out.println("   3 - Search for a post by ID");
    System.out.println("   4 - Modify an existing post");
    System.out.println("   5 - Sort posts");
    System.out.println("   6 - Exit the application");
    System.out.println("   7 - Process posts polymorphically");
    System.out.println("   ============================================================================");
    int choice = scanner.nextInt();
    scanner.nextLine();

    while (choice != 6) {
      switch (choice) {
        case 1 -> {
          // Add a new post
          System.out.println("\nEnter post caption:");
          String caption = scanner.nextLine();
          System.out.println("Enter post hashtags:");
          String hashtags = scanner.nextLine();
          System.out.println("Enter number of likes:");
          int likes = scanner.nextInt();
          System.out.println("Enter number of dislikes:");
          int dislikes = scanner.nextInt();
          scanner.nextLine();

          Post newPost = new Post(profileUrl, caption, hashtags, userAccount);
          newPost.setLikes(likes);
          newPost.setDislikes(dislikes);

          postCollection.addPost(newPost);

          System.out.println("\nPost added successfully.");
        }

        case 2 -> {
          // Remove a post by ID
          System.out.println("\nEnter post ID to remove:");
          int id = scanner.nextInt();
          scanner.nextLine();
          try {
            postCollection.removePost(id);
            System.out.println("\nPost removed successfully.");
          } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
          }
        }
        case 3 -> {
          // Search for a post by ID
          System.out.println("\nEnter post ID to search:");
          int id = scanner.nextInt();
          scanner.nextLine();

          try {
            Post foundPost = postCollection.searchPostsById(id);
            System.out.println("\nPost found:\n" + foundPost);
          } catch (NoPostsMatchException e) {
            System.out.println("\n" + e.getMessage());
          }
        }
        case 4 -> {
          // Modify a post
          System.out.println("\nEnter post ID to modify:");
          int id = scanner.nextInt();
          scanner.nextLine();
          System.out.println("Enter new caption:");
          String newCaption = scanner.nextLine();
          System.out.println("Enter new hashtags:");
          String newHashtags = scanner.nextLine();
          Post modifiedPost = new Post(profileUrl, newCaption, newHashtags, userAccount);
          boolean modified = postCollection.editPost(id, modifiedPost);
          System.out.println(modified ? "\nPost modified successfully." : "\nPost not found.");
        }
        case 5 -> {
          // Sort posts by likes using custom comparator
          postCollection.sortPosts(new PostComparatorByLikes());
          System.out.println("\nPosts sorted by likes.");
        }
        case 7 -> {
          // Process all posts polymorphically
          processPostsPolymorphically();
        }

        default ->
          System.out.println("\nInvalid choice.");
      }

      System.out.println("\n\n------------------------------------Current Collection--------------------------------\n"
          + postCollection);
      System.out.println("\n   ================================  Menu  ================================");
      System.out.println("   Please select an operation by entering the corresponding number:");
      System.out.println("   1 - Add a new post");
      System.out.println("   2 - Remove an existing post");
      System.out.println("   3 - Search for a post by ID");
      System.out.println("   4 - Modify an existing post");
      System.out.println("   5 - Sort posts");
      System.out.println("   6 - Exit the application");
      System.out.println("   7 - Process posts polymorphically");
      System.out.println("   ============================================================================");
      choice = scanner.nextInt();
      scanner.nextLine();
    }

    try {
      postCollection.save();
      System.out.println("\nData saved successfully.");
    } catch (Exception ex) {
      System.err.println("\nError saving data: " + ex.getMessage());
      ex.printStackTrace();
    }

    System.out.println(
        "\n\n--------------------------------------------Final Collection--------------------------------------------\n"
            + postCollection);
    scanner.close();
  }

  public static void processPostsPolymorphically() {
    System.out.println("\n============================== Processing Posts ==============================");
    for (Post post : postCollection.getAllPosts()) {
      System.out
          .println("\n------------------------------ Post ID: " + post.getId() + " ------------------------------");
      System.out.println("Caption: " + post.getCaption());
      System.out.println("Hashtags: " + post.getHashtags());

      if (post instanceof Live) {
        Live livePost = (Live) post;
        System.out.println("Type: Live Post");
        livePost.startStreaming();
      } else if (post instanceof Story) {
        Story storyPost = (Story) post;
        System.out.println("Type: Story Post");
        storyPost.showStory();
      } else {
        System.out.println("Type: Regular Post");
      }

      System.out.println("Likes: " + post.getLikes() + " | Dislikes: " + post.getDislikes());
      System.out.println("--------------------------------------------------------------------------");
    }
    System.out.println("============================== End of Posts ==============================");
  }

}
