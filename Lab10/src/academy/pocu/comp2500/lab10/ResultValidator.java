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
        if (resultBase.getCode() != code) {
            return false;
        }

        /*switch (code) {
            case OK:
                if (resultBase instanceof OkResult) {
                    return true;
                }
                break;
            case NOT_FOUND:
                if (resultBase instanceof NotFoundResult) {
                    return true;
                }
                break;
            case SERVICE_UNAVAILABLE:
                if (resultBase instanceof ServiceUnavailableResult) {
                    return true;
                }
                break;
            case UNAUTHORIZED:
                if (resultBase instanceof UnauthorizedResult) {
                    return true;
                }
                break;
            case NOT_MODIFIED:
                if (resultBase instanceof CachedResult) {
                    return true;
                }
                break;
            default:
                return false;
        }*/
        return true;
    }
}
