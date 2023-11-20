package org.millie.www.MillieServer.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
        @Id @GeneratedValue
        @Column(name = "user_id")
        private Long id;

        private String username;

        @OneToMany
        private List<UserBook> userBookList = new ArrayList();
}
