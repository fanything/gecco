package com.ibook.www.crawler;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @Description :
 * @FileName: Picture.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月29日 上午11:48:52
 * @Version:V1.00
 */
public class Picture implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Attr("alt")
	@HtmlField(cssPath = "img")
	private String alt;

	@Attr("src")
	@HtmlField(cssPath = "img")
	private String url;

	@Attr("width")
	@HtmlField(cssPath = "img")
	private String width;

	@Attr("height")
	@HtmlField(cssPath = "img")
	private String height;

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
}
