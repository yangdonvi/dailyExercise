package com.donvi;

import com.donvi.entity.Book;

import java.util.HashSet;
import java.util.Set;

public class test {

    public static void main(String[] args) {


        Book book1 = new Book(1L, "book1");
        Book book2 = new Book(1L, "book1");
        Set<Book> set = new HashSet<>();
        set.add(book1);
        set.add(book2);
        System.out.printf(String.valueOf(set.size()));
        System.out.println(book1.toString());
    }

}
