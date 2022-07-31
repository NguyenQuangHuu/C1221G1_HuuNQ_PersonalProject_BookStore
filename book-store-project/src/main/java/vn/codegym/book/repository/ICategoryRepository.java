package vn.codegym.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.book.model.Book;
import vn.codegym.book.model.Category;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
