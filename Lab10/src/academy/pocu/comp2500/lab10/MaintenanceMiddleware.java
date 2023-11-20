package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.time.OffsetDateTime;

public class MaintenanceMiddleware implements IRequestHandler {

    private IRequestHandler movies;
    private OffsetDateTime startTime;

    public MaintenanceMiddleware(IRequestHandler movies, OffsetDateTime startTime) {
        this.movies = movies;
        this.startTime = startTime;
    }
    @Override
    public ResultBase handle(Request request) {
        OffsetDateTime now = OffsetDateTime.now();
        if (now.isAfter(startTime) && now.isBefore(startTime.plusHours(1))) {
            return new ServiceUnavailableResult(startTime, startTime.plusHours(1));
        } else {
            return movies.handle(request);
        }
    }
}
