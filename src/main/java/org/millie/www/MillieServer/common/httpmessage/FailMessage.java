package org.millie.www.MillieServer.common.httpmessage;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum FailMessage {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "000000"),
    SAME_BOOK_UPDATE_EXCEPTION(HttpStatus.BAD_REQUEST, "000002"),
    MEMBER_NOT_FOUND_EXCEPTION(HttpStatus.UNAUTHORIZED, "000003");


    private HttpStatus status;
    private String message;
}
