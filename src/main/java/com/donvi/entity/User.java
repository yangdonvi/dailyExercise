package com.donvi.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description:
 * @Author: yangdongwei
 * @CreateDate: 2019/10/19
 * @Version: 1.0
 */
public class User {

    @Length(min = 8, max = 16)
    private String userName;

    @Length(min = 10, max = 18)
    private String userPswd;

    @Valid
    private List<Book> books;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPswd='" + userPswd + '\'' +
                ", books=" + books +
                '}';
    }
}
