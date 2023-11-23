package org.millie.www.MillieServer.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.millie.www.MillieServer.common.httpmessage.FailMessage;
import org.millie.www.MillieServer.common.httpmessage.SuccessMessage;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T>{

    private final int code;
    private final String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> ApiResponse<T> success(SuccessMessage success) {
        return new ApiResponse(success.getStatus().value(), success.getMessage());
    }

    public static <T> ApiResponse<T> success(SuccessMessage success, T data) {
        return new ApiResponse(success.getStatus().value(), success.getMessage(), data);
    }

    public static <T> ApiResponse<T> fail(FailMessage fail) {
        return new ApiResponse(fail.getStatus().value(), fail.getMessage());
    }
}
