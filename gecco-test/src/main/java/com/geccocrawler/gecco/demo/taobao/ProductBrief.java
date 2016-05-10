package com.geccocrawler.gecco.demo.taobao;

import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.spider.HtmlBean;

public class ProductBrief implements HtmlBean {

	private static final long serialVersionUID = -4L;

	@JSONPath("$.itemlist")
	private String itemlist;

	public String getItemlist() {
		return itemlist;
	}

	public void setItemlist(String itemlist) {
		this.itemlist = itemlist;
	}

}
