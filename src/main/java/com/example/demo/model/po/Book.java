package com.example.demo.model.po;

import lombok.Data;

/**
 * @Author: 青菜
 * @Date: 2019/5/13 下午4:07
 * @Description: book
 * @Version 1.0
 */
@Data
public class Book {

    private String bookName;

    private String author;

    public Book() {
    }

    public Book(String bookName, String author) {

        this.bookName = bookName;
        this.author = author;
    }
}
