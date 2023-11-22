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
        ResultCode currCode = resultBase.getCode();
        if (currCode != code) {
            return false;
        }

        MovieStore store = new MovieStore();

        switch (code) {
            case OK:
                String title = ((OkResult) resultBase).getMovie().getTitle();
                if (store.handle(new Request(title)).getCode() == code) {
                    return true;
                } else {
                    return false;
                }
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


        return true;
    }
}
