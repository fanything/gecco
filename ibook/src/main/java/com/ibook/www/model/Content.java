package com.ibook.www.model;

import java.io.Serializable;

/**
 * @author fanmingxin
 * @description
 * @Date 2018/6/19
 */
public class Content implements Serializable {

    private long id;

    private long nid;

    private String content;

    public Content() {
    }

    public Content(long nid,String content) {
        this.nid = nid;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getNid() {
        return nid;
    }

    public void setNid(long nid) {
        this.nid = nid;
    }
}
