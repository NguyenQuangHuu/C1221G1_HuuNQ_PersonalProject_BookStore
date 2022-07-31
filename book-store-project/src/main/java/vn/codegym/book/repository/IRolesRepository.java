package vn.codegym.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.book.model.Roles;
import vn.codegym.book.model.Users;

public interface IRolesRepository extends JpaRepository<Roles,Integer> {
}
