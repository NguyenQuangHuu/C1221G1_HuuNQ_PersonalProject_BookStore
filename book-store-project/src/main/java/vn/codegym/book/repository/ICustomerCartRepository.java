package vn.codegym.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.book.model.Customer;

public interface ICustomerCartRepository extends JpaRepository<Customer,Integer> {
}
