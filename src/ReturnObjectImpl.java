public class ReturnObjectImpl implements ReturnObject {
    private ErrorMessage errorMessage = null;

    private Object returnValue = null;

    public ReturnObjectImpl(Object returnValue) {
        this.errorMessage = null;
        this.returnValue = returnValue;
    }

    public ReturnObjectImpl(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
        this.returnValue = null;
    }

    @Override
    public boolean hasError() {
        return errorMessage != null;
    }

    @Override
    public ErrorMessage getError() {
        if (hasError() == false) {
            return ErrorMessage.NO_ERROR;
        }

        return errorMessage;
    }

    @Override
    public Object getReturnValue() {
        if (hasError()) {
            return null;
        }

        return returnValue;
    }
}