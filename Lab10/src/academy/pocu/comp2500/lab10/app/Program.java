package academy.pocu.comp2500.lab10.app;

import academy.pocu.comp2500.lab10.AuthorizationMiddleware;
import academy.pocu.comp2500.lab10.CacheMiddleware;
import academy.pocu.comp2500.lab10.CachedResult;
import academy.pocu.comp2500.lab10.MaintenanceMiddleware;
import academy.pocu.comp2500.lab10.MovieStore;
import academy.pocu.comp2500.lab10.Request;
import academy.pocu.comp2500.lab10.ResultValidator;
import academy.pocu.comp2500.lab10.ServiceUnavailableResult;
import academy.pocu.comp2500.lab10.UnauthorizedResult;
import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.Rating;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Program {

    public static void main(String[] args) {
        User user0 = new User("user0", "userpw0");
        User user1 = new User("user1", "userpw1");
        User user2 = new User("user2", "userpw2");

        Request request0 = new Request("Movie 0");
        Request request1 = new Request("Movie 1");
        Request request2 = new Request("Movie 2");
        Request request3 = new Request("Unknown Movie");
        Request request4 = new Request("Unknown Movie");

        request0.setUser(user0);
        request1.setUser(user1);
        request2.setUser(user2);
        request3.setUser(user0); // authorized
        request4.setUser(user2); // unauthorized

        Movie movie0 = new Movie("Movie 0", Rating.R, 180);
        Movie movie1 = new Movie("Movie 1", Rating.PG, 60);
        Movie movie2 = new Movie("Movie 2", Rating.PG13, 70);

        MovieStore movieStore = new MovieStore();
        movieStore.add(movie0);
        movieStore.add(movie1);
        movieStore.add(movie2);

        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        OffsetDateTime startDateTime = now.plusSeconds(5);
        OffsetDateTime endDateTime = startDateTime.plusHours(1);
        MaintenanceMiddleware maintenanceMiddleware = new MaintenanceMiddleware(movieStore, startDateTime);

        HashSet<User> authorizedUserSet = new HashSet<>();
        authorizedUserSet.add(user0);
        authorizedUserSet.add(user1);
        AuthorizationMiddleware authorizationMiddleware = new AuthorizationMiddleware(maintenanceMiddleware, authorizedUserSet);

        CacheMiddleware cacheMiddleware = new CacheMiddleware(authorizationMiddleware, 2);

        ResultBase result = cacheMiddleware.handle(request2);
        ResultValidator validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.UNAUTHORIZED));

        result = cacheMiddleware.handle(request3);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.NOT_FOUND));

        result = cacheMiddleware.handle(request4);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.UNAUTHORIZED));

        result = cacheMiddleware.handle(request0);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.OK));

        result = cacheMiddleware.handle(request0);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.NOT_MODIFIED));
        assert (((CachedResult) result).getExpiryCount() == 1);

        result = cacheMiddleware.handle(request1);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.OK));

        result = cacheMiddleware.handle(request1);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.NOT_MODIFIED));
        assert (((CachedResult) result).getExpiryCount() == 1);

        result = cacheMiddleware.handle(request0);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.OK));

        result = cacheMiddleware.handle(request1);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.OK));

        result = cacheMiddleware.handle(request0); // remove cache
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.NOT_MODIFIED));
        assert (((CachedResult) result).getExpiryCount() == 1);

        result = cacheMiddleware.handle(request1); // remove cache
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.NOT_MODIFIED));
        assert (((CachedResult) result).getExpiryCount() == 1);

        sleep(5); // maintenance

        result = cacheMiddleware.handle(request2);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.UNAUTHORIZED));

        result = cacheMiddleware.handle(request3);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

        result = cacheMiddleware.handle(request4);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.UNAUTHORIZED));

        result = cacheMiddleware.handle(request0);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

        result = cacheMiddleware.handle(request0);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

        result = cacheMiddleware.handle(request1);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

        result = cacheMiddleware.handle(request1);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

        result = cacheMiddleware.handle(request0);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

        result = cacheMiddleware.handle(request1);
        validator = new ResultValidator(result);
        assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));



        System.out.println("No assert!");
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}