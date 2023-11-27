package org.millie.www.MillieServer.user.repository;

import org.millie.www.MillieServer.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
