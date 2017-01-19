package by.natashkinsasha.api.Exception;

import by.natashkinsasha.api.Exception.ApiException;

public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
