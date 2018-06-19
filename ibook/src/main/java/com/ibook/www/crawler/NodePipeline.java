package com.ibook.www.crawler;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.ibook.www.Service.NodeService;
import com.ibook.www.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description :
 * @Author :WeiHui.Zhang
 * @Data : 2016/3/30 11:06
 * @Version:1.0.0
 */
@Service
public class NodePipeline implements Pipeline<NodePage> {

	@Autowired
	private NodeService nodeService;

	@Override
	public void process(NodePage bean) {

		Node node = new Node(bean.getId(), bean.getBookId(), bean.getContent());
		node.setName(bean.getName());
		node.setCount(Integer.parseInt(bean.getCount() == null?"0":bean.getCount()));
		nodeService.save(node);
	}
}
