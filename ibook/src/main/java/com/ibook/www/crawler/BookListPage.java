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
@Gecco(matchUrl = "https://www.miaobige.com/shuku/{channelId}_3_0_{classifyId}_0_1", timeout = 10000,pipelines = { "consolePipeline", "bookListPipeline" })
public class BookListPage implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@RequestParameter
	private long channelId;

	@RequestParameter
	private long classifyId;

	@Href
	@HtmlField(cssPath = ".booklists > tbody > tr > td:eq(1) > a")
	private List<String> bookUrl;
	

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	@Request
	private HttpRequest request;

	public long getChannelId() {
		return channelId;
	}

	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public long getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(long classifyId) {
		this.classifyId = classifyId;
	}

	public List<String> getBookUrl() {
		return bookUrl;
	}

	public void setBookUrl(List<String> bookUrl) {
		this.bookUrl = bookUrl;
	}
}
