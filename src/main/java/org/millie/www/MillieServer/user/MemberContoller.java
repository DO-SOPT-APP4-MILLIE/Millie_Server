package org.millie.www.MillieServer.book;

import lombok.RequiredArgsConstructor;
import org.millie.www.MillieServer.book.dto.response.PostListGetResponse;
import org.millie.www.MillieServer.common.dto.ApiResponse;
import org.millie.www.MillieServer.common.httpmessage.SuccessMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/me")
@RequiredArgsConstructor
public class MemberContoller {


    private static final String CUSTOM_AUTH_ID = "X-AUTH-ID";
    private final BookService bookService;


    @GetMapping("/collections")
    public ApiResponse<List<PostListGetResponse>> getUserBookList (@RequestHeader(CUSTOM_AUTH_ID) Long userId) {
        List<PostListGetResponse> list = bookService.getUserBookList(userId);
        return ApiResponse.success(SuccessMessage.USER_BOOK_LIST_SEARCH_SUCCESS, list);
    }
}


