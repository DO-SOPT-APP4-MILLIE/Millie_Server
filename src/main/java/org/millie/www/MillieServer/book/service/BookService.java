package org.millie.www.MillieServer.book.service;

import lombok.RequiredArgsConstructor;
import org.millie.www.MillieServer.book.dto.response.BookSimpleResponse;
import org.millie.www.MillieServer.book.repository.BookJpaRepository;
import org.millie.www.MillieServer.book.domain.Book;
import org.millie.www.MillieServer.common.exception.BusinessException;
import org.millie.www.MillieServer.common.httpmessage.ExceptionMessage;
import org.millie.www.MillieServer.user.domain.User;
import org.millie.www.MillieServer.user.domain.UserBook;
import org.millie.www.MillieServer.user.repository.UserBookJpaRepository;
import org.millie.www.MillieServer.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookJpaRepository bookRepository;
    private final UserJpaRepository userRepository;
    private final UserBookJpaRepository userBookRepository;
    @Transactional
    public void addBookToArchive(Long bookId, Long userId) {

        User findUser = userRepository.findById(userId).orElseThrow(() -> new BusinessException(ExceptionMessage.MEMBER_NOT_FOUND_EXCEPTION));
        Book findBook = bookRepository.findById(bookId).orElseThrow(() -> new BusinessException(ExceptionMessage.BOOK_NOT_FOUND_EXCEPTION));

        if(userBookRepository.findByUser_idAndBook_id(userId, bookId) != null)
            throw new BusinessException(ExceptionMessage.SAME_BOOK_UPDATE_EXCEPTION);
        UserBook userBook = UserBook.createUserBook(findUser, findBook);

        userBookRepository.save(userBook);


    }

    public List<BookSimpleResponse> getBookList() {
        return bookRepository.findAll().stream().map(BookSimpleResponse::of).toList();
    }
}
