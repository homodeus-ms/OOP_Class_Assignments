package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieStore implements IRequestHandler {

    private static ArrayList<Movie> movies = new ArrayList<>();
    //private final HashMap<ResultBase, Request> results = new HashMap<>();

    public void add(Movie movie) {
        movies.add(movie);
    }
    public boolean remove(int index) {

        if (index >= 0 && index < movies.size()) {
            movies.remove(index);
            return true;
        }
        return false;
    }
    @Override
    public ResultBase handle(Request request) {

        HashMap<ResultBase, Request> map = HandlerManager.getInstance().getRequests();
        ResultBase result;

        for (Movie movie : movies) {
            if (movie.getTitle().equals(request.getTitle())) {
                result = new OkResult(movie);
                map.put(result, request);

                return result;
            }
        }
        result = new NotFoundResult();
        map.put(result, request);

        return result;
    }
}
