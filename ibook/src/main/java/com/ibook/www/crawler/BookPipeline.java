package com.ibook.www.crawler;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.ibook.www.Service.BookService;
import com.ibook.www.exec.DownloadAction;
import com.ibook.www.exec.Executors;
import com.ibook.www.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

	@Value("${local.path}")
	private String fileSavePath;

	@Value("${www.path}")
	private String wwwPath;

	private Executors executors = Executors.create();

	@Override
	public void process(BookPage bean) {
		long filename = System.currentTimeMillis();
		String localPath = fileSavePath + filename + ".jpg";
		String savePath = wwwPath + filename + ".jpg";
		Picture pic = bean.getImg();

		Book book = new Book(bean.getId(), bean.getName(), bean.getAuthor());
		book.setIntro(bean.getIntro());
		book.setWcount(Long.valueOf(bean.getWcount()));
		book.setImg(savePath);
		book.setHeight(Integer.valueOf(pic.getHeight()));
		book.setWidth(Integer.valueOf(pic.getWidth()));

		book.setChannelId(bean.getChannelId());
		book.setClassifyId(bean.getClassifyId());
		bookService.save(book);

		executors.getDefaultActionQueue().enqueue(
				new DownloadAction(executors.getDefaultActionQueue(), pic.getUrl(), localPath));

		HttpRequest sub = bean.getRequest().subRequest(bean.getUrl()+"1/");
		SchedulerContext.into(sub);
	}
	
}
