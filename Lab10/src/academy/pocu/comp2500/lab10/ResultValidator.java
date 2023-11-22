package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.time.OffsetDateTime;

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

        switch (code) {
            case OK:
                break;
            case NOT_FOUND:
                break;
            case SERVICE_UNAVAILABLE:
                if (((ServiceUnavailableResult) resultBase).getEndDateTime().isBefore(OffsetDateTime.now())) {
                    return false;
                }
                return true;
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
