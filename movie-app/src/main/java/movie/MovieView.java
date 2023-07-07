package movie;

import java.util.List;
import java.util.Scanner;

public class MovieView {
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

    public MovieModel getMovieInput(int id, String title, String genre) {
        return new MovieModel(id, title, genre);
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
   
}
