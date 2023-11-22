package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {

    private ResultBase resultBase;

    public ResultValidator(ResultBase resultBase) {
        this.resultBase = resultBase;
    }

    public boolean isValid(ResultCode code) {
        boolean result = resultBase != null && resultBase.getCode() == code;

        if (!result) {
            resultBase = null;
        }

        if (code == ResultCode.OK || code == ResultCode.NOT_FOUND) {

            Request request = HandlerManager.getInstance().getRequests().get(resultBase);

            MovieStore store = new MovieStore();
            if (store.handle(request).getCode() == code) {
                return true;
            }
        }

        switch (code) {
            case OK:
                break;
            case NOT_FOUND:
                break;
            case SERVICE_UNAVAILABLE:
                break;
            case UNAUTHORIZED:
                break;
            case NOT_MODIFIED:
                break;
            default:
                return false;
        }

        return result;

    }
}
