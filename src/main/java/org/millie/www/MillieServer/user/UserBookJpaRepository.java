package org.millie.www.MillieServer.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBookJpaRepository extends JpaRepository<UserBook, Long> {

    UserBook findByUser_idAndBook_id(Long userId, Long bookId);
}
