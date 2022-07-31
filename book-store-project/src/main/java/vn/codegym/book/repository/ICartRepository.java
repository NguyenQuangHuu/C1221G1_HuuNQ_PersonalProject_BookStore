package vn.codegym.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.book.model.Author;
import vn.codegym.book.model.Cart;

public interface ICartRepository extends JpaRepository<Cart,Integer> {
}
