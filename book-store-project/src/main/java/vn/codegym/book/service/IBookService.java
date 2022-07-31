package vn.codegym.book.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import vn.codegym.book.model.Book;

public interface IBookService {
    Page<Book> findAllBook(String name,Pageable pageable);

    Book findBookById(Integer id);
}
