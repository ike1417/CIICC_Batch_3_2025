import java.util.*;
import java.time.*;

public class GCashApp {
    private static final int MAX_INVALID_ATTEMPTS = 3;
    private static final Duration LOCKOUT_DURATION = Duration.ofMinutes(1);
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, Double> balances = new HashMap<>();
    private static Map<String, Integer> invalidAttempts = new HashMap<>();
    private static Map<String, LocalDateTime> lockoutTimestamps = new HashMap<>();

   private static boolean authenticate(String email, String password) {
    if (!users.containsKey(email)) {
        System.out.println("Email not found.");
        return false;
    }

    if (users.get(email).equals(password)) {
        invalidAttempts.remove(email);
        lockoutTimestamps.remove(email);
        return true;
    } else {
        int attempts = invalidAttempts.getOrDefault(email, 0) + 1;
        invalidAttempts.put(email, attempts);
        if (attempts >= MAX_INVALID_ATTEMPTS) {
            lockoutTimestamps.put(email, LocalDateTime.now());
        }
        return false;
    }
}

    private static boolean isLockedOut(String email) {
        if (!lockoutTimestamps.containsKey(email)) return false;
        return Duration.between(lockoutTimestamps.get(email), LocalDateTime.now()).compareTo(LOCKOUT_DURATION) < 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        users.put("user1@example.com", "pass321");
        users.put("user2@example.com", "pass654");
        balances.put("user1@example.com", 1000.0);
        balances.put("user2@example.com", 700.0);
        
       char repeatLogin = 'Y';
       //char repeatLogin;
        do {
            System.out.println("=== WELCOME TO GCash ===");
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            
            if (!users.containsKey(email)) {
            System.out.println("This email is not registered.");
            continue;
            }
                        
            if (isLockedOut(email)) {
                System.out.println("Account locked. Try again later.");
                return;
            }

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            if (!authenticate(email, password)) {
                int remaining = MAX_INVALID_ATTEMPTS - invalidAttempts.getOrDefault(email, 0);
                if (remaining > 0) {
                    System.out.println("Invalid credentials. Attempts left: " + remaining);
                    continue;
                } else {
                    System.out.println("Too many failed attempts. You are locked out.");
                    return;
                }
            }

            // Logged in
            System.out.println("Login successful!");
            //char repeatLogin;
            char option;
            do {
                System.out.println("\n====== MENU ======");
                System.out.println("1. Check Balance");
                System.out.println("2. Cash In");
                System.out.println("3. Transfer");
                System.out.println("4. Logout");
                System.out.println("5. Exit");
                System.out.print("Select: ");
                option = scanner.nextLine().charAt(0);

                switch (option) {
                    case '1':
                        System.out.println("Your balance: " + balances.get(email));
                        break;

                    case '2':
                        System.out.print("Amount to cash in: ");
                        double amount = Double.parseDouble(scanner.nextLine());
                        balances.put(email, balances.get(email) + amount);
                        System.out.println("Cash-in successful. New balance: " + balances.get(email));
                        break;

                    case '3':
                        System.out.print("Recipient Email: ");
                        String recipient = scanner.nextLine();
                        if (!users.containsKey(recipient) || recipient.equals(email)) {
                            System.out.println("Invalid recipient.");
                            break;
                        }
                        System.out.print("Amount to transfer: ");
                        double transferAmount = Double.parseDouble(scanner.nextLine());
                        if (balances.get(email) >= transferAmount) {
                            balances.put(email, balances.get(email) - transferAmount);
                            balances.put(recipient, balances.get(recipient) + transferAmount);
                            System.out.println("Transfer successful!");
                        } else {
                            System.out.println("Insufficient funds.");
                        }
                        break;

                    case '4':
                        System.out.println("Logging out...");
                        break;

                    case '5':
                        System.out.println("Exiting the app. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option.");
                }

            } while (option != '4');

            System.out.print("Login again? (Y/N): ");
            repeatLogin = scanner.nextLine().charAt(0);

        } while (repeatLogin == 'Y' || repeatLogin == 'y');

        System.out.println("Thank you for using GCash.");
        scanner.close();
    }
}
