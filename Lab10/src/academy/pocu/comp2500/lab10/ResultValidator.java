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
        //Exception e = new Exception();
        try {
            switch (code) {
                case OK:
                    resultBase = (OkResult) resultBase;
                    break;
                case NOT_FOUND:
                    resultBase = (NotFoundResult) resultBase;
                    break;
                case SERVICE_UNAVAILABLE:
                    resultBase = (ServiceUnavailableResult) resultBase;
                    break;
                case UNAUTHORIZED:
                    resultBase = (UnauthorizedResult) resultBase;
                    break;
                case NOT_MODIFIED:
                    resultBase = (NotFoundResult) resultBase;
                    break;
                default:
                    return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
