package login;

import java.util.Scanner;

public class ChangePasswordView {
    public String getUserIdInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter user ID: ");
            return scanner.nextLine();
        }
    }

    public String getNewPasswordInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter new password: ");
            return scanner.nextLine();
        }
    }

    public void displaySuccessMessage() {
        System.out.println("Password changed successfully!");
    }
}
