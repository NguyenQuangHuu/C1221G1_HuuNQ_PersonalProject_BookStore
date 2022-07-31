package vn.codegym.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.codegym.book.model.Book;
import vn.codegym.book.repository.IBookRepository;
import vn.codegym.book.service.IBookService;
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public Page<Book> findAllBook(String name,Pageable pageable) {
        if(name==null || name.equals("")){
            return this.iBookRepository.findAll(pageable);
        }
        return this.iBookRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Book findBookById(Integer id) {
        return this.iBookRepository.findById(id).orElse(null);
    }
}
