package org.millie.www.MillieServer.book.repository;

import org.millie.www.MillieServer.book.Category;
import org.millie.www.MillieServer.book.domain.Book;
import org.millie.www.MillieServer.common.exception.BusinessException;
import org.millie.www.MillieServer.common.httpmessage.ExceptionMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByCategory(Category category);

    default Book findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new BusinessException(ExceptionMessage.BOOK_NOT_FOUND_EXCEPTION));
    }
}
