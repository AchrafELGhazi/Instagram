package InstagramMain;

import InstagramMessaging.Message;
import InstagramShop.*;
import user.*;
import InstagramPosting.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InstagramApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //create an account
        System.out.println("---------------------------Creating account---------------------------");
        System.out.println("Please provide a username: ");
        String username = sc.nextLine();

        System.out.println("Please provide a password: ");
        String password = sc.nextLine();

        System.out.println("Please provide a notification setting: ");
        String setting = sc.nextLine();

        String notificationTypeInput;
        NotificationType notificationType = null;

        while (notificationType == null) {
            System.out.println("Please provide a notification type (OFF, FOLLOWED, EVERYONE): ");
            notificationTypeInput = sc.nextLine().toUpperCase();

            try {
                notificationType = NotificationType.valueOf(notificationTypeInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid notification type. Please try again.");
                notificationType = null;
            }
        }

        NotificationSetting notifSetting = new NotificationSetting(notificationType, setting);
        Account account = new Account(username, password, notifSetting);
        System.out.println("Account created successfully:");
        System.out.println(account.toString());

        //set profile
        System.out.println("---------------------------Setting profile---------------------------");

        System.out.println("Please provide a name for your profile: ");
        String name = sc.nextLine();

        System.out.println("Please provide a bio: ");
        String bio = sc.nextLine();

        System.out.println("Please provide your email address: ");
        String email = sc.nextLine();

        Profile profile = new Profile(name, bio, email);
        System.out.println("Profile set successfully:");
        System.out.println(profile.toString());

        //create a post
        System.out.println("---------------------------creating a post---------------------------");

        String urlInput;
        URL content = null;

        while (content == null) {
            System.out.println("Please provide content for the post (URL): ");
            urlInput = sc.nextLine();

            try {
                content = new URL(urlInput);
            } catch (MalformedURLException e) {
                System.out.println("Invalid URL. Please try again.");
            }
        }

        System.out.println("Please provide a caption for the post: ");
        String caption = sc.nextLine();

        System.out.println("Please provide hashtags for the post: ");
        String hashtags = sc.nextLine();

        String timeInput;
        LocalTime postedTime = null;

        while (postedTime == null) {
            System.out.println("Please provide the posted time (HH:mm:ss): ");
            timeInput = sc.nextLine();

            try {
                postedTime = LocalTime.parse(timeInput);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please use HH:mm:ss format.");
            }
        }

        System.out.println("Please provide the number of likes: ");
        int likes = Integer.parseInt(sc.nextLine());

        System.out.println("Please provide the number of dislikes: ");
        int dislikes = Integer.parseInt(sc.nextLine());

        Comment comment = null;

        Post post = new Post(content, caption, hashtags, postedTime, likes, dislikes, account, comment);

        System.out.println("Post created successfully:");
        System.out.println(post.toString());

        //placing order
        System.out.println("---------------------------Posting an order---------------------------");

        System.out.println("Please provide an order reference number: ");
        int reference = sc.nextInt();
        sc.nextLine();

        System.out.println("Please provide the order date (YYYY-MM-DD): ");
        LocalDate placed = null;
        while (placed == null) {
            try {
                placed = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the order date in the format YYYY-MM-DD: ");
            }
        }

        System.out.println("Please provide the order status (e.g., PENDING, COMPLETED): ");
        String statusInput = sc.nextLine().toUpperCase();
        Status status = null;
        while (status == null) {
            try {
                status = Status.valueOf(statusInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status. Please enter a valid status (e.g., PENDING, COMPLETED): ");
                statusInput = sc.nextLine().toUpperCase();
            }
        }

        System.out.println("Please provide details for the business product: ");
        System.out.println("Enter product description: ");
        String description = sc.nextLine();
        System.out.println("Enter product price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter product link (URL): ");
        String productUrlInput = sc.nextLine();
        URL link = null;

        while (link == null) {
            try {
                link = new URL(productUrlInput);
            } catch (MalformedURLException e) {
                System.out.println("Invalid URL. Please enter a valid product link: ");
                productUrlInput = sc.nextLine();
            }
        }

        BusinessProduct businessProduct = new BusinessProduct(description, price, link);

        System.out.println("Enter the quantity of the product: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        OrderItem orderItem = new OrderItem(quantity, businessProduct);

        System.out.println("Please provide payment information: ");
        System.out.println("Enter card number (digits only): ");
        int cardNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter card holder's name: ");
        String holder = sc.nextLine();
        System.out.println("Enter card expiry date (YYYY-MM-DD): ");
        LocalDate expires = null;
        while (expires == null) {
            try {
                expires = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the expiry date in the format YYYY-MM-DD: ");
            }
        }

        PaymentInfo paymentInfo = new PaymentInfo(cardNumber, holder, expires);

        System.out.println("Please provide shipping information: ");
        System.out.println("Enter recipient's name: ");
        String recipientName = sc.nextLine();
        System.out.println("Enter shipping address: ");
        String shippingAddress = sc.nextLine();
        System.out.println("Enter recipient's phone number: ");
        String phone = sc.nextLine();

        ShippingInfo shippingInfo = new ShippingInfo(recipientName, shippingAddress, phone);

        Order order = new Order(reference, placed, status, orderItem, paymentInfo, shippingInfo);

        System.out.println("Order created successfully!");
        System.out.println(order.toString());

        //Assuming we are messaging another person, and that the sender is the account set at the beginning
        System.out.println("---------------------------Message testing---------------------------");

        System.out.println("Please provide the receiver's username: ");
        String receiverUserName = sc.nextLine();

        System.out.println("Please provide the receiver's password: ");
        String receiverPassword = sc.nextLine();

        System.out.println("Please provide notification settings for the receiver: ");
        String receiverSetting = sc.nextLine();

        System.out.println("Please provide the notification type for the receiver (OFF, FOLLOWED, EVERYONE): ");
        String receiverInput = sc.nextLine().toUpperCase();
        NotificationType receiverNotificationType = null;

        while (receiverNotificationType == null) {
            try {
                receiverNotificationType = NotificationType.valueOf(receiverInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid notification type. Please try again (OFF, FOLLOWED, EVERYONE): ");
                receiverInput = sc.nextLine().toUpperCase();
            }
        }

        NotificationSetting receiverNotifSetting = new NotificationSetting(receiverNotificationType, receiverSetting);
        Account receiverAccount = new Account(receiverUserName, receiverPassword, receiverNotifSetting);

        System.out.println("Please provide the message text: ");
        String messageText = sc.nextLine();

        System.out.println("Please provide the received date (YYYY-MM-DD): ");
        LocalDate receivedDate = null;
        while (receivedDate == null) {
            try {
                receivedDate = LocalDate.parse(sc.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date (YYYY-MM-DD): ");
            }
        }

        Message message = new Message(messageText, receivedDate, false, account, receiverAccount);

        System.out.println("Message sent from: " + account.toString());
        System.out.println("Message sent to: " + receiverAccount.toString());
        System.out.println("Message content: " + message.toString());
    }

}
