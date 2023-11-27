package org.millie.www.MillieServer.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookGetResponse {
    private Long id;
    private String imageUrl;

    static public BookGetResponse of(Long id, String imgUrl){
        return new BookGetResponse(id,imgUrl);
    }
}
