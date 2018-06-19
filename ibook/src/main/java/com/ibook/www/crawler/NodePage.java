package com.ibook.www.crawler;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Html;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @Description :
 * @FileName: BigPic.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月29日 下午3:59:19
 * @Version:V1.00
 */
@Gecco(matchUrl = "https://www.miaobige.com/read/{bookId}/{id}.html", pipelines = { "consolePipeline", "nodePipeline" })
public class NodePage implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@RequestParameter
	private long bookId;

	@RequestParameter
	private long id;

	@Html
	@HtmlField(cssPath = ".title > h1")
	private String name;

	@Html
	@HtmlField(cssPath = "#content")
	private String content;

	@Html
	@HtmlField(cssPath = ".title > span:eq(2)")
	private String count;


	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
