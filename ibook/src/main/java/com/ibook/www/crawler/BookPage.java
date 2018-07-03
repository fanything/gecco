package com.ibook.www.crawler;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @Description :
 * @FileName: BigPic.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月29日 下午3:59:19
 * @Version:V1.00
 */
@Gecco(matchUrl = "https://www.miaobige.com/book/{id}/{channelId}_{classifyId}",timeout = 10000, pipelines = { "consolePipeline", "bookPipeline" })
public class BookPage implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@RequestParameter
	private long id;

	@RequestParameter
	private long channelId;

	@RequestParameter
	private long classifyId;

	@Html
	@HtmlField(cssPath = ".booktitle > h1")
	private String name;

	@Html
	@HtmlField(cssPath = "#author > a")
	private String author;

	@Html
	@HtmlField(cssPath = ".count > ul > li:eq(10) > span")
	private String wcount;

	@Html
	@HtmlField(cssPath = "#bookintro")
	private String intro;

	@Image
	@HtmlField(cssPath = "#bookimg")
	private Picture img;

	@Href
	@HtmlField(cssPath = ".newrap > strong > a")
	private String url;
	

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

	public String getWcount() {
		return wcount;
	}

	public void setWcount(String wcount) {
		this.wcount = wcount;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Picture getImg() {
		return img;
	}

	public void setImg(Picture img) {
		this.img = img;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

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
}
