package movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBconnection;

public class MovieListView {
    public void displayMovieList(List<MovieModel> List) {
        List<MovieModel> movieList = getMovieList();

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

    public List<MovieModel> getMovieList() {
        List<MovieModel> movieList = new ArrayList<>();

        try (Connection connection = DBconnection.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM movies");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("movie id");
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
