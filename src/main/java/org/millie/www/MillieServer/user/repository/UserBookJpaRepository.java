package org.millie.www.MillieServer.user.repository;

import org.millie.www.MillieServer.user.domain.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBookJpaRepository extends JpaRepository<UserBook, Long> {

    UserBook findByUser_idAndBook_id(Long userId, Long bookId);
    List<UserBook> findAllByUser_id(Long userId);
}
