package vn.codegym.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.book.model.Book;
import vn.codegym.book.service.IBookService;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/books")
public class BookRestController {
    @Autowired
    private IBookService bookService;
    @GetMapping("")
    public ResponseEntity<Page<Book>> bookPage(@RequestParam Optional<String> name, @PageableDefault(value = 12) Pageable pageable){
            String nameQuery = name.orElse(null);
            Page<Book> bookPage = this.bookService.findAllBook(nameQuery,pageable);
            return new ResponseEntity<>(bookPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Integer id){
        Book book = this.bookService.findBookById(id);
        if(book==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book,HttpStatus.OK);
    }
}
