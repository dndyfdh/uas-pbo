package login;

import java.util.Scanner;

public class LoginView {
    public User getUserInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
    
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
    
            return new User(userId, password);
        } finally {
            scanner.close();
        }
    }
    
    
    public void displaySuccessMessage() {
        System.out.println("Login successful!");
    }
    
    public void displayErrorMessage() {
        System.out.println("Invalid user ID or password. Please try again.");
    }
}
