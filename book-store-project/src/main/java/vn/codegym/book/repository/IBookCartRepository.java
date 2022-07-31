package vn.codegym.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.book.model.BookCart;

public interface IBookCartRepository extends JpaRepository<BookCart,Integer> {
}
