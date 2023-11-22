package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;
import java.util.HashMap;

public class HandlerManager {

    protected IRequestHandler handler;
    protected Request request;
    protected ResultBase result;
    protected HashMap<ResultBase, HandlerManager> map = new HashMap<>();

    public IRequestHandler getHandlers() {
        return handler;
    }
    public Request getRequest() {
        return request;
    }
    public ResultBase getResult() {
        return result;
    }

}
