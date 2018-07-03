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
@Gecco(matchUrl = "https://www.miaobige.com/read/{bookId}/{page}/", timeout = 10000,pipelines = { "consolePipeline", "nodeListPipeline" })
public class NodeListPage implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@RequestParameter
	private long bookId;

	@RequestParameter
	private int page;

	@Href
	@HtmlField(cssPath = "#readerlists > ul:eq(0) > li > a")
	private List<String> nodeList;

	@Href
	@HtmlField(cssPath = ".pages > a")
	private List<String> pageList;

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	@Request
	private HttpRequest request;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<String> getPageList() {
		return pageList;
	}

	public void setPageList(List<String> pageList) {
		this.pageList = pageList;
	}

	public List<String> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<String> nodeList) {
		this.nodeList = nodeList;
	}
}
