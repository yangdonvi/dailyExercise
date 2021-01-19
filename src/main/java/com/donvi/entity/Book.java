package com.donvi.entity;


import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;


/**
 * @Description:
 * @Author: yangdongwei
 * @CreateDate: 2019/10/19
 * @Version: 1.0
 */
@Data
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

    public Book(long id, @NotEmpty(message = "bookName不能为空") String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public Book() {
    }


}
