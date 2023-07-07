package uas.pbo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// import java.util.InputMismatchException;

import login.WelcomeView;
import login.Login;
import login.User;
import login.LoginView;
import login.UserListView;
import login.AddUserView;
import login.ChangePasswordView;
import movie.MovieModel;
import movie.MovieUsecase;
import movie.MovieListView;
import movie.AddMovieView;
import movie.DeleteMovieView;
import rent.RentModel;
import rent.RentUsecase;
import rent.RentListView;
import rent.AddRentView;
import rent.ReturnRentView;


public class Main {
    public static void main(String[] args) {
        // Create instances of views, use cases, and models
        WelcomeView welcomeView = new WelcomeView();
        LoginView loginView = new LoginView();
        UserListView userListView = new UserListView();
        AddUserView addUserView = new AddUserView();
        ChangePasswordView changePasswordView = new ChangePasswordView();
        MovieListView movieListView = new MovieListView();
        AddMovieView addMovieView = new AddMovieView();
        DeleteMovieView deleteMovieView = new DeleteMovieView();
        RentListView rentListView = new RentListView();
        AddRentView addRentView = new AddRentView();
        ReturnRentView returnRentView = new ReturnRentView();

        List<User> userList = new ArrayList<>();
        Login loginValidate = new Login(userList);
        MovieUsecase movieUsecase = new MovieUsecase();
        RentUsecase rentUsecase = new RentUsecase();

        // Display welcome message
        welcomeView.displayWelcomeMessage();

        // Perform login
        User loggedInUser = null;
        while (loggedInUser == null) {
            User userInput = loginView.getUserInput();
            boolean isValidUser = loginValidate.isValidUser(userInput.getUserId(), userInput.getPassword());
            if (isValidUser) {
                loggedInUser = userInput;
                loginView.displaySuccessMessage();
            } else {
                loginView.displayErrorMessage();
            }
        }

        // Main menu loop
        boolean exitApp = false;
        while (!exitApp) {
            // Display main menu
            int menuSelection = displayMainMenu();

            switch (menuSelection) {
                case 1:
                    // Display user list
                    List<User> users = userListView.getUserList();
                    userListView.displayUserList(users);
                    break;
                case 2:
                    // Add user
                    User newUser = addUserView.getUserInput();
                    userListView.addUser(newUser);
                    break;
                case 3:
                    // Change password
                    String userId = changePasswordView.getUserIdInput();
                    String newPassword = changePasswordView.getNewPasswordInput();
                    userListView.changePassword(userId, newPassword);
                    break;
                case 4:
                    // Display movie list
                    List<MovieModel> movieList = movieListView.getMovieList();
                    movieListView.displayMovieList(movieList);
                    break;
                case 5:
                    // Add movie
                    MovieModel newMovie = addMovieView.getMovieInput();
                    movieUsecase.addMovie(newMovie);
                    break;
                case 6:
                    // Delete movie
                    int movieId = deleteMovieView.getMovieIdInput();
                    movieUsecase.deleteMovie(movieId);
                    break;
                case 7:
                    // List active rents
                    List<RentModel> activeRentList = rentListView.getRentList();
                    rentListView.displayRentList(activeRentList);
                    break;
                case 8:
                    // Add rent
                    RentModel newRent = addRentView.getRentInput();
                    rentUsecase.addRent(newRent);
                    break;
                case 9:
                    // Return rent
                    int rentId = returnRentView.getRentIdInput();
                    rentUsecase.returnRent(rentId);
                    break;
                case 10:
                    // Exit the application
                    exitApp = true;
                    break;
                default:
                    System.out.println("Invalid menu selection. Please try again.");
                    break;
            }
        }
    }

    private static int displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
    
        try {
            System.out.println("\nMain Menu");
            System.out.println("1. Display User List");
            System.out.println("2. Add User");
            System.out.println("3. Change Password");
            System.out.println("4. Display Movie List");
            System.out.println("5. Add Movie");
            System.out.println("6. Delete Movie");
            System.out.println("7. List Active Rents");
            System.out.println("8. Add Rent");
            System.out.println("9. Return Rent");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
    
            while (true) {
                String input = scanner.nextLine();
                try {
                    choice = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid menu choice.");
                    System.out.print("Enter your choice: ");
                }
            }
        } finally {
            scanner.close();
        }
    
        return choice;
    }
    
}