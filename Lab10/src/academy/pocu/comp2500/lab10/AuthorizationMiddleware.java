package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;

public class AuthorizationMiddleware extends HandlerManager implements IRequestHandler {

    private HashSet<User> users;
    private IRequestHandler next;
    private ResultBase result;

    public AuthorizationMiddleware(IRequestHandler next, HashSet<User> users) {
        this.next = next;
        this.users = users;
    }
    @Override
    public ResultBase handle(Request request) {

        if (!users.contains(request.getUser())) {
            super.handler = this;
            super.request = request;

            ResultBase result = new UnauthorizedResult();
            super.result = result;

            return result;
        } else {
            return next.handle(request);
        }
    }
}
