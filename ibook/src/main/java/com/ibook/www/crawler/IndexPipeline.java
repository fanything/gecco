package com.ibook.www.crawler;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.ibook.www.Service.ChannelService;
import com.ibook.www.model.Channel;
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
public class IndexPipeline implements Pipeline<IndexPage> {

	@Autowired
	private ChannelService channelService;

	@Override
	public void process(IndexPage bean) {
		List<ClassifyItem> list = bean.getItemList();

		for(ClassifyItem item:list){
			String href = item.getHref();
			String name = item.getName();
			int offet = href.lastIndexOf("/");
			String id = href.substring(offet+1,offet+2);

			if("0".equals(id)){
				continue;
			}
			channelService.save(new Channel(Long.parseLong(id),name,href));

			HttpRequest sub = bean.getRequest().subRequest(href);
			SchedulerContext.into(sub);
		}
	}
}
