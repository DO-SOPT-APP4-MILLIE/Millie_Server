package org.millie.www.MillieServer.book;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.millie.www.MillieServer.common.exception.BusinessException;
import org.millie.www.MillieServer.common.httpmessage.ExceptionMessage;
import org.millie.www.MillieServer.user.User;
import org.millie.www.MillieServer.user.UserBook;
import org.millie.www.MillieServer.user.UserBookJpaRepository;
import org.millie.www.MillieServer.user.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
