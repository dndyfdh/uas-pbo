package movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DBconnection;

public class MovieModel {
    private int id;
    private String title;
    private String genre;

    public MovieModel(int id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

        public List<MovieModel> getMoviesFromDatabase() {
        List<MovieModel> movieList = new ArrayList<>();

        try (Connection connection = DBconnection.getDataSource().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM movies")) {

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

    public void displayMovieListFromDatabase() {
        List<MovieModel> movieList = getMoviesFromDatabase();

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

}

