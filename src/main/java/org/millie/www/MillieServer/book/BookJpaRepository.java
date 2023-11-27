package org.millie.www.MillieServer.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByCategory(Category category);
}
