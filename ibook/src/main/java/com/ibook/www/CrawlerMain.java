package com.ibook.www;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.pipeline.PipelineFactory;
import com.geccocrawler.gecco.request.HttpGetRequest;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CrawlerMain implements ApplicationContextAware,InitializingBean {

	private ApplicationContext context;

	@Override
	public void afterPropertiesSet() throws Exception {
		PipelineFactory springPipelineFactory = (PipelineFactory)context.getBean("springPipelineFactory");
		HttpGetRequest start = new HttpGetRequest("https://www.miaobige.com/read/15396/1/");
		start.setCharset("GBK");
		GeccoEngine.create()
			.classpath("com.ibook.www.crawler")
			.pipelineFactory(springPipelineFactory)
			.interval(100)
			.start(start)
			.run();
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.in.read();
		context.close();
	}
}
