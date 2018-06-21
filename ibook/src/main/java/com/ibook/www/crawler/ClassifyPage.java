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
@Gecco(matchUrl = "https://www.miaobige.com/shuku/{ids}", pipelines = { "consolePipeline", "classifyPipeline" })
public class ClassifyPage implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@RequestParameter
	private String ids;

	@Href
	@HtmlField(cssPath=".tag-group > dl:eq(1) > dd > a")
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

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
}
