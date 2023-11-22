package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;
import java.util.HashMap;

public class HandlerManager {
    private static HandlerManager instance;
    private HashMap<ResultBase, Request> results;

    private HandlerManager() {
        results = new HashMap<>();
    }
    public static HandlerManager getInstance() {
        if (instance == null) {
            instance = new HandlerManager();
        }
        return instance;
    }
    public HashMap<ResultBase, Request> getRequests() {
        return results;
    }

}
