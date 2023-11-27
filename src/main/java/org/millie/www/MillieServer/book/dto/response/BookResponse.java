package org.millie.www.MillieServer.book.dto.response;

import org.millie.www.MillieServer.book.domain.Book;

public record BookResponse(
        Long id,
        String title,
        String author,
        String thumbnail,
        Integer archivedCount,
        Integer postCount,
        Integer reviewCount,
        String Description){
    public static BookResponse of (Book book){
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getImageUrl(),
                book.getArchivedCount(),
                book.getPostCount(),
                book.getReviewCount(),
                book.getDescription()
        );
    }
}
