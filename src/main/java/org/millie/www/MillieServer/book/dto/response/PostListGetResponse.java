package org.millie.www.MillieServer.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.millie.www.MillieServer.book.Category;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostListGetResponse {
    private Category category;
    private List<BookGetResponse> book;

    public static PostListGetResponse of(Category category, List<BookGetResponse> bookGetResponseList){
        return new PostListGetResponse(category, bookGetResponseList);
    }


}
