package com.ibook.www.Service;

import com.ibook.www.mapper.BookMapper;
import com.ibook.www.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author fanmingxin
 * @description
 * @Date 2018/6/19
 */
@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public int save(Book book){

        if(book == null){
            return -1;
        }
        book.setCreateTime(new Date());
        return bookMapper.insert(book);
    }
}
