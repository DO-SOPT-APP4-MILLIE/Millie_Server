package org.millie.www.MillieServer.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.millie.www.MillieServer.book.Book;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserBook {
        @Id @GeneratedValue
        @Column(name = "user_book_id")
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "book_id")
        private Book book;

        private UserBook(User user, Book book) {
                this.user = user;
                this.book = book;
        }

        public static UserBook createUserBook(User findUser, Book findBook) {
                return new UserBook(findUser, findBook);
        }
}
