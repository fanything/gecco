package com.ibook.www.model;

import java.io.Serializable;

/**
 * @author fanmingxin
 * @description
 * @Date 2018/6/19
 */
public class Channel implements Serializable {

    private long id;

    private String name;

    private String href;

    public Channel() {
    }

    public Channel(long id, String name, String href) {
        this.id = id;
        this.name = name;
        this.href = href;
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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
