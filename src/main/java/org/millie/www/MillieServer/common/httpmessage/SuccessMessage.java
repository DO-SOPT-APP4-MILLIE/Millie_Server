package org.millie.www.MillieServer.common.httpmessage;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessMessage {

    BEST_BOOK_LIST_SEARCH_SUCCESS(HttpStatus.OK, "000001"),
    BOOK_SEARCH_SUCCESS(HttpStatus.OK, "000001"),
    USER_ADD_BOOK_SUCCESS(HttpStatus.CREATED, "000001"),
    USER_BOOK_LIST_SEARCH_SUCCESS(HttpStatus.OK, "000001");

    private final HttpStatus status;
    private final String message;
}
