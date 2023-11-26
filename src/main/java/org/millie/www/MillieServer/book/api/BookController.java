package org.millie.www.MillieServer.book.api;

import lombok.RequiredArgsConstructor;
import org.millie.www.MillieServer.book.dto.response.BookSimpleResponse;
import org.millie.www.MillieServer.book.service.BookService;
import org.millie.www.MillieServer.common.dto.ApiResponse;
import org.millie.www.MillieServer.common.httpmessage.SuccessMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private static final String CUSTOM_AUTH_ID = "X-AUTH-ID";
    private final BookService bookService;

    @PostMapping("/{bookId}/archive")
    public ApiResponse<Void> addBookToArchive(@PathVariable Long bookId, @RequestHeader(CUSTOM_AUTH_ID) Long userId) {
        bookService.addBookToArchive(bookId, userId);
        return ApiResponse.success(SuccessMessage.USER_ADD_BOOK_SUCCESS);
    }

    @GetMapping
    public ApiResponse<List<BookSimpleResponse>> getBookList() {
        List<BookSimpleResponse> books = bookService.getBookList();
        return ApiResponse.success(SuccessMessage.OK, books);

    }

}
