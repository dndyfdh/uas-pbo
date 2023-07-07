package rent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connection.DBconnection;

public class ReturnRentView {
    public int getRentIdInput() {
        int rentId;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter rent ID: ");
            rentId = scanner.nextInt();
            scanner.nextLine();
        }
        return rentId;
    }

    public void displaySuccessMessage() {
        System.out.println("Rent returned successfully!");
    }

    public void returnRent(int rentId) {
        try (Connection connection = DBconnection.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE rents SET return_date = ? WHERE id = ?")) {

            statement.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
            statement.setInt(2, rentId);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                displaySuccessMessage();
            } else {
                System.out.println("Rent ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
