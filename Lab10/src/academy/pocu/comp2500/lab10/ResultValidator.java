package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {

    private final ResultBase resultBase;

    public ResultValidator(ResultBase resultBase) {
        this.resultBase = resultBase;
    }

    public boolean isValid(ResultCode code) {
        return this.resultBase.getCode() == code;
    }
}
