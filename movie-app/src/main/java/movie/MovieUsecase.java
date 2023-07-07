package movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MovieUsecase {
    private List<MovieModel> movieList;

    public MovieUsecase() {
        this.movieList = new ArrayList<>();
    }

    public List<MovieModel> getMovieList() {
        return movieList;
    }

    public void addMovie(MovieModel movie) {
        movieList.add(movie);
    }

    public void deleteMovie(int id) {
        Iterator<MovieModel> iterator = movieList.iterator();
        while (iterator.hasNext()) {
            MovieModel movie = iterator.next();
            if (movie.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}

