package org.millie.www.MillieServer.book;

import lombok.RequiredArgsConstructor;
import org.millie.www.MillieServer.common.dto.ApiResponse;
import org.millie.www.MillieServer.common.httpmessage.SuccessMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {

    private static final String CUSTOM_AUTH_ID = "X-AUTH-ID";
    private final BookService bookService;

    @PostMapping("/books/{bookId}/archive")
    public ApiResponse<Void> addBookToArchive(@PathVariable Long bookId, @RequestHeader(CUSTOM_AUTH_ID) Long userId) {
        bookService.addBookToArchive(bookId, userId);
        return ApiResponse.success(SuccessMessage.USER_ADD_BOOK_SUCCESS);
    }

}
