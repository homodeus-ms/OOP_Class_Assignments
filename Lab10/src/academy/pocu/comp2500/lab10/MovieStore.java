package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;

public class MovieStore implements IRequestHandler {

    private final ArrayList<Movie> movies = new ArrayList<>();

    public void add(Movie movie) {
        movies.add(movie);
    }
    public boolean remove(int index) {

        if ( index >= 0 && index < movies.size()) {
            movies.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public ResultBase handle(Request request) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(request.getTitle())) {
                return new OkResult(movie);
            }
        }
        return new NotFoundResult();
    }
}
