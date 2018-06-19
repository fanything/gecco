package com.ibook.www.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fanmingxin
 * @description
 * @Date 2018/6/19
 */
public class Node implements Serializable {

    private long id;

    private String name;

    private long bookId;

    private String content;

    private Date createTime;

    private int count;

    public Node() {
    }

    public Node(long id, long bookId, String content) {
        this.id = id;
        this.bookId = bookId;
        this.content = content;
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

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
