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
        if (!(resultBase instanceof OkResult || resultBase instanceof NotFoundResult ||
            resultBase instanceof CachedResult || resultBase instanceof ServiceUnavailableResult ||
            resultBase instanceof UnauthorizedResult)) {
            return false;
        }

        return this.resultBase.getCode() == code;
    }
}
