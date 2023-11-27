package org.millie.www.MillieServer.book.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.millie.www.MillieServer.book.Category;
import org.millie.www.MillieServer.user.domain.UserBook;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
        @Id
        @GeneratedValue
        @Column(name = "book_id")
        private Long id;

        @OneToMany
        private List<UserBook> userBookList = new ArrayList<>();

        private String title;

        private String imageUrl;

        private String author;

        @Enumerated(EnumType.STRING)
        private Category category;

        private int completionRate;

        private int readingTime;

        private int archivedCount;

        private int postCount;

        private int reviewCount;

        private String description;



}
