package com.ibook.www.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fanmingxin
 * @description
 * @Date 2018/6/19
 */
public class Book implements Serializable {

    private long id;

    private String name;

    private String author;

    private Date createTime;

    public Book() {
    }

    public Book(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
