package ru.vladislavduma.invstocksservice.ErrorHandling;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TickerNotFoundException extends RuntimeException {

    private String errorCode;

    public TickerNotFoundException() {
        super("Error! Ticker Not Found!");
        setErrorCode("TCKR_NOT_FOUND");
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
