package vn.codegym.book.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class BookCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cart_id",referencedColumnName = "id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name= "book_id",referencedColumnName = "id")
    private Book book;

    private Integer quantity;

    public BookCart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
