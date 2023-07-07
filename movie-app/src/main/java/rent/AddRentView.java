package rent;

import java.time.LocalDate;
import java.util.Scanner;

public class AddRentView {
    public RentModel getRentInput() {
        Scanner scanner = new Scanner(System.in);

        // Get rent input from user
        int id = getRentIdInput(scanner);
        LocalDate rentDate = getRentDateInput(scanner);
        int movieId = getMovieIdInput(scanner);
        String renter = getRenterInput(scanner);

        return new RentModel(id, rentDate, null, movieId, renter);
    }

    public void displaySuccessMessage() {
        System.out.println("Rent added successfully!");
    }

    private int getRentIdInput(Scanner scanner) {
        System.out.print("Enter rent ID: ");
        return scanner.nextInt();
    }

    private LocalDate getRentDateInput(Scanner scanner) {
        System.out.print("Enter rent date (YYYY-MM-DD): ");
        String rentDateStr = scanner.next();
        return LocalDate.parse(rentDateStr);
    }

    private int getMovieIdInput(Scanner scanner) {
        System.out.print("Enter movie ID: ");
        return scanner.nextInt();
    }

    private String getRenterInput(Scanner scanner) {
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter renter name: ");
        return scanner.nextLine();
    }
}
