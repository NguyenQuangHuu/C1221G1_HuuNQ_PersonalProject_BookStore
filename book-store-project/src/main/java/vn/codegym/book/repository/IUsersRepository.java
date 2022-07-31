package vn.codegym.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.book.model.Users;

public interface IUsersRepository extends JpaRepository<Users,Integer> {
    Users findUsersByUsername(String username);
}
