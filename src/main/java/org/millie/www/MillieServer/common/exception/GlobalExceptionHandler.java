package org.millie.www.MillieServer.common.exception;

import org.millie.www.MillieServer.common.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse> handleBusinessException(BusinessException e) {
        return ResponseEntity.status(e.getHttpStatusCode())
                .body(ApiResponse.fail(e.getExceptionMessage()));
    }

}
