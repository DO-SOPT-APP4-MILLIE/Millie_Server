package org.millie.www.MillieServer.book.repository;

import org.millie.www.MillieServer.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
}
