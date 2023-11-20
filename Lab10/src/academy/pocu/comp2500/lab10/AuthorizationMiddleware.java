package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;

public class AuthorizationMiddleware implements IRequestHandler {

    private HashSet<User> users;
    private IRequestHandler next;

    public AuthorizationMiddleware(IRequestHandler next, HashSet<User> users) {
        this.next = next;
        this.users = users;
    }
    @Override
    public ResultBase handle(Request request) {
        if (!users.contains(request.getUser())) {
            return new UnauthorizedResult();
        } else {
            return next.handle(request);
        }
    }
}
