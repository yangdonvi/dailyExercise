package com.donvi.entity;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @Description:
 * @Author: yangdongwei
 * @CreateDate: 2019/10/19
 * @Version: 1.0
 */
public class Book {

    private long id;

    @NotEmpty(message = "bookName不能为空")
    private String bookName;

    @NotNull(message = "bookIsbn不能为空")
    private String bookIsbn;

    @DecimalMin(value = "0.1", message = "单价最低为0.1")
    private Double price;

    @NotEmpty(message = "authors集合不能为空")
    private List<String> authors;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", price=" + price +
                ", authors=" + authors +
                '}';
    }
}
