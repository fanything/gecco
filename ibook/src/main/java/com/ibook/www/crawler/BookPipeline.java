package com.ibook.www.crawler;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.ibook.www.Service.BookService;
import com.ibook.www.model.Book;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :
 * @Author :WeiHui.Zhang
 * @Data : 2016/3/30 11:06
 * @Version:1.0.0
 */
@Service
public class BookPipeline implements Pipeline<BookPage> {

	@Autowired
	private BookService bookService;

	@Override
	public void process(BookPage bean) {

		bookService.save(new Book(bean.getId(),bean.getName(),bean.getAuthor()));


		List<String> nodeList = bean.getNodeList();
		for (String url : nodeList) {
			//继续抓取详情页
			HttpRequest sub = bean.getRequest().subRequest(url);
			SchedulerContext.into(sub);
		}

		List<String> pageList = bean.getPageList();
		for (String url : pageList) {
			//继续抓取详情页
			HttpRequest sub = bean.getRequest().subRequest(url);
			SchedulerContext.into(sub);
		}
		//继续抓取下一页构造下一页
		/*int currPage = bean.getCurrPage();
		int totalPage = getTotalPage(bean.getLastPageUrl());
		if (currPage < totalPage) {
			int nextPage = currPage + 1;
			String nextUrl = "http://www.meizitu.com/tag/"+bean.getTagCode()+"_"+bean.getTagId()+"_"+nextPage+".html";
			HttpRequest request = bean.getRequest();
			SchedulerContext.into(request.subRequest(nextUrl));
		}*/
	}
	
	private int getTotalPage(String lastPageUrl) {
		if(StringUtils.isEmpty(lastPageUrl)) {
			return 1;
		}
		//http://www.meizitu.com/tag/ suxiong_17_ 9 .html
		lastPageUrl = StringUtils.substringAfterLast(lastPageUrl, "/");
		lastPageUrl = StringUtils.substringBefore(lastPageUrl, ".");
		lastPageUrl = StringUtils.substringAfterLast(lastPageUrl, "_");
		return NumberUtils.toInt(lastPageUrl, 1);
	}
}
