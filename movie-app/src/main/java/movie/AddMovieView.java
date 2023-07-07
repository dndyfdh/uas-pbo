package movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connection.DBconnection;

public class AddMovieView {
    public MovieModel getMovieInput() {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter movie ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter movie title: ");
            String title = scanner.nextLine();
            
            System.out.print("Enter movie genre: ");
            String genre = scanner.nextLine();
            
            return new MovieModel(id, title, genre);
        } finally {
            scanner.close();
        }
    }

    public void addMovieToDatabase(MovieModel movie) {
        try (Connection connection = DBconnection.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO movies (movie_id, title, genre) VALUES (?, ?, ?)")) {

            statement.setInt(1, movie.getId());
            statement.setString(2, movie.getTitle());
            statement.setString(3, movie.getGenre());
            statement.executeUpdate();

            System.out.println("Movie added to the database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displaySuccessMessage() {
        System.out.println("Movie added list successfully!");
    }
}
