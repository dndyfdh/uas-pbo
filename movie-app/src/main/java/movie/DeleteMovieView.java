package movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connection.DBconnection;

public class DeleteMovieView {
    public void displaySuccessMessage() {
        System.out.println("Movie deleted successfully.");
    }

    public int getMovieIdInput() {
        int movieId;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter movie ID: ");
            movieId = scanner.nextInt();
            scanner.nextLine();
        }
        return movieId;
    }

    public void deleteMovie(int movieId) {
        try (Connection connection = DBconnection.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM movies WHERE movie_id = ?")) {

            statement.setInt(1, movieId);
            statement.executeUpdate();

            displaySuccessMessage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayMovieList(List<MovieModel> movieList) {
        if (movieList.isEmpty()) {
            System.out.println("No movies available.");
        } else {
            System.out.println("Movie List:");
            for (MovieModel movie : movieList) {
                System.out.println("ID: " + movie.getId());
                System.out.println("Title: " + movie.getTitle());
                System.out.println("Genre: " + movie.getGenre());
                System.out.println("------------");
            }
        }
    }

    public List<MovieModel> getMovieListFromDatabase() {
        List<MovieModel> movieList = new ArrayList<>();

        try (Connection connection = DBconnection.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM movies");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");

                MovieModel movie = new MovieModel(id, title, genre);
                movieList.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movieList;
    }
}
