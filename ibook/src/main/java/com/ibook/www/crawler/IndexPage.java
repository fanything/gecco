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
@Gecco(matchUrl = "https://www.miaobige.com/shuku/", pipelines = { "consolePipeline", "indexPipeline" })
public class IndexPage implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Href
	@HtmlField(cssPath=".tag-group > dl:eq(0) > dd > a")
	private List<ClassifyItem> itemList;

	@Request
	private HttpRequest request;

	public List<ClassifyItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<ClassifyItem> itemList) {
		this.itemList = itemList;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}
}
