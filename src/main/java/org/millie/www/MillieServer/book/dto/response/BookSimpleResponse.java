package org.millie.www.MillieServer.book.dto.response;

import org.millie.www.MillieServer.book.domain.Book;

public record BookSimpleResponse(
        Long id,
        String title,
        String thumbnail,
        String author,
        Integer completionRate,
        Integer readingTime,
        Integer rankChange) {
    public static BookSimpleResponse of(Book book) {
        return new BookSimpleResponse(
                book.getId(),
                book.getTitle(),
                book.getImageUrl(),
                book.getAuthor(),
                book.getCompletionRate(),
                book.getReadingTime(),
                book.getRankChange()
        );
    }
}
