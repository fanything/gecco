package com.ibook.www.crawler;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :
 * @Author :WeiHui.Zhang
 * @Data : 2016/3/30 11:06
 * @Version:1.0.0
 */
@Service
public class BookListPipeline implements Pipeline<BookListPage> {

	@Override
	public void process(BookListPage bean) {
		List<String> bookUrl = bean.getBookUrl();
		for(String url : bookUrl){
			String newUrl = url+bean.getChannelId()+"_"+bean.getClassifyId();
			HttpRequest sub = bean.getRequest().subRequest(newUrl);
			SchedulerContext.into(sub);
		}
	}
	
}
