package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.ArrayList;
import java.util.HashMap;

public class CacheMiddleware extends HandlerManager implements IRequestHandler {

    private IRequestHandler movies;
    private int expiryCount;
    private HashMap<Request, Integer> caches;

    public CacheMiddleware(IRequestHandler movies, int expiryCount) {
        this.movies = movies;
        this.expiryCount = expiryCount;
        caches = new HashMap<Request, Integer>();
    }
    @Override
    public ResultBase handle(Request request) {

        ResultBase result = movies.handle(request);
        super.handler = movies;
        super.request = request;
        super.result = result;

        if (expiryCount <= 1) {

            return result;
        }

        if (caches.containsKey(request)) {
            int count = caches.get(request);
            if (count == 1) {
                caches.put(request, expiryCount);

                return result;
            } else {
                caches.put(request, --count);
                super.handler = this;
                result = new CachedResult(count);
                super.result = result;

                return result;
            }
        } else if (result.getCode() == ResultCode.OK) {
            caches.put(request, expiryCount);

            return result;
        }

        return result;
    }
}
