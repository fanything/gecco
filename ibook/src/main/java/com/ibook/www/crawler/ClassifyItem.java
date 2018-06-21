package com.ibook.www.crawler;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @author fanmingxin
 * @description
 * @Date 2018/6/21
 */
public class ClassifyItem implements HtmlBean{

    private static final long serialVersionUID = 1L;

    @Href
    @HtmlField(cssPath = "a")
    private String href;

    @Text
    @HtmlField(cssPath = "a")
    private String name;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
