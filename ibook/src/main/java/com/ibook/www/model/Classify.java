package com.ibook.www.model;

import java.io.Serializable;

/**
 * @author fanmingxin
 * @description
 * @Date 2018/6/19
 */
public class Classify implements Serializable {

    private long id;

    private long channelId;

    private String name;

    private String href;

    public Classify() {
    }

    public Classify(long id, long channelId, String name, String href) {
        this.id = id;
        this.channelId = channelId;
        this.name = name;
        this.href = href;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
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
