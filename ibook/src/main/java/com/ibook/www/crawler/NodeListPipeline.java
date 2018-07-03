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
public class NodeListPipeline implements Pipeline<NodeListPage> {

	@Override
	public void process(NodeListPage bean) {
		List<String> nodeList = bean.getNodeList();

		if(nodeList !=null && nodeList.size()>0){
			for(int i=0;i<nodeList.size();i++){
				HttpRequest sub = bean.getRequest().subRequest(nodeList.get(i));
				SchedulerContext.into(sub);
			}
		}

		int page = bean.getPage();

		List<String> pageList =  bean.getPageList();

		if(pageList !=null && pageList.size()>0){
			HttpRequest sub = bean.getRequest().subRequest(pageList.get(page-1));
			SchedulerContext.into(sub);
		}
	}
}
