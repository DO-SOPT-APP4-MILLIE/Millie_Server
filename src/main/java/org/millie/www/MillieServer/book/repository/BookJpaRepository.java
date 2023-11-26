package org.millie.www.MillieServer.book.repository;

import org.millie.www.MillieServer.book.domain.Book;
import org.millie.www.MillieServer.common.exception.BusinessException;
import org.millie.www.MillieServer.common.httpmessage.ExceptionMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
    default Book findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new BusinessException(ExceptionMessage.BOOK_NOT_FOUND_EXCEPTION));
    }
}
