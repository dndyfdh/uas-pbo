package login;

import java.util.Scanner;

public class AddUserView {
    public User getUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter user ID: ");
            String userId = scanner.nextLine();
        
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
        
            return new User(userId, password);
        }
    }
    
    public void displaySuccessMessage() {
        System.out.println("User added successfully!");
    }
}
