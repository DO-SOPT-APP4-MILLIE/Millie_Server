package org.millie.www.MillieServer.common.exception;

import lombok.Getter;
import org.millie.www.MillieServer.common.httpmessage.ExceptionMessage;

@Getter
public class BusinessException extends RuntimeException {

    private final ExceptionMessage exceptionMessage;

    public BusinessException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }

    public int getHttpStatusCode() {
        return exceptionMessage.getStatus().value();
    }
}
