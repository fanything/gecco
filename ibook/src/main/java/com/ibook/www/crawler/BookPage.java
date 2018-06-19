package com.ibook.www.crawler;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * @Description :
 * @FileName: BigPic.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月29日 下午3:59:19
 * @Version:V1.00
 */
@Gecco(matchUrl = "https://www.miaobige.com/read/{id}/{page}/", pipelines = { "consolePipeline", "bookPipeline" })
public class BookPage implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@RequestParameter
	private long id;

	@Html
	@HtmlField(cssPath = "#smallcons > h1")
	private String name;

	@Html
	@HtmlField(cssPath = "#smallcons > span > a")
	@RequestParameter
	private String author;
	
	@Href
	@HtmlField(cssPath="#readerlists > ul > li > a")
	private List<String> nodeList;

	@Href
	@HtmlField(cssPath=".pages > a")
	private List<String> pageList;

	public List<String> getPageList() {
		return pageList;
	}

	public void setPageList(List<String> pageList) {
		this.pageList = pageList;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	@Request
	private HttpRequest request;


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

	public List<String> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<String> nodeList) {
		this.nodeList = nodeList;
	}
}
