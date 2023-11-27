package org.millie.www.MillieServer.book.service;

import lombok.RequiredArgsConstructor;
import org.millie.www.MillieServer.book.Category;
import org.millie.www.MillieServer.book.dto.response.BookGetResponse;
import org.millie.www.MillieServer.book.dto.response.BookResponse;
import org.millie.www.MillieServer.book.dto.response.BookSimpleResponse;
import org.millie.www.MillieServer.book.dto.response.PostListGetResponse;
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

import java.util.ArrayList;
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
        Book findBook = bookRepository.findByIdOrThrow(bookId);

        if(userBookRepository.findByUser_idAndBook_id(userId, bookId) != null)
            throw new BusinessException(ExceptionMessage.SAME_BOOK_UPDATE_EXCEPTION);
        UserBook userBook = UserBook.createUserBook(findUser, findBook);

        userBookRepository.save(userBook);


    }

    public List<BookSimpleResponse> getBookList() {
        return bookRepository.findAll().stream().map(BookSimpleResponse::of).toList();
    }

    public BookResponse getBook(Long bookId) {
        Book book = bookRepository.findByIdOrThrow(bookId);
        return BookResponse.of(book);
    }

    public List<PostListGetResponse> getUserBookList(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new BusinessException(ExceptionMessage.MEMBER_NOT_FOUND_EXCEPTION));
        //유저가 소유한 책
        List<UserBook> userBookList = userBookRepository.findAllByUser_id(userId);
        List<Book> findBooks = new ArrayList<>();//user의 책
        //findBooks에 유저가 소유한 책의 리스트 넣음
        for (UserBook userBook : userBookList) {
            findBooks.add(bookRepository.findById(userBook.getBook().getId()).get());
        }

        //유저가 가진 책들의 카테고리는 userBookCategory
        List<Category> userBookCategory = new ArrayList<>();
        for(Book book : findBooks) {
            if(!userBookCategory.contains(book.getCategory())) {
                userBookCategory.add(book.getCategory());
            }
        }

        //유저가 가진 책의 카테고리들에 대해 response 생성
        List<PostListGetResponse> response = new ArrayList<>();
        for(Category category : userBookCategory){
            response.add(getPostListGetResponseDTO(category, userId));
        }
        return response;
    }

    //카테고리 넣으면 카테고리에 해당하는, 유저가 가진 책들의 리스트를 넣어줌
    private PostListGetResponse getPostListGetResponseDTO(Category category, Long userId){

        //findBooks에 유저가 소유한 책
        List<UserBook> userBookList = userBookRepository.findAllByUser_id(userId);
        List<Book> findBooks = new ArrayList<>();//user의 책
        for (UserBook userBook : userBookList) {
            findBooks.add(bookRepository.findById(userBook.getBook().getId()).get());
        }

        //모든 책중 해당 category책 찾음
        List<BookGetResponse> books = new ArrayList<>();
        List<Book> bookList = bookRepository.findAllByCategory(category);
        for(Book book : bookList){
            if(findBooks.contains(book))//유저가 소유한 책들중에 category에 맞는 책이 있다면
                books.add(BookGetResponse.of(book.getId(),book.getImageUrl()));
        }
        return PostListGetResponse.of(category, books);
    }
}
