package org.millie.www.MillieServer.book.repository;

import org.millie.www.MillieServer.book.Category;
import org.millie.www.MillieServer.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByCategory(Category category);
}
