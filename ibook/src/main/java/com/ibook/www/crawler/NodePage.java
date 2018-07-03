package com.ibook.www.crawler;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @Description :
 * @FileName: BigPic.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月29日 下午3:59:19
 * @Version:V1.00
 */
@Gecco(matchUrl = "https://www.miaobige.com/read/{bookId}/{id}.html",timeout = 10000, pipelines = { "consolePipeline", "nodePipeline" })
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

	@Href
	@HtmlField(cssPath = ".jump > a:eq(0)")
	private String before;

	@Href
	@HtmlField(cssPath = ".jump > a:eq(4)")
	private String next;

	@Attr("content")
	@HtmlField(cssPath = "meta[name='keywords']")
	private String keywords;

	@Attr("content")
	@HtmlField(cssPath = "meta[name='description']")
	private String intro;


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

	public String getBefore() {
		if(this.before != null){
			this.before = this.before.substring(this.before.lastIndexOf("/")+1).replace(".html","").trim();
		}

		if("".equals(this.before)){
			return "0";
		}
		return this.before;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	public String getNext() {
		if(this.next != null){
			this.next = this.next.substring(this.next.lastIndexOf("/")+1).replace(".html","").trim();
		}

		if("".equals(this.next)){
			return "0";
		}
		return this.next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
}
