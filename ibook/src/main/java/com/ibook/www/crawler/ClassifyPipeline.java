package com.ibook.www.crawler;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.ibook.www.Service.ClassifyService;
import com.ibook.www.model.Classify;
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
public class ClassifyPipeline implements Pipeline<ClassifyPage> {

	@Autowired
	private ClassifyService classifyService;

	@Override
	public void process(ClassifyPage bean) {
		String ids = bean.getIds();
		long channelId = Long.valueOf(ids.split("_")[0]);

		List<ClassifyItem> list = bean.getItemList();

		for(ClassifyItem item:list){
			String href = item.getHref();
			String name = item.getName();
			int offet = href.lastIndexOf("/");
			String id = href.substring(offet+1).split("_")[3];

			if("0".equals(id)){
				continue;
			}
			classifyService.save(new Classify(Long.parseLong(id),channelId,name,href));
		}
	}
}
